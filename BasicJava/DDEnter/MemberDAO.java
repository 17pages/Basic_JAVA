package problem.DDEnter;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {
	Connection conn; //전역변수 , default값으로 초기화 객체자료형(앞글자 대문자) 은 null로 초기화, 객체생성함
	PreparedStatement pstmt;
	
	//public MemberDAO(){
      // } 만들어짐 그치만 안에 아무내용도 없기때문에 main으로 감

	// 1. 아티스트 등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();//연결정보를 가지고 있음.conn에 담음
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) " 
			             + "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";  
			pstmt = conn.prepareStatement(sql);		
			// 미완성인 sql문을 채워줌.
			pstmt.setString(1, mDto.getAname()); //(? 물음표 첫번째)
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			//미완성 SQL문 완성
			
			int result = pstmt.executeUpdate(); // 완결된 SQL문 0,1 가져옴. 이거는 내가 설정X 원래부터 이럼.
			if(result >0) {
				System.out.println("▦▦" + mDto.getAname() + " 아티스트와 계약을 등록했습니다.");
			}else {
				System.out.println("▦▦ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {//예외를 타던 말던 무조건 실행.
			
		}
	}//메서드 끝, 호출한 곳으로 돌아가기. - main 의 mDao. memInsert(mDto)

	// 2. 아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter " + "SET aname = ?, " + "   major = ?, " + "   groupyn = ?, " + "   groupnm = ?, " + "   sal = ?" + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(6, mDto.getAno());
			pstmt.setString(1, mDto.getAname()); //(? 물음표 첫번째)
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("▦▦" + mDto.getAno() + " 아티스트의 정보를 수정했습니다.");
			}else {
				System.out.println("▦▦ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

	// 3. 아티스트 삭제
	public void memDelete(String ano) {
		try {
			// 1. 드라이버 로드, 2.DB연결
			conn = DBManager.getConnection();
			// 3. SQL문작성 (PrepareStatment 방식)
			String sql = "DELETE FROM tbl_enter " + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			// 3.1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4. SQL문 실행
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▦▦" + ano + " 아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▦▦ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 4. 아티스트 조회
	public void memSelect() {
	}

	// 5. 아티스트 검색
	public void memSearch() {
	}

}
