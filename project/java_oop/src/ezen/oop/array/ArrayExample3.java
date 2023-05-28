package ezen.oop.array;

/*
 * 다차원 배열 사용하기
 */

public class ArrayExample3 {

	public static void main(String[] args) {
//		int[][] classes;
//		classes = new int[5][10];	//반 수는 5개, 학생 수는 10명
//		classes[0][0] = 80;			//1반에 1번 학생
//		//.........
//		classes[0][9] = 100;		//1반에 10번 학생
//		classes[4][0] = 99;			//5반에 1번 학생
//		classes[4][9] = 50;			//5반에 10번 학생
		
		int[][] classes = {
				{60, 77, 100, 94, 43, 95, 80},
				{56, 50, 80, 94, 43}, 
				{34, 70, 20},
				{56, 98, 34, 40}, 
				{65, 96, 95, 80, 64}
				};
		
		
		double avg = 0, total = 0, cl = 0, co = 0;
		for (int i = 0; i < classes.length; i++) {
			System.out.println((i+1)+"반 성적 목록 ("+classes[i].length+"명)");
			for (int j = 0; j < classes[i].length; j++) {
				System.out.print((j+1)+"번 성적: "+ classes[i][j]+"점 ");
				total += classes[i][j];
				
			}
			avg = total/classes[i].length;
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
