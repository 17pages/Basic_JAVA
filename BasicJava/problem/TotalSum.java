package problem;

public class TotalSum {
	// 1~100까지 더해서 출력하시오.

	public static void main(String[] args) {
		// 1~100까지 수중에 짝수만 더해서 더해서 출력하시오
		// 시작갑 : 1
		// 종료값 :100
		// 짝수 누적합 : even
		// 홀수 누적합 : odd

		int even = 0; // 덧셈결과의 누적
		int odd = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) { //짝수
				even = even + i;
			} else { //홀수
				odd = odd + i;
			}
			
		}System.out.println("1~100까지의 짝수의 총합은 " + even);
		System.out.println("1~100까지의 홀수의 총합은 " + odd);
		
	}
}
