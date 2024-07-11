package homework;

/**
 * 클래스 활용하여 DTO, Service 회원 생성 프로그램 구현
 * @author 홍재헌
 *
 */
public class MemberDTO {
	private String name, phone, address;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
}
