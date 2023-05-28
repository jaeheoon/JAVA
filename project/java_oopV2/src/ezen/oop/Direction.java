package ezen.oop;
/**
 * enum(열거형) 정의
 * 한정된 값이라고도 함
 * @author 홍재헌
 * 230518 수업
 */
public enum Direction {
	NORTH("북쪽"), SOUTH("남쪽"), EAST("동쪽"), WEST("서쪽");		//세미콜론(;) 붙여도 되고 안붙여도 됨
	
	private final String value;
	
	private Direction(String name) {
		this.value = name;
	}
	
	public String getValue() {
		return value;
	}
	
//	필요에 따라 기능 추가 가능
}
