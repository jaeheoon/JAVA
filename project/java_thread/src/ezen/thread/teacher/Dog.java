package ezen.thread.teacher;

public class Dog extends Thread{
	//String name;
	private int number;
	
	public Dog() {
		this("익명", 0);
	}
	
	public Dog(String name, int number) {
		super(name);
		this.number = number;
	}
	
	public void race() {
		System.out.println("-----"+getName()+"강아지 출발------");
		for (int i = 1; i <= 100; i++) {
			int delayTime= (int)(Math.random()*100);
			System.out.println(getName()+"강아지 "+i+"미터 전진....");
			try {
				Thread.sleep(delayTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----"+getName()+"강아지 결승점 통과------");
		
	}
	
	@Override
	public void run() {
		race();
	}

	
	
	

}
