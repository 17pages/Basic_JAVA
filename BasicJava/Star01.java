package study;

public class Star01 {
	public static void main(String[] args) {
		int star = 0;
		int line = 0;
		
		for(line = 1; line<=5; line++) {
			for(star = 1; star<=line; star++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}

}
