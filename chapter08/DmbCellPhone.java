package chapter08;

// 자식클래스
// : JAVA는 단일상속만 가능!

// extends : 설계도면을 상속해다가 쓸거라고 명시만해둔 것.
public class DmbCellPhone extends CellPhone{
	int channel;
	
	public DmbCellPhone(String model, String color, int channel) {
		// super(); => 부모생성자 호출(부모 객체 생성), 가장 맨위에 써야함.
		// 부모객체생성 후 자식객체가 생성됨!!!
		super(); // 생략가능. super() == CellPhone(); 
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	public void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	public void ChangeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널"+channel+"번으로 변경합니다.");
	}
	public void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}

}
