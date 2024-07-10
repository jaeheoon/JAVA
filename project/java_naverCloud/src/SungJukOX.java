package homework;

import java.util.Scanner;

/**
 * 다중 배열을 사용한 성적 처리 프로그램
 * @author 홍재헌
 *
 */
public class SungJukOX {
	static final String JUNG = "11111";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int num = sc.nextInt();
		
		String[] name = new String[num];
		String dap;
		char[][] ox = new char[num][5];	//2명의 5문제
		int[] score = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("이름 : ");
			name[i] = sc.next();
			System.out.print("답안지 : ");
			dap = sc.next();
			for (int j = 0; j < dap.length(); j++) {
				if (dap.charAt(j) == JUNG.charAt(j)) {
					ox[i][j] = 'O';
					score[i] += 20;
				}
				else ox[i][j] = 'X';
			}
			System.out.println();
		}
		System.out.println("\t\t\t*** 성적표 ***\t\t\t");
		System.out.println("이름\t\t1\t2\t3\t4\t5\t\t점수");
		for (int i = 0; i < num; i++) {
			System.out.println(name[i] + "\t\t" + ox[i][0] + "\t" + ox[i][1] + "\t" + ox[i][2] + "\t" + ox[i][3] + "\t" + ox[i][4] + "\t\t" + score[i]);
		}
		
		sc.close();
	}

}

/*
[문제] 성적 처리 프로그램
- 5문제는 사지선다형 문제
- 정답은 "11111" - 100점 만점
  static final String JUNG = "11111"; //상수화 
- 1문제당 20점씩 한다.
  
[실행결과]
인원수 : 2

이름 : 홍길동
답안지 : 12311

이름 : 코난
답안지 : 11311

			***	성적표 ***
이름		1  2  3  4  5 		점수
홍길동		o  x  x  o  o		 60
코난		o  o  x  o  o		 80
*/