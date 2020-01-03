package market;

import java.util.Scanner;

public class MarketMain {
	// 내부저장소
	// 관리자 계정 ID와 PW선언
	String id = "admin";
	String pw = "1234";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarketMain mm = new MarketMain();
		Boolean flag = false;
		int code = 0;

		String userid = "";
		String userpw = "";

		System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
		System.out.println("▥▥ Market System Ver1.0");

		// 로그인 체크
		 do {
		 System.out.println("▥▥ [Msg] Please login to use.");
		 System.out.println("▥▥ ID>> ");
		 userid = sc.nextLine();
		 System.out.println("▥▥ PW >> ");
		 userpw = sc.nextLine();

		 } while (mm.login(userid, userpw));

		// 로그인 성공 업무 시작

		while (true) {
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
			pDao.selectProduct();
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
			System.out.println("▥▥ 1. 제품 판매");
			System.out.println("▥▥ 2. 제품 등록 & 추가");
			System.out.println("▥▥ 3. 제품 수정");
			System.out.println("▥▥ 4. 제품 삭제");
			System.out.println("▥▥ 5. 제품 조회");
			System.out.println("▥▥ 6. 제품 검색");
			System.out.println("▥▥ 7. 일일 매출 현황");
			System.out.println("▥▥ 8. 프로그램 종료");
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");

			System.out.println("▥▥ Code >> ");
			code = sc.nextInt();

			while (true) {
				if (code >= 1 && code <= 8) {
					break;
				} else {
					System.out.println("▥▥ [Msg] Pleas enter a valid value.");
					continue;
				}

			}

			if (code == 1) {//판매

			} else if (code == 2) {
			
				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥ 제품명 : ");
				sc.nextLine();
				String pname = sc.nextLine();

				if (pDao.pdtAlready(pname)) {

					// 기본에 등록된 제품임으로 추가(UPDATE) 기능
					// 입고수량 입력받아서 update
					System.out.println("▥▥ 추가수량 >> ");
					int cnt = sc.nextInt();
 				System.out.println("▥▥ " + pname + "의 제품이 " + cnt + "개 추가 입고 되었습니다.");

					pDao.cntPlusPdt(pname, cnt);
					
				} else {
					System.out.println("▥▥ company >> ");
					String company = sc.nextLine();
					System.out.println("▥▥ price >> ");
					int price = sc.nextInt();
					System.out.println("▥▥ 수량 >> ");
					int cnt = sc.nextInt();
					// 최초 등록된 제품임으로 등록(INSERT)기능
					// 제조회사, 가격, 입고수량 입력받아서 Insert
					pDao.insertPdt(pname, company, price, cnt);
				}

			} else if (code == 3) {//수정
				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥ 수정할 제품명을 입력해주세요.");
				System.out.println("▥▥ 제품명 >> ");
				sc.nextLine();
				String pname = sc.nextLine();
			    System.out.println("▥▥ 가격 >> ");
				int price = sc.nextInt();
				
				
				//if() {
					
					
				//	System.out.println("▥▥ " + pname + "의 제품을 수정했습니다.");
			//	}else{
			//		System.out.println("제품 수정에 실패했습니다. 관리자에게 문의하세요.");
			//	}
				
				pDao.updateProduct(pname, price);

			} else if (code == 4) {//삭제
				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥ 삭제할 제품명을 입력해주세요.");
				System.out.println("▥▥ 제품명 >> ");
				sc.nextLine();
				String pname = sc.nextLine();
				
				pDao.deleteProduct(pname);
				

			} else if (code == 5) {//조회
				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥ 제품을 조회합니다.");
				pDao.selectProduct();
				

			} else if (code == 6) {//검색
				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥ 검색할 제품명을 입력하세요.");
				System.out.println("▥▥ 제품명 >> ");
				sc.nextLine();
				String keyword = sc.nextLine();
				pDao.searchProduct(keyword);

			} else if (code == 7) {

			} else if (code == 8) {

				System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
				System.out.println("▥▥▶ [Msg] Exit the program. ◀▥▥");
				System.exit(0);

			}

		}
	}

	public boolean login(String userid, String userpw) {
		Boolean flag = true; // 로그인 유무 판별 (true : 실패, false : 성공)

		if (userid.contentEquals(id) && userpw.equals(pw)) { // 로그인 성공
			flag = false;
			System.out.println("▥▥ 환영합니다. 관리자님");
		} else {
			System.out.println("▥▥ [Msg] Login denied.");

		}
		return flag;
	}

}
