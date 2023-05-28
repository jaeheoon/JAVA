package ezen.thread.teacher;

/**
 * 사용자 정의 스레드
 * @author 김기정
 */
public class MusicPlayer extends Thread {
	// 사용자 스레드의 엔트리포인트 역할
	@Override
	public void run() {
		for ( ; true; ) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("음악재생: " );
		}
	}

}
