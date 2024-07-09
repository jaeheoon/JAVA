package array;

import java.util.Scanner;

/**
 * 24.07.09(화) 배열 정렬 숙제
 * 주차장 관리 프로그램
 * @author 홍재헌
 *
 */
public class Parking {

	public static void main(String[] args) {
		boolean[] park = new boolean[5];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int sel = 0;
			int loc = 0;
			System.out.println("주차장 관리 프로그램");
			System.out.println("**************");
			System.out.println("   1. 입차");
			System.out.println("   2. 출차");
			System.out.println("   3. 리스트");
			System.out.println("   4. 종료");
			System.out.println("**************");
			System.out.println("   메뉴 : ");
			sel = sc.nextInt();
			
			switch (sel) {
				case 1: 
					System.out.println("위치 입력 : ");
					loc = sc.nextInt();
					if (park[loc-1] == true) System.out.println((loc) + " 위치에 이미 주차되어있습니다.");
					else {
						System.out.println((loc) + " 위치에 입차");
						park[loc-1] = true;
					}
					break;
				case 2: 
					System.out.println("위치 입력 : ");
					loc = sc.nextInt();
					if (park[loc-1] == true) {
						System.out.println((loc) + " 위치에 출차");
						park[loc-1] = false;
					}
					else System.out.println((loc) + " 위치에 주차되어있지않습니다.");
					break;
				case 3: 
					for (int i = 0; i < park.length; i++) {
						System.out.println((i + 1) + " 위치 : " + park[i]);
					}
					break;
				case 4: sel = 5; break;
			}
			System.out.println();
			if (sel > 4) {
				System.out.println("프로그램을 종료하겠습니다");
				break;
			}
			
		}
		sc.close();
	}

}

/*
[문제] 주차장 관리 프로그램
[실행결과]
주차장 관리 프로그램
**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
  메뉴 : 

[1번인 경우]
위치 입력 : 3
3위치에 입차 / 이미 주차되어있습니다

[2번인 경우]
위치 입력 : 4
4위치에 출차 / 주차되어 있지않습니다

[3번인 경우]
1위치 : true
2위치 : false
3위치 : true
4위치 : false
5위치 : false
*/