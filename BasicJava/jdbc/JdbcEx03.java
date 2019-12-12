package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();

		// 자바를 연결하기 위해 세팅해놓은 값
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		//String user = "java";
		//String password = "1234";

		// 예외가 발생할 수도 있는 부분
		try { 
			//Class.forName("oracle.jdbc.driver.OracleDriver"); // 동적객체, reflection 오라클 드라이버를 쓴다고 자바에게 명시함
			Connection conn = DBManager.getConnection();
			//Connection conn = DriverManager.getConnection(url, user, password);
			// 자바와 오라클이 연결하는 곳 connection ()안에 매개변수로 세팅해놓은거 넣음 conn에 정보를 넣어줌~

			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)"; // 그냥 변수에 담은 것뿐 sql문을 sql이란 변수에 담음
			// ? <= 바인딩 변수
			PreparedStatement pstmt = conn.prepareStatement(sql); // prepareStatement 값을 동적으로 바꿀 수 있게 함. 내가 원하는 값을 넣을 수 있는 것
			// conn <- 내가 명령을 내릴거임~ prepareStatement라는 명령문~ 그안에 sql이라는 명령 
			//sql에 이거이거 넣을거임~
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);

			int result = pstmt.executeUpdate(); // 자바가 db에게 명령내리는 것. pstmt를 실행 (executeUpdate)
			if (result > 0) { // 0은 실패 1은 성공
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
