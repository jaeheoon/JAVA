package ezen.oop;
/**
 * 와일드카드 접근제한자 설명
 * @author 홍재헌
 * 230518 수업
 */
public class Person {
	String name;
	int age;
	
	@Override
		public String toString() {
			return "일반인";
		}
}

class Worker extends Person{
	@Override
	public String toString() {
		return "근로자";
	}
}

class Sstudent extends Person{
	@Override
	public String toString() {
		return "학생";
	}
}

class MiddleStudent extends Sstudent{
	@Override
	public String toString() {
		return "중학생";
	}
}

class HighStudent extends Sstudent{
	@Override
	public String toString() {
		return "고등학생";
	}
}