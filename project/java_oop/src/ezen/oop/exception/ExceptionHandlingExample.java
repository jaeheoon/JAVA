package ezen.oop.exception;

import java.io.IOException;
import java.util.Scanner;

/**
 * 개발자가 예외 처리하는 방법
 * try ~ catch ~ finally 블록 사용
 * @author 홍재헌
 *
 */
public class ExceptionHandlingExample {
	
	public static void exceptionHandling1() {
		try {
//			예외가 발생할 가능성이 있는 실행문
			int x = 10, y = 0;
			System.out.println(x/y);
			
			String name = null;
			System.out.println(name.length());
			
			int[] array = {1, 2};
			int count = 5;
			for (int i = 0; i < count; i++) {
				 System.out.println(array[i]);
			}
		} catch (ArithmeticException ex) {
//			개발자가 예외 처리하는 코드
//			System.err.println(ex.getMessage());
			ex.printStackTrace();
			System.err.println("숫자는 0으로 나눌 수 없습니다");
		} catch (NullPointerException ex) {
//			개발자가 예외 처리하는 코드
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			System.err.println("Null로 정의되어있습니다");
		} catch (ArrayIndexOutOfBoundsException ex) {
//			개발자가 예외 처리하는 코드
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			System.err.println("배열의 길이가 배열의 크기보다 큽니다");
		} finally {
			System.out.println("반드시 실행되어야 하는 코드");
			System.out.println("리소스 반납 코드, 네트워크 종료 처리 등");
		} 
	}
	public static void exceptionHandling2() {
		try {
//			예외가 발생할 가능성이 있는 실행문
			int x = 10, y = 0;
			System.out.println(x/y);
			
			String name = null;
			System.out.println(name.length());
			
			int[] array = {1, 2};
			int count = 5;
			for (int i = 0; i < count; i++) {
				System.out.println(array[i]);
			}
		} catch (RuntimeException ex) {
//			개발자가 예외 처리하는 코드
//			근데 보통 이렇겐 안하고 instanceof를 활용할 수 있는 법을 보여준 것
			System.err.println(ex.getMessage());
			if (ex instanceof ArithmeticException) {
				System.err.println("숫자는 0으로 나눌 수 없습니다");
				
			}
			else if (ex instanceof ArrayIndexOutOfBoundsException) {
				System.err.println("배열의 길이가 배열의 크기보다 큽니다");
				
			}
			else if (ex instanceof NullPointerException) {
				System.err.println("Null로 정의되어있습니다.");
				
			}
			else {
				System.err.println("오류가 발생되었습니다.");
			}
		} 
	}
	
	
//	throws 관련된 예제
//	돈이 0보다 작거나 같은 금액이 들어왔을때를 가정
	public static void inputMoney() throws NotBalanceException{
		System.out.print("입금 금액: ");
		Scanner scanner = new Scanner(System.in);
		long money = scanner.nextLong();
//		입력 데이터 검증
		if(money <= 0) {
//			사용자 강제 예외 발생 - 프로그램 상 오류가 아닌 개발자가 필요에 의한 예외를 발생시키는 것 ex) 돈 입금은 0이거나 음수일 수 없기 때문에 예외 생성
			throw new NotBalanceException("금액은 0이거나 음수일 수 없습니다", 100);
		}
		System.out.println("정상 입금 처리 되었습니다");
	}
	
	public static void eclipseTest() {
		try {
			inputMoney();
		} catch (NotBalanceException e) {
				
			e.printStackTrace();
		}
	}
	
	public static void standarAPITest() {
			try {
				int c = System.in.read();
//				System.out.println(c);
				char d = (char)c;
				System.out.println(d);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작됨.");
//		예외처리를 하는 이유는 개발자의 사소한 실수 하나로 밑에 프로그램이 실행되지 않을 경우를 제외하기 위해 실행함
//		exceptionHandling1();
//		exceptionHandling2();
		standarAPITest();
//		try{
//			inputMoney();
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
		
//		JVM 기본 처리 메커니즘 - 밑에 코드는 JVM이 내부적으로 실행하는 코드를 보여주는 것
		/*
		ArrayIndexOutOfBoundsException ex = new ArrayIndexOutOfBoundsException("Index 2 out of bounds for length 2");
		System.out.println(ex.getMessage());
		System.exit(0);
		*/
		
		System.out.println("프로그램 종료됨.");
	}

}
