package problem.fafatouch;

import java.util.Scanner;

public class FaFaMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//메인메뉴를 저장하는 5칸짜리 배열 생성
		String[][] mainMenu = new String[5][2] ;
		//[5][2] 
		//[5]는 메뉴 5개
		//[2]는 메뉴이름/ 가격
		
		mainMenu[0][0] = "파파버거";
		mainMenu[1][0] = "맥치킨버거";
		mainMenu[2][0] = "와퍼버거";
		mainMenu[3][0] = "싸이버거";
		mainMenu[4][0] = "빅맥버거";
		mainMenu[0][1] = "4500";
		mainMenu[1][1] = "5500";
		mainMenu[2][1] = "6000";
		mainMenu[3][1] = "4700";
		mainMenu[4][1] = "5500";
	
		
		
		
		//= {"파파버거", "맥치킨버거", "와퍼버거", "싸이버거", "빅맥버거"};
		//사이드메뉴를 저장하는 5칸짜리 배열 생성
		String[][] sideMenu = new String[5][2];
		
		sideMenu[0][0] = "감자튀김";
		sideMenu[1][0] = "양념감자";
		sideMenu[2][0] = "치즈스틱";
		sideMenu[3][0] = "맥너겟";
		sideMenu[4][0] = "스위트콘";
		sideMenu[0][1] = "1500";
		sideMenu[1][1] = "2000";
		sideMenu[2][1] = "2000";
		sideMenu[3][1] = "2500";
		sideMenu[4][1] = "1700";
		
		
		//= {"감자튀김", "양념감자", "치즈스틱" ,"맥너겟", "스위트콘"};
		//음료메뉴를 저장하는 5칸짜리 배열 생성
		String[][] drinkMenu = new String[5][2];
		
		drinkMenu[0][0] = "코카콜라";
		drinkMenu[1][0] = "스프라이트";
		drinkMenu[2][0] = "마운틴듀";
		drinkMenu[3][0] = "오렌지쥬스";
		drinkMenu[4][0] = "초코쉐이크";
		drinkMenu[0][1] = "1500";
		drinkMenu[1][1] = "1200";
		drinkMenu[2][1] = "1600";
		drinkMenu[3][1] = "2000";
		drinkMenu[4][1] = "2500";
		
		//= {"코카콜라", "스프라이트", "마운틴듀", "오렌지쥬스", "초코쉐이크"};
		
		
		
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒ 파파터치 주문프로그램");
		System.out.println("▒▒ ==메인메뉴==");
		System.out.println("▒▒ 1. 파파버거");
		System.out.println("▒▒ 2. 맥치킨버거");
		System.out.println("▒▒ 3. 와퍼버거");
		System.out.println("▒▒ 4. 싸이버거");
		System.out.println("▒▒ 5. 빅맥버거");
		System.out.print("▒▒ 번호>> ");
		//사용자가 주문한 메인메뉴 번호!
		int mainNum = sc.nextInt();
		
		System.out.println("▒▒ ==사이드메뉴==");
		System.out.println("▒▒ 1. 감자튀김");
		System.out.println("▒▒ 2. 양념감자");
		System.out.println("▒▒ 3. 치즈스틱");
		System.out.println("▒▒ 4. 맥너겟");
		System.out.println("▒▒ 5. 스위트콘");
		System.out.print("▒▒ 번호>> ");
		//사용자가 주문한 사이드메뉴 번호!
		int sideNum = sc.nextInt();
		
		System.out.println("▒▒ ==음료==");
		System.out.println("▒▒ 1. 코카콜라");
		System.out.println("▒▒ 2. 스프라이트");
		System.out.println("▒▒ 3. 마운틴듀");
		System.out.println("▒▒ 4. 오렌지쥬스");
		System.out.println("▒▒ 5. 초코쉐이크");
		System.out.print("▒▒ 번호>> ");
		//사용자가 주문한 음료메뉴 번호!
		int drinkNum = sc.nextInt();
		
		
		//총주문금액 계산
		//메인메뉴가격 mainMenu[mainNum-1][1]<-1번은 가격
		//사이드메뉴가격 sideMenu[mainNum-1][1]
		//음료메뉴가격 drinkMenu[mainNum-1][1]
		
		int mPrice = Integer.parseInt(mainMenu[mainNum-1][1]);
		int sPrice = Integer.parseInt(sideMenu[sideNum-1][1]);
		int dPrice = Integer.parseInt(drinkMenu[drinkNum-1][1]);
		int totPrice = mPrice + sPrice + dPrice;
		//출력
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒ 고객님께서 주문하신 메뉴는 ");
		System.out.println("▒▒" + mainMenu[mainNum-1][0]); // 메인메뉴
		System.out.println("▒▒" + sideMenu[sideNum-1][0]); // 사이드메뉴
		System.out.println("▒▒" + drinkMenu[drinkNum-1][0]); // 음료메뉴
		System.out.println("▒▒ 총 금액은 " + totPrice + "원 입니다.");
		System.out.println("▒▒ 주문하시겠습니까?");
		
		
		
	}
			
		
		
	

}
