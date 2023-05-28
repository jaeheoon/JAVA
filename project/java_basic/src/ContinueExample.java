/*
 * 이동문 Continue
 */
public class ContinueExample {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (i>20) {
				continue;
			}
			System.out.println(i+1);
		}
		
//		1부터 100까지의 숫자 중 홀수만 출력되게끔
//		for문으로 실행
//		for (int i = 1; i < 101; i++) {
//			if (i%2==1) {
//				System.out.println(i);
//			}
//		}
		
//		if문 안쓰고 실행
//		for (int i = 1; i < 101; i+=2) {
//				System.out.println(i);
//		}
		
		for (int i = 1; i < 101; i++) {
			if (i%2==0) {
				continue;
			}
			System.out.println(i);
		}
	
	}
}
