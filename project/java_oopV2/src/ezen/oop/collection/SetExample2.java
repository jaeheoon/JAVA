package ezen.oop.collection;
/**
 * Set 클래스
 * HashSet : 순서가 없고 중복을 허용 안한다 
 * TreeSet : 입력 순서와 상관없이 오름차순, 가나다순 정렬됨
 * @author 홍재헌
 * 230519 수업
 */

import java.util.HashSet;
import java.util.Set;

import ezen.oop.Student;

public class SetExample2 {
	
	public static void main(String[] args) {
		
		Set<Student<Integer>> set = new HashSet<Student<Integer>>();
		Set<String> set2 = new HashSet<String>();
		set2.add("김기정");
		set2.add("이기정");
		set2.add("최기정");
		set2.add("김기정");
		System.out.println(set2.size());
		
		
//		Set<String> set = new TreeSet<String>();
		set.add(new Student<Integer>("희영", 1));								//리스트에 차례대로 저장되지않는다, TreeSet은 리스트에 차례대로(가나다순, 오름차순) 저장됨
		set.add(new Student<Integer>("소영", 2));
		set.add(new Student<Integer>("기정", 3));
		System.out.println(set.size());					//리스트에 저장된 배열 목록 갯수 확인
		
		set.add(new Student<Integer>("기정", 3));
		System.out.println(set.size());					//HashSet은 중복 되는 이유는?
	}
	
	
}
