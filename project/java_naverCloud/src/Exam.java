import java.util.Scanner;

/**
 * 클래스를 사용한 성적 처리 클래스
 * @author 홍재헌
 *
 */
public class Exam {
	private final String JUNG = "11111"; //상수화
	
	private String name = null;
	private String dap = null;
	private char[] ox = null;
	private int score = 0;
	
	public Exam() {}
	public Exam(int count) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("답 : ");
		dap = sc.next();
		compare(name, dap);
	}
	
	public void compare(String name, String dap) {
		score = 0;
		ox = new char[5];
		for (int i = 0; i < dap.length(); i++) {
			if (dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				score += 20;
			}
			else ox[i] = 'X';
		}
	}
	
	public String getName() {
		return name;
	}
	
	public char[] getOx() {
		return ox;
	}
	
	public int getScore() {
		return score;
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