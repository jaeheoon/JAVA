package ezen.oop.array;

public class ArrayExample {

	public static void main(String[] args) {
		
		int[] scores;			//기본 타입 배열 선언 Account array;라는 것과 똑같다고 생각하면 됨 Account = int[], array = scores
		scores = new int[30];	// 배열 인스턴스(객체) 생성, []에 넣는 숫자는 배열을 생성할 때 자동으로 length라는 변수에도 넣어짐
//		int[] scores = new int[27];  //위에 코드와 같은 코드
		
//		배열 원소 접근
		System.out.println(scores[0]);
		scores[0] = 95;
		scores[1] = 50;
		//.........
		scores[26] = 56;
		System.out.println(scores[26]);
		
//		for문을 이용한 배열에 값 넣기
		for(int i = 0; i<30; i++) {
			scores[i] = (70 + i);
		}
		
		for (int i = 0; i < scores.length; i++) {		//자동으로 생성된 length라는 변수를 사용하여 반복문
			System.out.println(scores[i]);
		}
		
//		int total = 0;
		double total = 0;
		for (int i = 0; i < scores.length; i++) {		//자동으로 생성된 length라는 변수를 사용하여 반복문
			total += scores[i];
		}
		
		double avg = total/scores.length;		//강제 형변환을 이용해 소숫점이 나오도록 유도함 or 선언할때 애초에 double로 하면 됨
		
		System.out.println("우리반 점수 총점: "+ total);
		System.out.println("우리반 점수 평균: "+ avg);
		
	}

}
