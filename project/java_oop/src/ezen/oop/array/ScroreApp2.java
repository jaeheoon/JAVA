package ezen.oop.array;
/*
 * 성적 관리 어플 - 배열 선언, 생성, 초기화 한번에 하는 코드
 */

public class ScroreApp2 {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student(1, 90, "홍재헌"),
				new Student(10, 57, "김기정"),
				new Student(14, 78, "고유나"),
				new Student(27, 87, "김지연"),
		};
		
		System.out.println("----------------------------");
		System.out.println("번호\t이름\t점수");
		System.out.println("----------------------------");
		double total = 0, avg = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i]!=null) {
				students[i].pringInfo();
				total += students[i].getScore();
				avg = total/students.length;
			}
		}
		
		System.out.println("우리반 총점 : "+(int)total+"점입니다.");
		System.out.println("우리반 평균 : "+avg+"점입니다.");
		
	}

}
