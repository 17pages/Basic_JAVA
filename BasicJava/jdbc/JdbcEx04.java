package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();

		//15-17줄 db랑 무슨 작업을 하든 꼭 씀
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "java";
		String password = "1234";

		//꼭 들어가는 코드들 따로 빼두기
		try {
			//21-22줄도 db랑 작업하면 꼭씀 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "DELETE FROM tbl_study " + "WHERE sname = ?"; //study뒤에 한칸 띄어야 함~ 
			// 안 띄우면 DELETE FROM tbl_studyWHERE sname = ? 이라고 인식되어버림.
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
					

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
