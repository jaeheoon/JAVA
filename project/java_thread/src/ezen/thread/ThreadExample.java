package ezen.thread;

import java.util.Iterator;

/**
 * 스레드 관련 클래스, 개념 정리
 * @author 홍재헌
 * 230524 수업
 */
public class ThreadExample{
	public void musicPlayer() {
//		사용자 쓰레드 생성 및 실행
		MusicPlayer m = new MusicPlayer();
//		쓰레드 생성 및 실행
		Thread moviePlayer = new Thread(new MoviePlayer());
		m.start();
		moviePlayer.start();
		
//		익명 쓰레드 생성 및 실행
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("i: "+i);
				}
			}
		}).start();
	}
	
	public void doTask() {
		System.out.println("어떤 일을 하는 중");
	}
	
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		System.out.println("JVM(프로세스)의 스레드(인터프리터)에 의해 애플리케이션 프로그램이 실행됨");
		ThreadExample t = new ThreadExample();
//		m.run();		- 이렇게 하면 멀티스레드 실행이 안된다
		t.musicPlayer();
		t.doTask();
		System.out.println("JVM(프로세스)의 스레드(인터프리터)가 종료됨");
	}

}
