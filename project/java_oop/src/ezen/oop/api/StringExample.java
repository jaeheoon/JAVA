package ezen.oop.api;

import java.util.Scanner;

/**
 * String 클래스의 주요 메소드
 * @author 홍재헌
 *
 */
public class StringExample {

	public static void main(String[] args) {
//		length: 문자열 길이
		String ssn = "680313-1234567";
		if(ssn.length() == 13) {
			System.out.println("정확한 주민등록번호입니다.");
		} else {
			System.out.println("잘못된 주민등록번호입니다.");
		}
		
//		substring: 숫자 뒤로 잘라온 문자열 반환
		System.out.println("--------------substring() 메소드---------------------");
		String title = "자바 프로그래밍";
		System.out.println(title.substring(3));
		System.out.println(title.substring(0, 2));
		
//		replace: 단어를 새로운 단어로 변경 - 예시로는 게임에서 욕설을 다른 언어로 바뀌는 식으로 생각
		System.out.println("---------------replace() 메소드----------------------");
		System.out.println(title.replace("자바", "Java"));
		
//		trim: 문자열의 앞뒤 공백을 제거한 후 반환
		System.out.println("-----------------trim() 메소드-----------------------");
		System.out.println("            자바 프로그래밍           ");
		System.out.println("            자바 프로그래밍           ".trim());
		
//		char charAt: x번째 문자를 반환해준다 - 예시로는 주민등록번호 뒷자리 성별 구별할때 주로 사용
		System.out.println("-----------------charAt() 메소드---------------------");
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("주민등록번호: ");
//		ssn = scanner.nextLine();
		char c = ssn.charAt(7);
		switch (c) {
			case '1': System.out.println("2000년 이전 출생 남자");break;
			case '2': System.out.println("2000년 이전 출생 여자");break;
			case '3': System.out.println("2000년 이후 출생 남자");break;
			case '4': System.out.println("2000년 이후 출생 여자");break;
			default:  System.out.println("외국인"); break;
		}
		
//		int indexOf(String str): 지정된 문자열이 포함되어있으면 포함되어있는 위치를 반환, 포함되어있지 않으면 -1 반환 - charAt이랑 비슷함
		System.out.println("----------------indexOf() 메소드---------------------");
		if(title.indexOf("자바") != -1) {
			System.out.println("욕설이 포함되어있습니다");
			
//		static String valueOf(Object object): 숫자, char 등등을 전달하면 문자열로 변환시켜줌, 즉 형변환 시켜줌
//		예시) 숫자를 몇자리인지 체크할때 어떻게 할 것인지
		System.out.println("----------------valueOf() 메소드---------------------");
		int number = 455464;
		String numstr = String.valueOf(number);
		System.out.println(numstr.length()+"자리 수 입니다");
		
		}
	}

}
