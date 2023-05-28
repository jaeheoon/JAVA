/*
 * 자바 표준 API 간단 실습
 */
public class APIExample {

	public static void main(String[] args) {
		
//		String 클래스로부터 인스턴스 생성
		String string = new String("이것이 자바다.");
//		생성된 인스턴스의 메소드를 호출하는 기능
		int count = string.length();
		System.out.println(count+"개의 문자로 이루어진 문자열입니다.");
		
		int number = 4543534;
//		정수를 문자열로 형변환 해주는 static 메소드 호출
		String numString= String.valueOf(number);
		count = numString.length();
		System.out.println(count+"자리로 구성된 정수 입니다.");
		
		
		int x = -150;
		
//		Math클래스를 이용하여 절대값 구하기
//		Math클래스는 100% 상수와 static 메소드로 구성된 대표적인 클래스이다.
		int y = Math.abs(x);
		System.out.println(y);
	}

}
