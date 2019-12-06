package chapter12;

import java.util.ArrayList;

// get, remove, set = > 인덱스값을 명시해야함
// add는 인덱스값이 있어도 없어도 상관없음.
public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(); // <> 생략가능

		list.add("샤인머스켓"); // 값입력
		list.add("납작복숭아"); // 값입력
		list.add("딸기"); // 값입력
		list.add(1, "망고"); // (index, value) 넣고 원래 있던 애들을 자동으로 뒤로 밀어버림
		list.set(3, "오렌지"); // 수정하고 싶을때는 set이용.
		list.remove(3); // 값을 지우는 것
		int[] array = new int[5];
		array[0] = 3;

		// int[] array = new int[5];
		// array[0] = 3;

		// 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // 값을 꺼내오는 것. get 나에게 값을 보여줘라, 반드시 인덱스값을 적어줘야함.
		}
		
		for(String val : list) {
			System.out.println(val);
		}
	}

}
