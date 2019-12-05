package chapter10;

public class ToyMain {
	public static void main(String[] args) {
		IToy mazinger = new MazingerToyImpl(); //생성자메서드
		IToy pooh = new PoohToyImpl();
	}

}
