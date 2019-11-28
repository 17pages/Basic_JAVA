package problem;

import java.util.Scanner;

public class BigSmall01 {
	public static void main(String[] args) {
		//사용자가 2개의 값을 입력
		//--입력--
		//번호 1>>
		//번호 2>>
		//--조건--
		//번호 1 < 번호 2보다 작으면 
		//번호 1에 값과 번호 2의 값을 서로 교환하여 
		// 번호 1이 항상 큰 수를 가지게 만든다.
		//--출럭--
		//번호 1 > 번호 2
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 1 >>");
		int num1  = sc.nextInt();
		System.out.print("번호 2 >>");
		int num2 = sc.nextInt();
		
		//System.out.println(num1 + ", " + num2);
		//테스트 코드. 코드짤때 맞는지 아닌지 확인하기 위해서 테스트한것.
		
		//조건부분
		
		int temp = 0;
				
				
		if(num1 < num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
			
			
		}
		
		//출력부분
		System.out.println(num1 + " > " + num2);

	}

}
