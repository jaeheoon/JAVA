package array;

import java.util.Scanner;

/**
 * 배열을 이용한 야구 숫자 맞추기 게임
 * @author 홍재헌
 *
 */
public class BaseBall {

	public static void main(String[] args) {
		int[] com = new int[3];
		int[] user = new int[3];
		int random = 0;
		int som = 0;
		Scanner sc = new Scanner(System.in);
		String yn;
		
		while(true) {
			do {
				System.out.print("게임을 실행하시겠습니까(Y/N) : ");
				yn = sc.next();
			} while (!yn.equals("Y") && !yn.equals("y") && !yn.equals("N") && !yn.equals("n"));
			
			if(yn.equals("N") || yn.equals("n")) {
				System.out.println("다음에 또 만나요~");
				break;
			}
			//난수 발생
			for (int i = 0; i < com.length; i++) {
				while (true) {
					int count = 0;
					random = (int) ((Math.random() * 9) + 1);
					for (int j = 0; j < 3; j++) {
						if (random == com[j]) count++;
					}
					if (count == 0) break;
				}
				com[i] = random;
			}
			System.out.println();
			
			while(true) {
				int st = 0;
				int ball = 0;
				
				//유저 입력값
				while (true) {
					int count = 0;
					
					System.out.print("숫자 입력 : ");
					som = sc.nextInt();
					user[0] = som/100;
					user[1] = (som/10)%10;
					user[2] = som%10;
					for (int i = 0; i < user.length; i++) {
						for (int j = 0; j < user.length; j++) {
							if (i != j) {
								if(user[i] == user[j]) count++;
							}
						}
					}
					if(count == 0) break;
					else System.out.println("중복되는 숫자가 있습니다.");
				}
				for (int i = 0; i < user.length; i++) {
					if (user[i] == com[i]) st++;
					else {
						for (int j = 0; j < user.length; j++) {
							if(user[i] != com[i] && user[i] == com[j]) ball++;
						}
					}
				}
				System.out.println(st+"스트라이크 "+ball+"볼");
				System.out.println();
				if (st == 3) {
					System.out.println("정답을 맞췄습니다. 프로그램을 종료합니다.");
					System.out.println();
					break;
				}
			}
		}
		sc.close();
	}

}

/*
[문제] 야구게임
- 크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
- 발생한 수를 맞추는 게임
- 중복은 제거한다

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : u
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
0스트라이크 0볼

숫자입력 : 567
0스트라이크 2볼

숫자입력 : 758
1스트라이크 2볼
...

숫자입력 : 785
3스트라이크 0볼

프로그램을 종료합니다.
 */