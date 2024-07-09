package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열을 이용한 로또 번호 추출 프로그램
 * @author 홍재헌
 *
 */
public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		int money = 0, random = 0, som = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("현금 입력 : ");
		money = sc.nextInt();
		for (int k = 0; k < money/1000; k++) {
			for (int i = 0; i < lotto.length; i++) {
				while(true) {
					int count = 0;
					random = (int) ((Math.random()*45) + 1);
					for (int j = 0; j <= i; j++) {
						if (random == lotto[j]) count++;
					}
					if(count == 0) break;
				}
				lotto[i] = random;
			}
			Arrays.sort(lotto);
			for (int i = 0; i < lotto.length; i++) {
				System.out.print(lotto[i] + "\t");
			}
			System.out.println();
			som++;
			if (som%5==0) System.out.println();
		}
		sc.close();
	}
}

/*
[문제] 로또 프로그램 - 자동 번호
1. 1 ~ 45까지의 정수형 값을 가진 6개인 배열이다.
2. 중복된 숫자를 가지면 안된다.
3. 오름차순으로 정렬
4. 1줄당 1000원이다.
5. 출력 시 6자리로 맞춘다.
6. 5줄마다 줄바꿈을 한다.

[실행결과]
현금 입력 : 3200
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
	
현금 입력 : 7000
    2    4   19   39   43   44
   22   26   33   38   39   42
    5    6    8   25   35   45
    3   14   23   30   34   35
   18   20   25   27   32   37

    1   16   32   34   41   42
    5    6   18   30   33   44
*/