package problem.DDBoard;

import java.util.Scanner;

public class DDBoardMain {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호
//위는 딱 1번만 생성
		
		
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("▶▶ 더블디 게시판");
			bDao.BoardSelect(); // 게시판 목록이 바로 뜨게 함.
			System.out.println("▶▶ 1. 게시글 등록");
			System.out.println("▶▶ 2. 게시글 수정");
			System.out.println("▶▶ 3. 게시글 삭제");
			System.out.println("▶▶ 4. 게시글 조회");
			System.out.println("▶▶ 5. 게시글 검색");
			System.out.println("▶▶ 6. 게시글 정렬");
			System.out.println("▶▶ 7. 상세 게시글");
			System.out.println("▶▶ 8. 만든이");
			System.out.println("▶▶ 9. 프로그램 종료");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
			
			while (true) { // 번호 누르는거
				System.out.print("▶▶ 번호>> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("▶▶ 1 ~ 9까지 올바른 값을 입력하세요.");
					continue;
				}
			} 
			
			BoardDAO bDAO = new BoardDAO();
			if(code == 1) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 등록할 게시글 정보를 입력해주세요.");
				System.out.print("▶▶ 제목 >>");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용 >>");
				String content = sc.nextLine();
				System.out.print("▶▶ 작성자 >>");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(title, content, writer);
				bDAO.BoardInsert(bDto);
				
			}else if (code ==2) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 수정할 게시글 번호를 입력해주세요.");
				System.out.print("▶▶ 번호 >>");
				int bno = sc.nextInt();
				System.out.print("▶▶ 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용 >> ");
				String content = sc.nextLine();
				System.out.print("▶▶ 작성자 >> ");
				String writer = sc.nextLine();
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer); 
				bDAO.BoardUpdate(bDto);
				
			}else if (code ==3) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 삭제할 게시글 번호를 입력해주세요.");
				System.out.print("▶▶ 번호 >>");
				sc.nextLine();
				int bno = sc.nextInt();
				bDao.BoardDelete(bno);
				
				
			}else if (code ==4) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 게시판을 조회합니다.");
				
				bDAO.BoardSelect();
				
			}else if (code ==5) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 게시판을 검색합니다.");
				System.out.print("▶▶ 글 제목 >> ");
				sc.nextLine();
				String title = sc.nextLine();
				bDao.BoardSerach(title);
				
			}else if(code ==6) {
				
			}else if(code ==7) {
				
			}else if(code ==8) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ Name : DD Board Program");
				System.out.println("▶▶ Version : 1.7");
				System.out.println("▶▶ Use : JAVA, ORACLE");
				System.out.println("▶▶ Date : 2019.12.17");
				System.out.println("▶▶ by 17pages");
				System.out.println("▶▶ cottondg100@gmail.com");
				
			}else if(code == 9) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ [프로그램 종료] ◀◀");
				System.exit(0);
				
			}
		}
	}
}