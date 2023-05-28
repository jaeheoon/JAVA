package ezen.oop;

import java.util.Objects;

public class Student<T> /*implements Comparable<Student<Integer>> 
- 이렇게 해도 되지만 TreeSet 생성할때 Comparator<? super E> comparator를 사용하면 여러개를 사용할때 편하다
StudentSsnComparator 클래스 참고*/
{
	private String name;
	private T ssn;
	
	public Student() {
		super();
	}

	public Student(String name, T ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getSsn() {
		return ssn;
	}

	public void setSsn(T ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ssn=" + ssn + "]";
	}
	
	public static void main(String[] args) {
		Student<String> student = new Student<>();
		student.setSsn("12345");
		student.getSsn();
		
		Student<Integer> student2 = new Student<>();
		student2.setSsn(1234);			//AutoBoxing
		int s = student2.getSsn();		//AutoUnBoxing
		System.out.println(s);
	}

	@Override
	public int hashCode() {
//		return Objects.hash(name, ssn);		 - 기본으로 나오는 해쉬코드
		return toString().hashCode();		// - 이게 더 나음
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return toString().equals(obj.toString());
		}
		return false;
	}

/*	- Comparable 구현시 필요
	@Override
	public int compareTo(Student<Integer> student) {
//		학번순으로 할때
//		if (ssn == student.getSsn()) { return 0; }
//		else if ((Integer)ssn > student.getSsn()) { return 1; }
//		else { return -1; }
		return (Integer)ssn - student.getSsn();			// 위에 코드를 한줄로 변경하였을때
		
//		이름순으로 할때
	}
*/
	
	
	
}
