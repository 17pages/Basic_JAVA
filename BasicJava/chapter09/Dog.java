package chapter09;

//추상클래스를 상속받는 자식 클래스
public class Dog extends Animal {

	public Dog() {
		this.kind = "강아지"; //나 자신에게 강아지라는 값을 넣어라
	}
	@Override
	public void sound() {

		System.out.println("멍멍");
	}
	

}
