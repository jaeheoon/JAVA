package ezen.oop.collection;
/**
 * ArrayList 클래스
 * @author 홍재헌
 * 230519 수업
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListExample3 {
	
	public static void main(String[] args) {
//	String[] list; - 대신 밑에 List<>를 사용한다
//		ArrayList 이용 추가/삭제 테스트
		List<String> list = new ArrayList<String>();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			list.add("아무개" + i);
		}
		
//		삭제 테스트
		for (int i = 0; i < 1000; i++) {
			list.remove((int)Math.random()*100000);
		}
		long end = System.currentTimeMillis();
		System.out.println("수행 시간은: " + (end - start) + "ms");
		
//		LinkedList 이용 추가/삭제 테스트
		List<String> list1 = new LinkedList<String>();
		
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			list1.add("아무개" + i);
		}
		
//		삭제 테스트
		for (int i = 0; i < 1000; i++) {
			list1.remove((int)Math.random()*100000);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("수행 시간은: " + (end1 - start1) + "ms");
	}
}
