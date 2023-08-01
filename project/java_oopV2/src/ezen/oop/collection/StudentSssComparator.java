package ezen.oop.collection;

import java.util.Comparator;

import ezen.oop.Student;

public class StudentSssComparator implements Comparator<Student<Integer>> {

	@Override
	public int compare(Student<Integer> o1, Student<Integer> o2) {
		return o1.getSsn().intValue() - o2.getSsn().intValue();
//		return o2.getSsn().intValue() - o1.getSsn().intValue();
	}

}
