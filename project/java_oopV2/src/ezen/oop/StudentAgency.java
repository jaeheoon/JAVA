package ezen.oop;

public class StudentAgency implements Rentable<Student<String>> {

	@Override
	public Student<String> rent() {
		Student<String> student = new Student<>("홍재헌", "1111");
		return student;
	}
	
	public static void main(String[] args) {
		Rentable<Student<String>> rentable = new StudentAgency(); 

		Student<String> student=rentable.rent();
		System.out.println(student);
	}
}
