package ezen.oop;

import java.util.Date;

/**
 * 표준 애노테이션 사용하기
 * @author 홍재헌
 * 230519 수업
 */
public class AnnotationExample {

//	@Deprecated 관련 예제
	@Deprecated
	public static void someMethod() {
		System.out.println("폐기처분 메소드 예제");
	}
	
//	@SuppressWarnings 관련 예제
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		someMethod();
		
		Date today = new Date();
		today.toLocaleString();
		
	}

}
