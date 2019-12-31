package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import problem.common.DBManager;

public class BankDAO {
	
	//MyBatis 세팅값 호출
	//sqlmapconfig = session을 생성하는 공장을 만드는 과정
	
			SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession(); 
			
			//mapper에 접근하기 위한 SqlSession
			SqlSession sqlSession;
			
			
			
			List<BankDTO> list2;
	

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;
	int result;

	//public void BankInsert(BankDTO bDto) {
		//try {
			//conn = DBManager.getConnection();
			//String sql = "INSERT INTO tbl_bank(bno, bname, pw) " 
			  //         + "VALUES(seq_bank.NEXTVAL, ?, ?)";
			//pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, bDto.getBname());
			//pstmt.setString(2, bDto.getPw());

			//int result = pstmt.executeUpdate();
			//if (result > 0) {
				//System.out.println("▶▶" + bDto.getBname() + "을 등록했습니다.");
			//} else {
				//System.out.println("▶▶ 등록에 실패하였습니다. 다시 입력해 주세요.");
			//}

		//} catch (Exception e) {
			//e.printStackTrace();
		//} finally {
			//try {
			//	conn.close();
			//	pstmt.close();

			//} catch (Exception e2) {
			//	e2.printStackTrace();
			//}
		//}
	
	//신규계좌 개설
	
		public void insertBank(String bname, String pw) {
			sqlSession = sqlSessionFactory.openSession(true); // true가 자동커밋해줌
			try {
				BankDTO bDto = new BankDTO(bname, pw);
				result = sqlSession.insert("insertBank", bDto);
				
				
				if(result>0) {
					System.out.println("▶▶ " + bname + "님 신규계좌를 개설하였습니다.");
				}else {
					System.out.println("▶▶ 계좌개설에 실패하였습니다. 관리자에게 문의하세요.");
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
	
	}
		public void updateBank(int bno, int money) {
			sqlSession = sqlSessionFactory.openSession(true);

			HashMap<String, Integer> map = new HashMap<>();//<>안에는 레퍼런스타입(객체자료형)밖에 못들어옴
			map.put("bno", bno);
			map.put("money", money);
			map.put("flag", 1);//동적쿼리(입금 or 출금유무)
			try {
				
				result = sqlSession.update("changeMoney", map);
				
				if(result>0) {
					System.out.println("계좌 " + bno + "에 " + money + " 원을 입금했습니다.");
					System.out.println("현재 계좌 잔액은 " + balanceMoney(bno) + "입니다.");
				}else {
					System.out.println("입금에 실패하였습니다. 관리자에게 문의하세요.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}

	//public void BankUpdate(BankDTO bDto) {
		//try {
		//	conn = DBManager.getConnection();
			//String sql = "UPDATE tbl_bank " + "SET money = money + ? " + "WHERE bno = ?";
			//pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, bDto.getMoney());
			//pstmt.setInt(2, bDto.getBno());

			//int result = pstmt.executeUpdate();
			//if (result > 0) {
				//System.out.println(bDto.getMoney() + "원이 입금되었습니다");
		//	} else {
			//	System.out.println("입금오류");
			//}

		//} catch (Exception e) {
			//e.printStackTrace();
		//}
	//}
		
		public void deleteBank(int bno, String pw) {
			sqlSession = sqlSessionFactory.openSession(true);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("pw", pw);
			try {
				result = sqlSession.delete("deleteBank", map);
				
				if(result >0) {
					System.out.println("▶▶ " + bno + " 계좌를 해지 하였습니다.");
				}else {
					System.out.println("▶▶ 계좌 해지에 실패하였습니다. 관리자에게 문의하세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
				
			}
		}

	public void minusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 0);
		
		try {
			result = sqlSession.update("changeMoney",map);
			if(result>0) {
				System.out.println("▶▶ 계좌 " + bno + "에서 " + money + " 원을 출금했습니다.");
				System.out.println("현재 계좌 잔액은 " + balanceMoney(bno) + "입니다.");
			}else {
				System.out.println("출금에 실패하였습니다. 관리자에게 문의하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
				
	}

	public void selectBank() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list2 = sqlSession.selectList("selBank");
			
			for (BankDTO line : list2) {
				System.out.println(line.toString());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
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
	
	//public int checker(int bno, String pw) {
		//int result = 0 ;
		//try {
			//conn = DBManager.getConnection();
			//String sql = "SELECT bno, pw " 
				//	   + "FROM tbl_bank";
	//		pstmt = conn.prepareStatement(sql);
		//	rs = pstmt.executeQuery();
			
		//	while (rs.next()) {
			//	int bno2 = rs.getInt("bno");
				//String pw2 = rs.getString("pw");
//				//System.out.println(bno2);
//				//System.out.println(pw2);
				//if (bno2 == bno && pw2.equals(pw)) {
					//result = 1;
					//break;
		//		} 
			//}
			
		//} catch (Exception e) {
			//e.printStackTrace();
	//	}
		//return result;
	//}
	
	//public int moneyChecker(int bno, int money) {
		//int result = 0 ;
		//try {
			//conn = DBManager.getConnection();
			//String sql = "SELECT money "
				//	   + "FROM tbl_bank "
					//   + "WHERE bno = ?";
//			pstmt = conn.prepareStatement(sql);
	//		pstmt.setInt(1, bno);
		//	rs = pstmt.executeQuery();
			
			//while(rs.next()) {
				//if(money <= rs.getInt("money")){
					//result = 1;
					//break;
				//} 
		//	}
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		//return result;
	//}
	
	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto); //(, 한개밖에 못씀)
			
			if(bDto == null) {
				System.out.println("▶▶ 존재하지 않는 계좌번호 입니다.");
				return;
			} else {
			System.out.println("▶▶ " + bno + "계좌의 총 금액은 " + bDto.getMoney() + " 입니다.");
			//selectOne => DTO
			//selectList => LIST or DTO
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}
	
	//계좌 잔액 조회
	
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			
			money = sqlSession.selectOne("balanceMoney", bno);
			System.out.println(">>>>>>>>>>>> " + money);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return money;
	}
	
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.selectOne("checkUser", map);
			if(result>0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return flag;
	}
}


//public void selctBank() {
//try {
	//conn = DBManager.getConnection();
	//String sql = "SELECT * FROM tbl_bank ";
	//pstmt = conn.prepareStatement(sql);
//	rs = pstmt.executeQuery();
	
//	list.clear();
	
	//while(rs.next()) {
	//	int bno = rs.getInt("bno");
	//	String bname = rs.getString("bname");
	//	String pw = rs.getString("pw");
	//	int money = rs.getInt("money");
	//	Date regdate = rs.getDate("regdate");
		
	//	BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
	//	list.add(bDto);
				
//	}
//	printQuery(list);
	
//} catch (Exception e) {
	//e.printStackTrace();
//}finally{ 
//	try {
//		conn.close();
//		pstmt.close();
//	}catch (Exception e2){
//		e2.printStackTrace();
//	}
	
//}

//}
