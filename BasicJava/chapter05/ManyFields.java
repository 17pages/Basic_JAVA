package chapter05;

// JAVA에서 사용하는 다앙햔 변수들
	//전역변수, 지역변수, 멤버변수, 인스턴스변수
	//클래스변수, static변수, 필드, 매개변수
public class ManyFields {
		//전역변수는 바로 선언 해도 가능, 초기화 하지 않아도 java가 알아서 초기화해줌. 
		//지역변수는 반드시 초기화 해야함.
	
	int all; // 구성요소 관점 - 필드 (멤버변수) , 구역관점 - 전역변수
	static String stt; //필드(멤버변수), 전역변수, static변수(정적변수), 클래스변수(static이 가진 변수를 모두 공유하기때문에)
	//객체자료형의 초기화는 null, 하지만 프로그램이 깨질 수 있기 때문에 ="";로 선언해준다.
	
	
	public void sum(int a, int b) { //매개변수(이게 더 맞음), 지역변수
		int localNum = 30; // 지역변수, value
	}
	public void test() {
		ManyFields mf = new ManyFields();
		mf.all = 5; //mf는 인스턴스. 인스턴스변수
	}
}
