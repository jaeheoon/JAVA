package ezen.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		
		List<String> list = new Vector<>();
//		List<String> list = new ArrayList<>();
		
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i=1; i<=1000; i++) {
					list.add("이름 " + i);
				}
			}
		};
		
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i=1001; i<=2000; i++) {
					list.add("이름 " + i);
				}
			}
		};
		
		threadA.start();
		threadB.start();
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int size = list.size();
		System.out.println("저장된 총 객체 수 : " + size);
	}

}
