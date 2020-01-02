package problem.board;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import problem.bank.BankDTO;

public class BoardMDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;

	List<BoardMDTO> list2;
	Connection conn;
	ArrayList<BoardMDTO> list = new ArrayList<>();
	BoardMDTO mDto;
	int result;

	public void insertBoard(String title, String content, String writer) {

		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BoardMDTO mDto = new BoardMDTO(title, content, writer);
			result = sqlSession.insert("insertBoard", mDto);
			if (result > 0) {
				System.out.println("▶▶ 게시글이 등록되었습니다.");
			} else {
				System.out.println("▶▶ 게시글 등록에 실패하였습니다. 관리자에게 문의하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();

		}
	}

	public String getWriter(int bno) {
		String user = null;
		sqlSession = sqlSessionFactory.openSession();
		try {

			user = sqlSession.selectOne("BoardMDAO.getWriter", bno);
			System.out.println("▶▶ " + user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return user;
	}

	public void updateBoard(int bno, String title, String content, String writer) {

		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		try {
			result = sqlSession.update("updateBoard", map);

			if (result > 0) {
				System.out.println("▶▶ 게시글 " + bno + "의 내용이 수정되었습니다.");

			} else {
				System.out.println("게시글 수정에 실패하였습니다. 관리자에게 문의하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteBoard(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		try {
			result = sqlSession.delete("deleteBoard", map);

			if (result > 0) {
				System.out.println("▶▶" + bno + " 번 게시글 정보를 삭제하였습니다.");
			} else {
				System.out.println("▶▶ 삭제에 실패하였습니다. 관리자에게 문의하세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void selectBoard() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list2 = sqlSession.selectList("selectBoard");
			for (BoardMDTO line : list2) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void printQuery(ArrayList<BoardMDTO> list) {
		System.out.println("==================================================");
		System.out.println("번호\t 글제목\t 내용\t 글쓴이\t 조회수\t 게시일");
		System.out.println("==================================================");
		for (BoardMDTO line : list) { // foreach문은 for(타입변수 : 배열)
			System.out.println(line.toString());
		}

	}

	public void searchBoard(String keyword) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list2 = sqlSession.selectList("searchBoard", keyword);
			System.out.println(list2.size() + " 건 이 검색되었습니다.");
			for (BoardMDTO line : list2) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void sortBoard() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list2 = sqlSession.selectList("sortBoard");
			for (BoardMDTO line : list2) {
				System.out.println(line.toString());

				System.out.println("==================================================");
				System.out.println("번호\t 제목\t 내용\t 작성자\t 조회수\t 작성일자");
				System.out.println("==================================================");

			}
			System.out.println("=====================================");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

//	public void viewBoard(int bno) {
	// sqlSession = sqlSessionFactory.openSession();

//		try {
//			list2 = sqlSession.selectList("viewBoard");
	// for (BoardMDTO line : list2) {
	// System.out.println(line.toString());

	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// sqlSession.close();
	// }

	// }

	// public void viewcntPlus(int bno) {
	// sqlSession = sqlSessionFactory.openSession();
//
	// try {

	// list2 = sqlSession.selectList("viewcntpuls");
	// for (BoardMDTO line : list2) {
	// System.out.println(line.toString());

	// }

	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// sqlSession.close();
	// } retrun list2;
	// }
	// public void printQuery() {}

}
