package ezen.oop.array;
/*
 * 성적 관리 어플 - 배열 선언, 생성, 초기화 한번에 하는 코드
 */

public class ScroreApp3 {

	public static void main(String[] args) {
		
//		참조타입 배열 선언, 생성, 초기화
		Student[][] students = {{
					new Student(1, 90, "홍재헌"),
					new Student(10, 57, "김기정"),
					new Student(14, 78, "고유나"),
					new Student(27, 87, "김지연"),
				},{
					new Student(1, 54, "홍재헌"),
					new Student(10, 87, "김기정"),
					new Student(14, 100, "고유나"),
					new Student(27, 95, "김지연"),
				},{
					new Student(1, 23, "홍재헌"),
					new Student(10, 57, "김기정"),
					new Student(14, 77, "고유나"),
					new Student(27, 29, "김지연"),
				}
		};														//선언
		double avg = 0, total = 0, cl = 0, co = 0;
		for (int i = 0; i < students.length; i++) {
			System.out.println((i+1)+"반 성적 목록 ("+students[i].length+"명)");
			
			System.out.println("----------------------------");
			System.out.println("번호\t이름\t점수");
			System.out.println("----------------------------");
			for (int j = 0; j < students[i].length; j++) {
				students[i][j].pringInfo();
				total += students[i][j].getScore();
				
			}
			avg = total/students[i].length;
			System.out.println();
			if(cl<avg) {
					cl = avg;
					co = i;
				}
			System.out.println((i+1)+"반 총점은: "+(int)total+"점 입니다.");
//			System.out.println((i+1)+"반 평균은: "+(float)avg+"점 입니다.");
			System.out.printf((i+1)+"반 평균은: "+"%7.1f\n",avg);
			System.out.println();
			total = 0;
			
		}
		System.out.println("평균이 높은 반은: "+(int)(co+1)+"반 입니다.");
		System.out.println("평균이 높은 점수는: "+(float)cl+"점 입니다.");
		
		
	}

}
