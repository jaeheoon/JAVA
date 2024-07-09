package for_;

import java.util.Scanner;

/**
 * 반복문으로 덧셈 계산 구하는 프로그램
 * @author 홍재헌
 *
 */
public class AddGame {

	public static void main(String[] args) {
		int a, b;						//문제
		int dab=0, user=0;				//사용자가 입력한 값
		String yn; 						// Y/N Y = 계속, N = 끝
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int count=0;				//정답 횟수
			for (int i = 1; i <= 5; i++) {
				a = (int) (Math.random() * 90) + 10;
				b = (int) (Math.random() * 90) + 10;
				dab = a+b;
				for (int j = 0; j < 2; j++) {
					System.out.print("["+i+"] "+a+"+"+b+" = ");
					user = sc.nextInt();
					if(user == dab) {
						System.out.println("딩동댕");
						count++;
						break;
					} else if (j == 0){
						System.out.println("틀렸다 다시 풀어라");
					} else {
						System.out.println("틀렸다 정답은 : " + dab);
					}
				}
			}
			System.out.println("당신은 총 "+count+"문제 맞추어서 점수 "+(count*20)+"점입니다.");
			
			do {
				System.out.print("또 할래(Y/N) : ");
				yn = sc.next();
			} while (!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n"));
			
			if(yn.equals("N") || yn.equals("n")) {
				System.out.println("다음에 또 만나요~");
				break;
			}
		}
		sc.close();
	}

}

/*
[문제] 덧셈 계산 (while, 다중 for)
- 10 ~ 99 사이의 난수를 2개 발생하여 합을 구하는 프로그램
- 5문제를 제공한다.
- 1문제당 점수 20점씩 처리한다.
- 틀리면 1번 더 기회를 주고, 2번 다 틀리면 답을 알려준다.
- y 또는 n 은 대소문자 구분X

[실행결과]
[1] 25 + 36 = 50
틀렸다
[1] 25 + 36 = 59
틀렸다 정답은 xx

[2] 10 + 25 = 35
딩동댕

...

[5] 78 + 95 = 89
틀렸다
[5] 78 + 95 = 173
딩동댕

당신은 총 x 문제를 맞추어서 점수 xx점 입니다.

또 할래(Y/N) : A
또 할래(Y/N) : w
또 할래(Y/N) : n

프로그램을 종료합니다.
 */