package gugudan;

public class GuGuPrint {
	
	// 일반 method
	public void guGuDan(int dansu) {
		
		//실제 구구단을 출력하는 코드
		int result; // result 변수 선언함 , 초기화는 안되어있음
		System.out.println("구구단" + dansu + "단 출력");
		for (int i = 1; i <= 9; i++) {
			result = dansu * i;
			System.out.println(dansu + " X " + i + " = " + result);

		}
		//method가 끝날때 : return했을때, 중괄호끝났을때
		
	}

}
