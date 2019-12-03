package problem;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수열 >>");
		int depth = sc.nextInt();

		int first = 1;
		int end = 1;
		int sum = first + end;
		System.out.print("1 1 ");

		for (int i = 2; i <= depth; i++) {
			sum = first + end;
			first = end;
			end = sum;

			System.out.print(sum + "  ");

		}

	}

}
