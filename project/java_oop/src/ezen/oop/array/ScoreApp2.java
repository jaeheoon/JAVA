package ezen.oop.array;

/*
 * 성적 관리 어플
 */
public class ScoreApp2 {

	public static void main(String[] args) {
//		Student student = new Student(1, "김기정", 90);
//		student.printInfo();
		
//		참조타입 배열 선언, 생성, 초기화
//		Student[] students;
//		students = new Student[27];
//		students[0] = new Student(1, "김기정", 90);
//		//
//		students[26] = new Student(2, "강소영", 95);
		
		Student[] students = { 
				new Student(1, "김기정", 90), 
				new Student(2, "강소영", 95),
				new Student(3, "김지연", 100),
				new Student(4, "고유나", 90),
				
		};
		
		System.out.println("------------------------");
		System.out.println("번호\t이름\t점수");
		System.out.println("------------------------");
		double total = 0, avg = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				students[i].printInfo();
				total += students[i].getScore();
			}
		}
		avg = total / students.length;
		
		System.out.println("우리반 총점 : " + total);
		System.out.println("우리반 평균 : " + avg);
		
		

	}

}











