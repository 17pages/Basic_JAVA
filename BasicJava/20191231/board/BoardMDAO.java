package problem.board;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardMDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;

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
	 public void updateBoard (int bno, String title, String content, String writer) {
		 sqlSession = sqlSessionFactory.openSession(true);
		 HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("title", title);
			map.put("content", content);
			map.put("write", writer);
		 try {
			 result = sqlSession.update("updateBoard", map);
			 
			 if(result>0) {
				 System.out.println("▶▶ 게시글 " + bno + "의 내용이 수정되었습니다.");
				 
			 }else {
				 System.out.println("게시글 수정에 실패하였습니다. 관리자에게 문의하세요.");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		 
	 }
	
		 
	 
		// public void deleteBoard() {}
		// public void selectBoard() {}
		// public void searchBoard() {}
		// public void sortBoard() {}
		// public void viewBoard() {}
		// public void viewcntPlus() {}
		// public void printQuery() {}

	


}
