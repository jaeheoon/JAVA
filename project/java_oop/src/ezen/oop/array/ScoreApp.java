package ezen.oop.array;

/*
 * 성적 관리 어플
 */
public class ScoreApp {

	public static void main(String[] args) {
//		Student student = new Student(1, "김기정", 90);
//		student.printInfo();
		
//		참조타입 배열 선언, 생성, 초기화
		Student[] students;
		students = new Student[27];
		students[0] = new Student(1, "김기정", 90);
		//
		students[26] = new Student(2, "강소영", 95);
		
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				students[i].printInfo();
			}
		}
		
		

	}

}











