package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import problem.common.DBManager;

public class BankDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;
	int result;

	public void BankInsert(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno, bname, pw) " 
			           + "VALUES(seq_bank.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▶▶" + bDto.getBname() + "을 등록했습니다.");
			} else {
				System.out.println("▶▶ 등록에 실패하였습니다. 다시 입력해 주세요.");
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

	public void BankUpdate() {
	}

	public void BankDelete() {
	}

	public void BankSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list.clear();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");
				
				BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
						
			}
			printQuery(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{ 
			try {
				conn.close();
				pstmt.close();
			}catch (Exception e2){
				e2.printStackTrace();
			}
			
		}
		
	}

	public void BankSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " 
					   + "FROM tbl_bank "
					   + "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%");
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			list.clear();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");
				
				BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
				
			} 
			printQuery(list);
			System.out.println("===========================================");
			int size = list.size();
			System.out.println("==\"" + bname + "\"검색결과" + size + " 가 검색되었습니다.");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

	public void printQuery(ArrayList<BankDTO> list) {
		System.out.println("==================================================");
		System.out.println("번호\t 예금주\t \t 비밀번호\t 잔금\t 거래일자");
		System.out.println("==================================================");
		for (BankDTO line : list) { // foreach문은 for(타입변수 : 배열)
			System.out.println(line.toString());
	}
	}
}
