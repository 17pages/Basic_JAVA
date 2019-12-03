/*
 * desc : Array를 사용하여 주차공간을 만들고 차량을 입고 또는 출고하는 주차타워 프로그램
 * writer : YM
 * date : 2019.12.03
 */

package problem;

import java.util.Scanner;

public class EZparkingMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Parking park = new Parking(); //생성자 1. 객체생성 2. 1회 기능(default생성자)

		while (true) { //반복횟수가 정해져있지 않을때, true를 쓴다면 break역할하는걸 써줘야함.
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ EZ Parking Ver1.5");
			System.out.print("▒▒ Car Number>>");
			int car = sc.nextInt(); // 주차타워를 이용할 차량번호

			int code = 0; // 사용자가 선택한 번호!
			while (true) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ 1. 차량입고");
				System.out.println("▒▒ 2. 차량출고");
				System.out.println("▒▒ 3. 취소");
				System.out.print("▒▒ 선택>> ");
				code = sc.nextInt(); // 입고, 출고, 취소

				if (code > 3 || code < 1) {
					System.out.println("▒▒ 올바른 값을 입력하세요.");
					continue;
				} else { // code가 1,2,3인 경우
					break; //whlie문 break
				}
			}
			if (code == 1) {// 차량입고
				// 현재 주차타워에 빈공간이 없는 경우
				park.inParking(car);
			} else if (code == 2) { // 차량출고
				//주차타워에 차량이 0대인 경우
				park.outParking(car);
				
				
				//입력한 차량번호가 해당 주차타워에 없음!!
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒ 없는 차량번호 입니다. 다시 입력해주세요.");
				continue;
				
			} else if (code == 3) { // 취소
				car = 0; // 기존에 입력한 차량번호 Clear
				System.out.println("▒▒ 취소되었습니다. 다음에 이용해주세요.");
				continue;
			
			}
		}
	}
}
