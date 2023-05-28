package ezen.oop.collection;
import java.util.Comparator;
/**
 * TreeSet 클래스
 * TreeSet : 입력 순서와 상관없이 오름차순, 가나다순 정렬됨
 * @author 홍재헌
 * 230522 수업
 */
import java.util.Set;
import java.util.TreeSet;

import ezen.oop.Student;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(60);
		set.add(50);
		set.add(10);
		set.add(20);
		
		for (Integer num : set) {
			System.out.println(num);				//TreeSet()의 특징 : 오름차순으로 배열을 저장
		}
		
		int sort = 1;				//사용자 입력값
		Comparator<Student<Integer>> comparator = null;
		if(sort == 0) {				//학번으로 정렬
			comparator = new StudentSsnComparator();
		}
		else if(sort == 1) {		//이름으로 정렬
			comparator = new StudentNameComparator();
		}
		Set<Student<Integer>> set2 = new TreeSet<>(comparator);
//		Set<Student<Integer>> set2 = new TreeSet<>(new StudentSsnComparator());
		set2.add(new Student<Integer>("김기정", 15));					//Student같은 사용자가 만든 클래스는 Comparable 인터페이스를 구현해주어야 정상적으로 작동한다
		set2.add(new Student<Integer>("이기정", 20));					// 안그러면 Exception 에러가 나옴 ? 무엇을 기준으로 정렬할지 모르기 때문에
		set2.add(new Student<Integer>("최기정", 5));
		
		for (Student<Integer> student : set2) {
			System.out.println(student);					
		}
		
	}

}
