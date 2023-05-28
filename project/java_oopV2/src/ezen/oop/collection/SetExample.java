package ezen.oop.collection;
/**
 * Set 클래스
 * HashSet : 순서가 없고 중복을 허용 안한다 
 * TreeSet : 입력 순서와 상관없이 오름차순, 가나다순 정렬됨
 * @author 홍재헌
 * 230519 수업
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		set.add("희영");								//리스트에 차례대로 저장되지않는다, TreeSet은 리스트에 차례대로(가나다순, 오름차순) 저장됨
		set.add("소영");
		set.add("영호");
		set.add("승욱");
		System.out.println(set.size());					//리스트에 저장된 배열 목록 갯수 확인
		
		set.add("기정");
		set.add("승욱");
		System.out.println(set.size());					//HashSet은 중복 저장이 안된다
		
		boolean exist = set.contains("영호");			//검색한 이름이 있는지 없는지 검색하고 bool형태로 나오는 기능
		System.out.println(exist);
		
//		향상 for문
		for (String name : set) {						
			System.out.print(name + " ");
		}
		System.out.println();
		
//		내부 클래스 Iterator를 이용해 출력
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.print(name + " ");
		}
		System.out.println();
		
		boolean deleted = set.remove("기정");			//검색한 이름 삭제됐는지 여부
		System.out.println(deleted);
		
		System.out.println(set.isEmpty());				//배열 안에 값이 있는지 없는지, 값이 있으면 false, 값이 없으면 true
		set.clear();									//배열 안에 값을 전부 삭제
		System.out.println(set.size());
	}
}
