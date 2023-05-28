package ezen.oop.api;

import ezen.oop.array.Student;

public class ObjectExample {

	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.hashCode());
		Object obj1 = new Object();
		System.out.println(obj1.hashCode());
		String name = "java";
		System.out.println(name.hashCode());
		
		Student student1 = new Student(1, 90, "홍재헌");
		System.out.println(student1); //toString() 자동 호출됨
		
		Student student2 = new Student(10, 90, "홍재헌");
		System.out.println(student1.equals(student2));
		
		try {
			Student student3 = (Student)student1.clone();
			System.out.println(student3);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
