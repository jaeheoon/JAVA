package ezen.oop.regexp;

import java.util.regex.Pattern;

/**
 * 정규표현식을 이용한 입력 데이터 유효성 검증
 * @author 홍재헌
 *
 */
public class Validator {
	
	/**
	 * 입력한 값을 돌려서 공백이 있는지 확인
	 * @return 유효 여부, 공백이 있으면 true
	 */
	public static boolean hasText(String input) {
		if(input != null && input.trim().length() != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 입력한 값을 돌려서 숫자인지 확인
	 * @param number 입력 문자열
	 * @return 유효 여부, all 숫자면 true
	 */
//	입력한 값을 돌려서 숫자인지 확인하고 전부 숫자면 true, 그중 하나라도 아니면 false
	public static boolean isNumber(String number) {
//		for (int j = 0; j < number.length(); j++) {							//예전방식
//			char c = number.charAt(j);
//			if(!Character.isDigit(c)) {
//				return false;
//			}
//		}
//		return true;
		
//		return Pattern.matches("[0-9]+", number);
//		return Pattern.matches("[0-9]+");
		return Pattern.matches("\\d+", number);								//최신방식
	}
	
	/**
	 * 입력한 값을 돌려서 숫자인지, 영어인지 확인
	 * @param id 입력 문자열
	 * @return 유효 여부, all 숫자나 영어면 true
	 */
//	입력한 값을 돌려서 숫자인지, 영어인지 확인하고 전부 숫자나 영어면 true, 그중 하나라도 아니면 false
	public static boolean isId(String id) {
//		for (int i = 0; i < id.length(); i++) {								//예전방식
//			char c = id.charAt(i);
//			if (!Character.isDigit(c) && !Character.isAlphabetic(i)) {				//isAlphabetic - 영어인지 확인하는 코드
//				return false;
//			}
//		}
//		return true;
		
//		아이디 유효 여부 - 영문과 숫자 조합으로 8~10자 아이디
		return id.matches("^[a-zA-Z0-9]{8,10}$");							//최신방식
	}
	
	public static boolean validEmail(String email) {
		return email.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?");
	}
	
//	테스트를 위한 main 메소드
	public static void main(String[] args) {
//		String string = "aaa123";
//		System.out.println(Validator.hasText(string));
//		System.out.println(Validator.isNumber(string));
//		System.out.println(Validator.isId(string));
		
		String number = "213428-r43";
//		String number = "21342843";
		boolean ok = Validator.isNumber(number);
		System.out.println(ok);
		
		String id = "bangry12가2314";
//		String id = "bangry123";
		ok = Validator.isId(id);
		System.out.println(ok);
		
		String email = "bangry313@gmail";
//		String  email = "bangry313@gmail.com";
		ok = Validator.validEmail(email);
		System.out.println(ok);
	}
	
}
