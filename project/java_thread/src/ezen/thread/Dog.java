package ezen.thread;
/**
 * 경주 게임(쓰레드를 이용한)
 * @author 홍재헌
 *
 */
public class Dog extends Thread {
	private int num;
	
	public Dog() {
		this("익명", 0);
	}
	
	public Dog(String name, int num) {
		super(name);
		this.num = num;
	}
	
	public void race() {
		System.out.println("---------"+getName()+" 강아지 출발----------");
		for (int i = 1; i <= 100; i++) {
			int delayTime = (int)(Math.random()*50);
			System.out.println(num + "번 " + getName() + " 강아지 "+ i +"미터 전진");
			try {
				Thread.sleep(delayTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---------"+getName()+" 강아지 도착----------");
		
	}
	@Override
		public void run() {
			race();
		}
	
	
}
