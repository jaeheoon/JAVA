import java.util.Scanner;

/**
 * 반복문으로 숫자 맞추는 프로그램
 * @author 홍재헌
 *
 */
public class NumberGame {
/*
[문제] 숫자 맞추기 게임
- 숫자의 범위는 1부터 100 사이
- 컴퓨터가 숫자를 생성하면 사용자가 맞추는 프로그램

[실행결과]
1 ~ 100 사이의 숫자가 발생했습니다. ex)컴퓨터 발생 숫자 (87)

숫자 입력 : 50
50보다 큰 숫자입니다.

숫자 입력 : 95
95보다 작은 숫자입니다.

~~~

숫자 입력 : 87
딩동댕 x번만에 맞추셨습니다.
 */
	public static void main(String[] args) {
		int random = (int) (Math.random() * 100 + 1);
		int count = 0;
		int user = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("1 ~ 100 사이의 숫자가 발생했습니다.");
		while (user != random) {
			System.out.print("숫자를 입력하세요 : ");
			user = sc.nextInt();
			count++;
			if(user < random) System.out.println(user + "보다 큰 숫자입니다.");
			if(user > random) System.out.println(user + "보다 작은 숫자입니다.");
			if(user == random) {
				System.out.println("딩동댕!! " + count + "번만에 맞추셨습니다.");
				break;
			}
		}
		sc.close();
		
	}

}
