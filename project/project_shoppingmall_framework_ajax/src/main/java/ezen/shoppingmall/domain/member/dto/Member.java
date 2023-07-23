package ezen.shoppingmall.domain.member.dto;

/**
 * JavaBean 규약에 따라 만든 재사용 가능한 컴포넌트
 * @author 김기정
 *
 */
public class Member {
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String regdate;
	
	public Member() {}

	public Member(String id, String passwd, String name, String email, String regdate) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", regdate=" + regdate
				+ "]";
	}

}













