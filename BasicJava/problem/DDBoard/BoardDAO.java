package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;// 밖으로 빼둔 이유..
	ArrayList<BoardDTO> list = new ArrayList<>();
	BoardDTO bDto;
	int result;

	public void BoardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) " 
					   + "VALUES(seq_enter.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▶▶" + bDto.getTitle() + "을 등록했습니다.");
			} else {
				System.out.println("▶▶ 등록에 실패하였습니다. 관리자에게 문의해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void BoardUpdate(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + "SET title = ?, " + " content =?, " + " writer =? " + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▶▶" + bDto.getTitle() + "게시글을 수정했습니다.");
			} else {
				System.out.println("▶▶ 수정에 실패했습니다. 관리자에게 문의 해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void BoardDelete(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board " + "WHERE bno =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▶▶" + bno + "게시글 정보를 삭제하였습니다.");
			} else {
				System.out.println("▶▶ 삭제에 실패하였습니다. 관리자에게 문의하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void BoardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "ORDER BY bno DESC";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {// rs에 옮겨담는 작업
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			printQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void BoardSerach(String keyword) { // 검색은 게시글 제목으로
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + "FROM tbl_board " + "WHERE title LIKE ? OR " + "content LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			list.clear();

			while (rs.next()) {
				String title = rs.getString("title");
				int bno = rs.getInt("bno");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			int size = list.size();
			System.out.println("◎◎\"" + keyword + "\"검색결과 " + size + " 건이 발견되었습니다.");
			printQuery(list);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void BoardSort() {// 정렬
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " 
					   + "ORDER BY regdate DESC";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			list.clear();

			while (rs.next()) {// rs에 옮겨담는 작업
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				list.add(bDto);
			}
			System.out.println("==================================================");
			System.out.println("번호\t 제목\t 내용\t 작성자\t 조회수\t 작성일자");
			System.out.println("==================================================");
			for (BoardDTO line : list) { // foreach문은 for(타입변수 : 배열)
				System.out.println(line.toString());
			}
			System.out.println("==================================================");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();

			}

		}

	}

	public void BoardView(int bno) { // 상세게시는 1건만 검색

		// 상세게시글 조회수 +1증가
		int result = viewCntPlus(bno);
		if (!(result > 0)) {
			System.out.println("♬ 조회수 증가 실패, 관리자에게 문의하세요.");
			return;
		}

		// 상세게시글 출력
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + "FROM tbl_board " + "WHERE bno = ?"; // 무조건 데이터 한건만뜸
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				bno = rs.getInt("bno");
				String title = rs.getNString("title");
				String content = rs.getNString("content");
				String writer = rs.getNString("writer");
				int viewcnt = rs.getInt("viewcnt");
				Date regdate = rs.getDate("regdate");
				bDto = new BoardDTO(bno, title, content, writer, viewcnt, regdate);
				// list.add(bDto);
				// 1줄 만 들어오는거라 필요가 없음.
			}
			System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
			System.out.println("◈◈ 게시글 번호 : " + bno);
			System.out.println("◈◈ 작성일자 : " + bDto.getRegdate());
			System.out.println("◈◈ 조회수 : " + bDto.getViewcnt());
			System.out.println("◈◈ 제목 : " + bDto.getTitle());
			System.out.println("◈◈ 작성자 : " + bDto.getWriter());
			System.out.println("◈◈ 내용 : " + bDto.getContent());
			System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");

		} catch (Exception e) {
		} finally {

		}
	}

	public int viewCntPlus(int bno) {// 조회수 관련 메서드
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + "   SET viewcnt = viewcnt + 1 " + " WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return result; // result의 타입에 맞추기 // result값을 retrun

	}
	
	//조회된 결과를 출력함수
	public void printQuery(ArrayList<BoardDTO> list) {
		System.out.println("==================================================");
		System.out.println("번호\t 제목\t 내용\t 작성자\t 조회수\t 작성일자");
		System.out.println("==================================================");
		for (BoardDTO line : list) { // foreach문은 for(타입변수 : 배열)
			System.out.println(line.toString());
		}
		System.out.println("==================================================");

	}

}
