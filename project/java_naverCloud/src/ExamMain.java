import java.util.Scanner;

/**
 * 클래스를 사용한 성적 처리 메인 프로그램 
 * @author 홍재헌
 *
 */
public class ExamMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out.print("인원 수 입력 : ");
		int size = sc.nextInt();
		Exam[] ex = new Exam[size];
		
		for (int i = 0; i < size; i++) {
			ex[i] = new Exam(size);
		}
		sb.append("이름")
		.append("\t")
		.append("1 ")
		.append("2 ")
		.append("3 ")
		.append("4 ")
		.append("5 ")
		.append("점수")
		.append("\n");
		for (int i = 0; i < size; i++) {
			sb.append(ex[i].getName()).append("\t");
			for (int j = 0; j < ex[i].getOx().length; j++) {
				sb.append(String.valueOf(ex[i].getOx()).charAt(j)).append("  ");
			}
			sb.append(ex[i].getScore()).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}

/*
[문제] 사지선다형
- 문제 수는 총 5문제 제공
- 1문제당 20점씩 처리
- 정답은 "11111"이다.

[실행결과]
인원수 입력 : 3		<--- main 메소드

이름 입력 : 홍길동
답 입력 : 12311

이름 입력 : 김태리
답 입력 : 12341 

이름 입력 : 유연석
답 입력 : 12111 

이름 1 2 3 4 5	점수
홍길동  O X X O O	60
김태리  O X X X O	40
유연석  O X O O O	80
*/