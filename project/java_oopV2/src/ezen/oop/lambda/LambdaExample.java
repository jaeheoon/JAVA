package ezen.oop.lambda;
/**
 * 람다식 관련 예제
 * @author 홍재헌
 * 230602 수업
 */
public class LambdaExample {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("쓰레드 실행");
			}
		}).start();
		
		new Thread(()-> System.out.println("또다른 쓰레드")).start();			//람다식
			
	}

}
