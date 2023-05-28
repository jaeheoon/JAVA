/*
 * 반복문 for
 */
public class ForExample {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("풀스택 웹 개발자과정");
		}

//			중첩for문을 이용한 사각형 출력

		for (int i = 0; i < 5; i++) {	     // 행반복 for문
			for (int j = 0; j < 5; j++) {  	 // 열반복 for문
				System.out.print('*');
			}
			System.out.println();
		}

		for (int i = 0; i < 11; i++) { 		 // 행반복 for문
			for (int j = 0; j < i; j++) {	 // 열반복 for문
				System.out.print((j+1) + " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 10; i++) { 		 // 행반복 for문
			for (int j = 10; j > i; j--) {	 // 열반복 for문
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
//		구구단
		for (int i = 2; i < 10; i++) { 		 // 행반복 for문
			for (int j = 1; j < 10; j++) {	 // 열반복 for문
				System.out.print(i + "x" + j + "=" + (j*i) + "\t");
			}
			System.out.println();
		}
	}
}
