package homework;

import java.util.Scanner;

/**
 * 다중 배열을 사용한 성적 처리 프로그램
 * @author 홍재헌
 *
 */
public class SungJuk {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subjectCnt = 0;
		int num = 0;
		
		System.out.print("인원 수 : ");
		num = sc.nextInt();
		
		String[][] subject = new String[num][];
		int[][] jumsu = new int[num][];
		String[] name = new String[num];
		int[] sum = new int[num];
		double[] avg = new double[num];
		
//		구현
		for (int i = 0; i < num; i++) {
			System.out.print("이름 : ");
			name[i] = sc.next();
			System.out.print("과목 수 : ");
			subjectCnt = sc.nextInt();
			for(int j = 0; j < num; j++) {
				subject[i] = new String[subjectCnt];
				jumsu[i] = new int[subjectCnt];
			}
			for (int j = 0; j < subjectCnt; j++) {
				System.out.print("과목명 : ");
				subject[i][j] = sc.next();
			}
			for (int j = 0; j < subjectCnt; j++) {
				System.out.print(subject[i][j] + "과목 점수 : ");
				jumsu[i][j] = sc.nextInt();
				sum[i] += jumsu[i][j];
			}
			avg[i] = (((double)sum[i])/subject[i].length);
		}
		
//		출력
		for (int i = 0; i < num; i++) {
			System.out.print("이름\t\t");
			for (int j = 0; j < subject[i].length; j++) {
				System.out.print(subject[i][j] + "\t");
			}
			System.out.print("총점\t평균");
			System.out.println();
			System.out.print(name[i] + "\t\t");
			for (int j = 0; j < jumsu[i].length; j++) {
				System.out.print(jumsu[i][j] + "\t");
			}
			System.out.print(sum[i]+"\t"+String.format("%.2f", avg[i]));
			System.out.println();
		}
		
		sc.close();
	}

}

/*
[문제] 성적 계산
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 (cnt)

이름 입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
---------------------
이름 입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------

이름     국어  영어   총점     평균
홍길동    95   100    xxx     xx.xx

이름 	국어  영어   과학    총점      평균
이기자 	 95   100     90 	  xxx      xx.xx
*/