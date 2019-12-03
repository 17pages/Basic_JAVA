package problem;

public class Parking {
	int[] space = new int[5]; // 주차공간 (5대) // 전역변수는 자동으로 초기화해줌
	int carCnt = 0; // 현재 주차된 차량수 int carCnt; 해도 똑같음

	// 1. 주차타워 현황
	public void viewParking() {
		System.out.println("===============");
		for (int j = 0; j < space.length; j++) {// 브리핑용. 어디있는지 보여주려고 만든 거
			System.out.println("|| " + (j + 1) + "층:" + space[j] + " ||");
		}
		System.out.println("===============");

	}

	// 2. 주차타워 입고 ()<- 입력값(차량번호)이 있어야 작동함
	public void inParking(int car) {
		if (carCnt == space.length) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 공간이 부족합니다. 2번타워를 이용해주세요.");
			// continue;
			return; // 메서드 실행종료! void 있을경우 메서드 끝내는 경우로 씀.
		}
		// 주차공간을 순회하면서 비어있는(입고 할 공간)을 찾음
		for (int i = 0; i < space.length; i++) {
			// 비어 있는 공간을 찾음 (값이 0이면 비어있음)
			if (space[i] == 0) {
				space[i] = car;
				carCnt += 1;
				// carCnt = carCnt + 1;
				System.out.println("▒▒ " + (i + 1) + "층:" + car + "입고완료!");
				viewParking();
				break;
			}
		}
	}//여기까지 오면 끝나서 다시 EZparkingMain이 됨.

	// 3. 주차타워 출고
	public void outParking(int car) {
		if (carCnt == 0) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 주차중인 차량이 없습니다. 확인해주세요.");
			return;
		}
		for (int i = 0; i < space.length; i++) {
			// 주차된 차량번호와 내가 입력한 차량번호가 같을때
			if (space[i] == car) {
				space[i] = 0; // 출고=> 공간 0
				carCnt -= 1; // 현재주차차량 -1

				System.out.println("▒▒ " + (i + 1) + "층:" + car + "출고완료!");
				viewParking();
				return;
			}
		}
	}
}
