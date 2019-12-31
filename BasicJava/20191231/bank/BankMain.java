package problem.bank;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		BankDTO bDto = new BankDTO();
		int code = 0;

		while (true) {
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣ 허쉬 은행");
			System.out.println("▣▣ 1. 계좌 개설");
			System.out.println("▣▣ 2. 계좌 해지");
			System.out.println("▣▣ 3. 입금");
			System.out.println("▣▣ 4. 출금");
			System.out.println("▣▣ 5. 고객 조회");
			System.out.println("▣▣ 6. 계좌 조회");
			System.out.println("▣▣ 7. 사용자 검색");
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

			BankDAO bDAO = new BankDAO();
			if (code == 1) {// 개설
				//System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				//System.out.println("▣▣ 정보를 입력해주세요.");
				//System.out.print("▣▣ 예금주명 >> ");
				//sc.nextLine();
				//String bname = sc.nextLine();
				//System.out.print("▣▣ 비밀번호 >> ");
				//String pw = sc.nextLine();

				//bDto = new BankDTO(bname, pw);
				//bDao.BankInsert(bDto);
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ 신규계좌를 개설합니다. 값을 입력해주세요.");
				System.out.print("▶▶ 계좌주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("▶▶패스워드 >> ");
				String pw = sc.nextLine();
				
				bDao.insertBank(bname, pw);
				
				
			}else if (code ==2) {//계좌 삭제
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ 계좌를 해지합니다. 값을 입력해주세요.");
				System.out.print("▶▶ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("▶▶패스워드 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				
				bDao.deleteBank(bno, pw);
				
				
				
				
			}else if (code == 3) {// 입금

				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣ 입금할 금액과 계좌를 입력해주세요 ");
				System.out.print("▣▣ 입금액 >> ");
				int money = sc.nextInt();
				System.out.print("▣▣ 계좌번호 >> ");
				int bno = sc.nextInt();

				
				bDAO.updateBank(bno, money);

			} else if (code == 4) {// 출금
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣ 출금할 계좌 번호와 비밀번호를 입력해주세요.");
				System.out.print("▶▶ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("▶▶ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				
				if(bDao.checkUser(bno, pw)) {
					int balance = bDao.balanceMoney(bno); //잔액
					
					System.out.println("▶▶ 잔액 : " + balance);
					
					//체크를 통과한 경우에만 값을 출금하게 작성
					System.out.println("출금하실 금액을 입력해주세요.");
					System.out.println("▶▶ 출금액 >> ");
					int money = sc.nextInt();
					
					//잔액 - 출금액 = 0 >>출금
					//잔액 > 출금액 = 잔액-출금액 >>출금
					//잔액 < 출금액 = 잘못입력 >>경고메시지
					
					if(balance < money) {
						System.out.println("▶▶ 잔액이 부족합니다. 확인해주세요.");
					}else {
						bDao.minusMoney(bno, money);
					}
					
										
					
				}else{
					System.out.println("▶▶ 존재하지 않는 계좌 번호이거나 암호가 틀렸습니다.");
					
				

				// db에 있던 정보확인해서 있는지 확인하기
				}
			}else if(code == 5) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ 고객을 조회합니다.");
				
			}else if (code == 6) {// 계좌 조회 (1건)
				//계좌번호, 패스워드
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ 계좌정보를 조회합니다. 계좌번호와 암호를 입력하세요.");
				System.out.print("▶▶ 계좌 번호 >> ");
				int bno = sc.nextInt();
				System.out.print("▶▶ 패스워드 >> ");
				sc.nextLine();
				String pw = sc.nextLine();
				// System.out.println(bno + ", " + pw); 테스트할때

				bDao.selectAccount(bno, pw);

			} else if (code == 7) {// 검색
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ 검색할 이름을 입력하세요.");
				System.out.print("▶▶ 이름 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				bDao.BankSearch(bname);

			} else if (code == 8) {// 종료
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▶▶ [프로그램 종료] ◀◀");
				System.exit(0);
			}

		}

	}
}
