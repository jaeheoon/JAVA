package ezen.thread;

public class AutoSaveThread implements Runnable{

	private void save() {
		System.out.println("파일 자동 저장 완료...");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				save();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
