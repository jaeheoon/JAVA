package ezen.oop;

public class Course {
//	Applicant 안에 사람들이면 누구나 등록 가능
	public void addCourse(Applicant<?> applicant) {
		System.out.println(applicant.getKind().toString());
	}
//	Applicant 안에 학생들이면 누구나 등록 가능
	public void addCourse1(Applicant<? extends Sstudent> applicant) {
		System.out.println(applicant.getKind().toString());
	}
//	Applicant 안에 학생 제외한 일반 사람, 근로자 등록 가능
	public void addCourse2(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().toString());
	}
	
	public static void main(String[] args) {
		Course course = new Course();
		
		Applicant<Person> person = new Applicant<>(new Person());
		course.addCourse(person);
		
		course.addCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		course.addCourse1(new Applicant<HighStudent>(new HighStudent()));
//		course.addCourse1(new Applicant<Worker>(new Worker()));					// addCourse1엔 학생들이어야하는데 Worker가 들어가니 안되는 모습
		
		course.addCourse2(new Applicant<Person>(new Person()));
		course.addCourse2(new Applicant<Worker>(new Worker()));
//		course.addCourse2(new Applicant<HighStudent>(new HighStudent()));		// addCourse2엔 일반인/근로자들이어야하는데 HighStudent가 들어가니 안되는 모습
		
		
	}
}
