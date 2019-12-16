package problem.dotorybook;

import java.sql.Date;
import java.util.Scanner;

public class DotoryBookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			System.out.println("◎◎ 도토리 서점 관리 시스템 Ver1.2");
			System.out.println("◎◎ 1. 도서 등록");
			System.out.println("◎◎ 2. 도서 수정");
			System.out.println("◎◎ 3. 도서 삭제");
			System.out.println("◎◎ 4. 도서 조회");
			System.out.println("◎◎ 5. 도서 검색");
			System.out.println("◎◎ 6. 만든이");
			System.out.println("◎◎ 7. 프로그램 종료");
			System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
			int code = 0;
			while (true) {
				System.out.print("◎◎번호>> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 7) {
					break;
				} else {
					System.out.println("◎◎ 1~7까지 올바른 값을 입력하세요.");
					continue;
				}
			}
			
			BookDAO bDao = new BookDAO();
			if (code == 1) {//등록
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 등록할 도서 정보를 입력해주세요.");
				System.out.print("◎◎ 이름 >>");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("◎◎ 가격 >>");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("◎◎ 출판사 >>");
				String company = sc.nextLine();
				System.out.print("◎◎ 저자 >>");
				String writer = sc.nextLine();
				BookDTO bDto = new BookDTO(bname, price, company, writer);
				bDao.bookInsert(bDto);

			} else if (code == 2) {//수정
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 수정할 도서번호를 입력해주세요.");
				System.out.print("◎◎ 번호 >>");
				sc.nextLine();
				String bno = sc.nextLine();
				System.out.print("◎◎ 도서명 >>");
				String bname = sc.nextLine();
				System.out.print("◎◎ 가격 >>");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.print("◎◎ 출판사 >>");
				String company = sc.nextLine();
				System.out.print("◎◎ 저자 >>");
				String writer = sc.nextLine();
				
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer);
				bDao.bookUpdate(bDto);
				
			} else if (code == 3) {//삭제
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 삭제할 도서번호를 입력해주세요.");
				System.out.print("◎◎ 번호 >>");
				sc.nextLine();
				String bno = sc.nextLine();
				bDao.bookDelete(bno);

			} else if (code == 4) {//조회
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 현재 판매중인 도서목록을 출력합니다.");
				
				bDao.bookSelect();

			} else if (code == 5) {//검색
				System.out.println("◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎◎");
				System.out.println("◎◎ 검색할 도서의 이름을 검색합니다.");
				System.out.print("◎◎ 책이름>> ");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.bookSearch(bname);

			} else if (code == 6) {//만든이

			} else if (code == 7) {
				System.out.println("◎◎ 프로그램 종료◎◎");
				System.exit(0);
			}

		}
	}
}
