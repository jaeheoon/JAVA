package ezen.oop.lambda2;

public class LambdaExmple {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("스레드 실행");
			}
		}).start();
		
		new Thread( () -> System.out.println("또다른 스레드") ).start();
		

	}

}
