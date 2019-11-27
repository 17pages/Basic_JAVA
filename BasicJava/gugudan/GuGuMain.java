package gugudan;

import java.util.Scanner;

public class GuGuMain {

	public static void main(String[] args) {
		// JAVA는 프로그램 실행시 무조건 Main method부터 시작.

		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 4 = 8
		// 2 x 5 = 10
		// 2 x 6 = 12
		// 2 x 7 = 14
		// 2 x 8 = 16
		// 2 x 9 = 18
		
		//1. 사용자에게 단수를 입력받는 부분
		//2. 구구단을 출력하는 부분
		
		Scanner sc = new Scanner(System.in); //객체생성, Scanner는 자바에서 만든 클래스. 입력받는 기능 
		System.out.print("단수>>"); // 출력부분
		int dansu = sc.nextInt(); // 단수입력, .은 참조 / 인스턴트 사용 / nextInt 사용자가 입력한 정수를 가져와라
		// dansu라는 변수에 sc.nextInt 넣음
		
		GuGuPrint ggp = new GuGuPrint ();
		ggp.guGuDan(dansu); // 갔다가 다시 와라. 호출문 ()안에는 매개변수 보내는것
	

	}
}
