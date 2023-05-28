package ezen.oop.collection;
/**
 * Comparator 사용(비교자 사용)
 * 230522 수업
 */
import java.util.Comparator;

import ezen.oop.Student;

public class StudentNameComparator implements Comparator<Student<Integer>>{

	@Override
	public int compare(Student<Integer> o1, Student<Integer> o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
