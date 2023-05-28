package ezen.oop.exception;
/**
 * 예외처리란 무엇인가
 * 예외가 발생했을 때 JVM의 기본 처리 메커니즘
 * @author 홍재헌
 *
 */
public class ExceptionExample {

	public static void main(String[] args) {
		System.out.println("프로그램 시작됨.");
//		int x = 10, y = 0;
//		System.out.println(x/y);
//		예외처리를 하는 이유는 개발자의 사소한 실수 하나로 밑에 프로그램이 실행되지 않을 경우를 제외하기 위해 실행함
		
//		String name = null;
//		System.out.println(name.length());
		
		int[] array = {1, 2};
		int count = 5;
		for (int i = 0; i < count; i++) {
			System.out.println(array[i]);
		}
		
//		JVM 기본 처리 메커니즘 - 밑에 코드는 JVM이 내부적으로 실행하는 코드를 보여주는 것
		/*
		ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException("Index 2 out of bounds for length 2");
		System.out.println(ex.getMessage());
		System.exit(0);
		*/
		
		System.out.println("프로그램 종료됨.");
	}

}
