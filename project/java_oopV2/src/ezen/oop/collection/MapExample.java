package ezen.oop.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ezen.oop.Student;

/**
 * Map 클래스
 * 키랑 값의 쌍으로 데이터 저장
 * @author 홍재헌
 * 230519 수업
 */
public class MapExample {

	public static void main(String[] args) {
//		Map<Integer, Student<Integer>> map = new HashMap<Integer, Student<Integer>>();
		Map<Integer, Student<Integer>> map = new Hashtable<Integer, Student<Integer>>();
//		동적으로 만들기 위해 새로운 학생 클래스를 만들고 학번을 get 메소드로 저장함
		for (int i = 1; i <= 10; i++) {
			Student<Integer> student = new Student<Integer>("희영"+i, i);
			map.put(student.getSsn(), student);
		}
		
//		2번에 이미 키와 값이 저장되어있는데 또 추가하려는 상황
		Student<Integer> addStudent = new Student<>("기정", 2);
//		넣으려는 키를 검색해봐서 있으면 저장이 안되게끔
		if(map.containsKey(addStudent.getSsn())) {
//			System.out.println("이미 사용중인 Key입니다");
//			중복돼도 값을 맨 밑에 출력하려면
			int max = 11;		//학번의 최댓값 코드를 만들어야함
			addStudent.setSsn(max);
			map.put(addStudent.getSsn(), addStudent);
			System.out.println("등록되었습니다");
		}
		
		System.out.println(map.size());
		Student<Integer> searchStudent = map.get(5);
		System.out.println(searchStudent);
		
		searchStudent = map.remove(5);
		System.out.println(searchStudent);
		System.out.println(map.size());
		
		Collection<Student<Integer>> values = map.values();				//value값 출력
		for (Student<Integer> student : values) {
			System.out.println(student);
		}
		
		Set<Integer> keys = map.keySet();								//key값만 출력
		for (Integer key : keys) {
			System.out.println(key);
		}
		
		Set<Entry<Integer, Student<Integer>>> entries = map.entrySet();
		for (Entry<Integer, Student<Integer>> entry : entries) {
			System.out.println(entry); 									//key랑 value랑 같이 출력
			System.out.println(entry.getKey());							//key만 출력
			System.out.println(entry.getValue());						//value만 출력
		}
	}

}
