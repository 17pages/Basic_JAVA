package chapter12;

import java.util.HashMap;

public class HashMap01 {

	public static void main(String[] args) {
			HashMap<String, Object> map = new HashMap<>(); //<key, value> //object 모든 값을 다 받음
			map.put("선생님", "초롱");
			map.put("강아지", "체리");
			System.out.println(map.get("강아지")); // key를 요청해야 값이 나옴
	}

}
