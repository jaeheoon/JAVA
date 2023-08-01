package ezen.oop.array;

/*
 * 성적 관리 어플
 */
public class ScoreApp3 {

	public static void main(String[] args) {
		
		Student[][] students = { 
				{	new Student(1, "김기정", 90), 
					new Student(2, "강소영", 95),
					new Student(3, "김지연", 100),
					new Student(4, "고유나", 90)
				}, 
				{
					new Student(1, "김기정", 90), 
					new Student(2, "강소영", 95),
					new Student(3, "김지연", 100),
				}, 
				{
					new Student(1, "김기정", 90), 
					new Student(2, "강소영", 95),
				}
			};
//		반목록
		for (int i = 0; i < students.length; i++) {
			System.out.println((i+1) + "반 성적 목록("+students[i].length+"명)");
			double total = 0, avg = 0;
//			학생목록
			System.out.println("------------------------");
			System.out.println("번호\t이름\t점수");
			System.out.println("------------------------");
			for (int j = 0; j < students[i].length; j++) {
				students[i][j].printInfo();
				total += students[i][j].getScore();
			}
			avg = total / students[i].length;
			System.out.println();
			System.out.println((i+1)+ "반 총점 : " + total);
			System.out.println((i+1) + "반 평균 : " + avg);
		}

	}

}











