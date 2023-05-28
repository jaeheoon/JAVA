package ezen.thread.teacher;

public class ThreadExample {
	
	public void musicPlay() {
		// 사용자 스레드 생성 및 실행
		MusicPlayer musicPlayer = new MusicPlayer();
		//musicPlayer.run();
		musicPlayer.start();
		
		// 스레드 생성 및 실행
		Thread moviePlayer = new Thread(new MoviePlayer());
		moviePlayer.start();
		
		// 익명 스레드 생성 및 실행
		new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<100; i++) {
					System.out.println("i : " + i);
				}				
			}
		}).start();
		
		
	}
	
	public void doTask() {
		System.out.println("어떤 작업을 수행합니다..");
	}

	
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName());
		
		System.out.println("JVM(프로세스)의 스레드(인터프리터)에 의해 애플리케이션 실행됨..");
		
		ThreadExample t = new ThreadExample();
		t.musicPlay();
		t.doTask();
		System.out.println("JVM(프로세스)의 스레드(인터프리터)가 종료됨..");
	}

}
