package problem.bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0;

		while (true) {
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣ 허쉬 은행");
			System.out.println("▣▣ 1. 계좌 개설");
			System.out.println("▣▣ 2. 입금");
			System.out.println("▣▣ 3. 출금");
			System.out.println("▣▣ 4. 계좌 조회");
			System.out.println("▣▣ 5. 사용자 검색");
			System.out.println("▣▣ 6. 프로그램 종료");
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");

			while (true) {
				System.out.print("▣▣ 번호 >> ");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("▣▣ 1 ~ 6 까지 올바른 값을 입력하세요.");
					continue;
				}

			}

			BankDAO bDAO = new BankDAO();
			if (code == 1) {// 개설
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣ 정보를 입력해주세요.");
				System.out.print("▣▣ 예금주명 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("▣▣ 비밀번호 >> ");
				String pw = sc.nextLine();
				
				BankDTO bDto = new BankDTO(bname, pw);
				bDao.BankInsert(bDto);
				
			} else if (code == 2) {// 입금

			} else if (code == 3) {// 출금

			} else if (code == 4) {// 조회
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 계좌정보를 조회합니다.");
				
				bDAO.BankSelect();

			} else if (code == 5) {// 검색
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("▶▶ 검색할 이름을 입력하세요.");
				System.out.print("▶▶ 이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.BankSearch(bname);

			} else if (code == 6) {// 종료
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ [프로그램 종료] ◀◀");
				System.exit(0);
			}

		}

	}

}
