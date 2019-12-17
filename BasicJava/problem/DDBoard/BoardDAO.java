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

	public void BoardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) " + "VALUES(seq_enter.NEXTVAL, ?, ?, ?)";
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
			String sql = "SELECT * FROM tbl_board";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {// rs에 옮겨담는 작업
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
			}
			System.out.println("==================================================");
			System.out.println("번호\t 제목\t 내용\t 작성자\t 작성일자");
			System.out.println("==================================================");
			for (BoardDTO line : list) { // foreach문은 for(타입변수 : 배열)
				System.out.println(line.toString());
			}
			System.out.println("===================================================");

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

	public void BoardSerach(String title) { // 검색은 게시글 제목으로
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "WHERE title LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			list.clear();

			while (rs.next()) {
				title = rs.getNString("title");
				int bno = rs.getInt("bno");
				String content = rs.getNString("content");
				String writer = rs.getNString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
			}
			for (BoardDTO line : list) {
				System.out.println(line.toString());
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

	public void BoardView() {
	}

	public void BoardSort() {
	}

}
