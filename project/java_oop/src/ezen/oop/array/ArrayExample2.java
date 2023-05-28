package ezen.oop.array;

public class ArrayExample2 {

	public static void main(String[] args) {
//		배열 선언, 생성, 초기화 동시에	<- 배열 묵시적 생성
//		int[] scores = new int[] {90, 85, 77, 100, 65};
//		배열 리터럴 표현식
		int[] scores = {90, 85, 77, 100, 65};
		
		System.out.println("학생수: "+scores.length+"명");
		
		double total = 0, avg = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
			
		}
		avg = total/scores.length;
		System.out.println("학생들의 총점은: "+(int)total+"점입니다.");
		System.out.println("학생들의 평균은: "+avg+"점입니다.");
	}

}
