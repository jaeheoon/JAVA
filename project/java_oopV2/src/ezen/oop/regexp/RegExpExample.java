package ezen.oop.regexp;

import java.util.regex.Pattern;

/**
 * 정규표현식 관련 예제
 * @author 홍재헌
 * 230522 수업
 */
public class RegExpExample {

	public static void main(String[] args) {
		String inputMessage = "Javax";
		String regexp = "Java.";
		
//		Pattern 클래스의 정적(static) 메소드 활용
		boolean mt = Pattern.matches(regexp, inputMessage);
		System.out.println(mt);
		
//		String 클래스의 인스턴스 메서드 활용
		boolean matched = inputMessage.matches(regexp);
		System.out.println(matched);
		
		
		
		
		
	}

}
