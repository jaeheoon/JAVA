package ezen.thread;
/**
 * 사용자 정의 스레드
 * @author 홍재헌
 * 230524 수업
 */
public class MusicPlayer extends Thread {
//	사용자 쓰레드의 엔트리포인트 역할을 한다, main은 main쓰레드의 엔트리포인트 역할
	@Override
	public void run() {
		for (int i = 0; i<50; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("음악재생: " + i);
		}
	}
}
