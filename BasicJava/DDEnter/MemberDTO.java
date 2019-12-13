package problem.DDEnter;

import java.sql.Date;

public class MemberDTO {
	//1. 변수(DB Table 참조)
	private String ano;       //전역변수들. 초기화는 null
	private String aname;     
	private String major;   
	private String groupyn;  
	private String groupnm;          
	private int sal;            
	private Date regdate;          

	// 2. 생성자 (Default, 전역변수 All) // source - generate constructor using
	//한번 실행하는 역할.
	public MemberDTO() {}

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal, Date regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
		this.regdate = regdate;
	}
	
	
	public MemberDTO(String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.aname = aname; //인스턴스의 aname // mDTO의 aname|null(이자리에 공유 들어감)
		this.major = major;//인스턴트의 major
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}//MemberDTO mDTO = new MemberDTO 끝
	


	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	//3. getter(), setter() // source - generate getter and setter
	//
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	//4. toString()
	@Override
	public String toString() {
		return "MemberDTO [ano=" + ano + ", aname=" + aname + ", major=" + major + ", groupyn=" + groupyn + ", groupnm="
				+ groupnm + ", sal=" + sal + ", regdate=" + regdate + "]";
	}
	

	
	
}
