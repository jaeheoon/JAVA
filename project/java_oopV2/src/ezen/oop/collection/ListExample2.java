package ezen.oop.collection;
/**
 * LinkedList 클래스
 * @author 홍재헌
 * 230519 수업
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample2 {
	
	public static void main(String[] args) {
//	String[] list; - 대신 밑에 List<>를 사용한다
		List<String> list = new LinkedList<String>();
		list.add("희영");			//리스트에 차례대로 저장됨
		list.add("소영");
		list.add("영호");
		list.add("승욱");
		System.out.println(list.size());				//리스트에 저장된 배열 목록 갯수 확인
		
		list.add("기정");
		list.add("승욱");
		System.out.println(list.size());				//ArrayList는 순서대로 저장하기 때문에 중복 저장이 가능하다
		
		System.out.println(list.get(0));				//배열에 접근하려면 get()이라는 메소드 사용(검색 기능)
		System.out.println(list.get(list.size()-1));
		
		boolean exist = list.contains("영호");			//검색한 이름이 있는지 없는지 검색하고 bool형태로 나오는 기능
		System.out.println(exist);
		
//		기존에 사용하던 for문
		for (int i = 0; i < list.size(); i++) {			
			System.out.print(list.get(i) + " ");
			
		}
		System.out.println();
		
//		향상 for문
		for (String name : list) {						
			System.out.print(name + " ");
		}
		System.out.println();
		
//		내부 클래스 Iterator를 이용해 출력
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.print(name + " ");
		}
		System.out.println();
		
		boolean deleted = list.remove("기정");			//검색한 이름 삭제됐는지 여부
		System.out.println(deleted);
		
		System.out.println(list.isEmpty());				//배열 안에 값이 있는지 없는지, 값이 있으면 false, 값이 없으면 true
		list.clear();									//배열 안에 값을 전부 삭제
		System.out.println(list.size());
	}
}
