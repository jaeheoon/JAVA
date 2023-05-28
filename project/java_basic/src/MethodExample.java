
/*
 * 메소드(함수) 정의 및 사용
 */
public class MethodExample {
	
/*
 * 	구구단을 출력하는 메소드 정의
 */
	static void printGugudan() {
		for (int i = 2; i < 10; i++) { 		 // 행반복 for문
			for (int j = 1; j < 10; j++) {	 // 열반복 for문
				System.out.print(i + "x" + j + "=" + (j*i) + "\t");
			}
			System.out.println();
		}
	}
	
	/*
	 * 단을 입력받아 해당 단을 출력하는 기능
	 */
	static void printDan(int dan) {		// ()안에 있는 것이 매개변수
		for (int i = 1; i < 10; i++) {
			System.out.print(dan +"x"+ i +"=" + (dan * i)+"\t");
		}
		System.out.println();
	}
	
	
	/*
	 * 두 수를 입력받아 해당 합을 출력하는 기능, 반환되는 값 있음
	 */
	
	static int printSum(int x, int y) {
//		return;
		return x + y;
	}
	
	/*
	  	static double printExchange(int x, int y) { 
		return x + y;
		}
		--------------------------------------------------
	  	static 			기본으로 써줌
	 	double 			반환되는 타입
	  	printExchange	함수 이름
	 	(int x, int y) 	매개변수
	  	return x + y;	제어문 - 반환되는 값
	 */
	
	
	public static void main(String[] args) {
		System.out.println("구구단 출력하기");
//		구구단 출력 메소드 사용(호출)
		printGugudan();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printGugudan();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//		5단 출력
		printDan(5);	// ()안에 있는 것이 전달인자
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		printDan(7);	// ()안에 있는 것이 전달인자
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		int re = printSum(423, 5);
		System.out.println(re);
		
		int x = 500, y = 42543;
		int result = printSum(x, y);
		System.out.println(result);
		
		System.out.println(printSum(x, y));
	}

}
