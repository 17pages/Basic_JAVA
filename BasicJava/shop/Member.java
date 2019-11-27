package shop;

public class Member {
	
	//회원가입
	
	public String memInsert(String id, String pw, String name) { //받는 쪽은 반드시 명시해주어야함.
		System.out.println(id +"," + pw + "," + name + "로 회원가입 성공");
		String status = "success";
		return status;
	}
	
	//회원수정
	public void memUpdata() {
		
	}
	//회원탈퇴
	public void memDelete(String id, String pw) {
		
	}

}
