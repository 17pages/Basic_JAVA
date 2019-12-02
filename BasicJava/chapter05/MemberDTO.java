package chapter05;

public class MemberDTO {
	
	private String id;
	private String pw;
	private int age;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public MemberDTO() {}
//	  - 오버로딩 생성자

	// 회원가입시 필요한 7개의 값을 담는 기능
	public MemberDTO(String id, String pw, int age, String name, String email, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	// 회원수정시 필요한 6개의 값을 담는 기능
	public MemberDTO(String pw, int age, String name, String email, String phone, String address) {
		super();
		this.pw = pw;
		this.age = age;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	// 회원(이름)조회시 필요한 1개의 값을 담는 기능
	public MemberDTO(String name) {
		super();
		this.name = name;
	}
	// 로그인시 필요한 2가지 값을 담는 기능
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;

}
	// 3번 캡슐화(은닉) Getter() & Setter()
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	// 4번 DTO에 담겨 있는 모든 값을 출력하는 기능
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", age=" + age + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
	
	}
	
