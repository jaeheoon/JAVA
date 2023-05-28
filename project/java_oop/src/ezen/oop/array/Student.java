package ezen.oop.array;
/*
 * 학생정보 추상화/캡슐화
 */

import java.util.Objects;

// 마커인터페이스(추상메소드가 전혀 없는 멍텅구리 인터페이스) - 마킹만 하는 인터페이스 ex) implements Cloneable
public class Student implements Cloneable{
	public static final String SCHOOL_NAME = "이젠초등학교";		//final 함수는 상수기능(한번 정하면 잘 바뀌지 않는 int, String 등등)

	private String name;
	private int no, score;
	
	public Student() {}
	
	public Student(int no, int score, String name) {
		this.name = name;
		this.no = no;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

//	public void setNo(int no) {			학생 번호는 설정할 필요가 없기 때문에 삭제, Setter는 상황에 맞춰 만든다, 꼭 만들 필요는 없음
//		this.no = no;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
//	학생 모든 정보 출력 기능
	public void pringInfo() {
		System.out.println(no + "\t" + name + "\t" + score);
	}
	
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, no, score);
	}

	@Override
	public boolean equals(Object obj) {
//		return toString().equals(obj.toString());
		if(obj instanceof Student) {
		Student student = (Student)obj;
		if(student.toString().equals(obj.toString())) {
			return true;
			}
		}
		return false;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
