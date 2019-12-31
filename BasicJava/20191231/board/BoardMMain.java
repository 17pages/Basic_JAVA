package problem.board;

import java.util.Scanner;

public class BoardMMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardMDAO mDao = new BoardMDAO();
		
		int code = 0;

		while (true) {
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣ 허쉬 게시판");
			System.out.println("▣▣ 1. 게시글 등록");
			System.out.println("▣▣ 2. 게시글 수정");
			System.out.println("▣▣ 3. 게시글 삭제");
			System.out.println("▣▣ 4. 게시글 조회");
			System.out.println("▣▣ 5. 게시글 검색");
			System.out.println("▣▣ 6. 게시글 정렬");
			System.out.println("▣▣ 7. 상세 게시글");
			System.out.println("▣▣ 8. 프로그램 종료");
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			while (true) {
				System.out.print("▣▣ 번호 >> ");
				code = sc.nextInt();

				if (code >= 1 && code <= 8) {
					break;
				} else {
					System.out.println("▣▣ 1 ~ 8 까지 올바른 값을 입력하세요.");
					continue;
				}
			}
			BoardMDAO mDAO = new BoardMDAO();

			if (code == 1) {//등록
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 등록할 게시글 정보를 입력해주세요.");
				System.out.print("▶▶ 제목 >>");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용 >>");
				String content = sc.nextLine();
				System.out.print("▶▶ 작성자 >>");
				String writer = sc.nextLine();
								
				mDao.insertBoard(title, content, writer);

			} else if (code == 2) {//수정
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
				
				mDao.updateBoard(bno,title, content, writer);

			} else if (code == 3) {//삭제

			} else if (code == 4) {//조회

			} else if (code == 5) {//검색

			} else if (code == 6) {//정렬

			} else if (code == 7) {//상세게시글

			} else if (code == 8) {//종료
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ [프로그램 종료] ◀◀");
				System.exit(0);
			}

		}

	}
}
