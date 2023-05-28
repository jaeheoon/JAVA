package ezen.oop;
/**
 * java 5버전에 추가된 AutoBoxing/UnBoxing
 * @author 홍재헌
 * 230518 수업
 */
public class AutoBoxingExample {

	public static void main(String[] args) {
//		Java 5버전 이전
		int x = 100;
//		얘에 관련된 값을 사용하려면 객체 생성
//		생성자를 이용 or valueOf 사용
//		Integer integer = new Integer(x);
		Integer integer = Integer.valueOf(x);	// Boxing
		x = integer.intValue();					// UnBoxing
		
//		Java 5버전 이후(AutoBoxing)
		Integer integer2 = x;
//		Integer integer2 = Integer.valueOf(x);			JVM이 자동으로 내부에서 이 코드를 실행하고 integer2에 넣어준다
		
		x = integer2;								  //자동으로 AutoUnBoxing 해준다
//		int x = new Integer(100).intValue;				JVM이 자동으로 내부에서 이 코드를 실행하고 x에 넣어준다
		
	}

}
