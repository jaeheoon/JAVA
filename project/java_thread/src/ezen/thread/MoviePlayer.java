package ezen.thread;
/**
 * 쓰레드 인터페이스 구현하는 방법
 * @author 홍재헌
 * 230524 수업
 */
public class MoviePlayer implements Runnable {
	
	public void play() {
		while(true) {
			System.out.println("동영상 재생 중");
		}
	}
	@Override
	public void run() {
		play();
	}
}
