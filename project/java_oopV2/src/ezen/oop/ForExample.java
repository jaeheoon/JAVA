package ezen.oop;
/**
 * java 5버전에 추가된 향상 For문
 * @author 홍재헌
 * 230518 수업
 */
public class ForExample {

	public static void main(String[] args) {
		
		int[] array = {5, 2, 7, 2, 0};
		for ( int num : array ) {
			System.out.print(num + " ");
		}
		
	}

}
