package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukService {
	private ArrayList<SungJukDTO> list = new ArrayList<>();
	private int num = 0;
	private SungJuk sungjuk;
	
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		while(true) {
			num = 0;
			
			System.out.println("     1. 입력");
			System.out.println("     2. 출력");
			System.out.println("     3. 수정");
			System.out.println("     4. 삭제");
			System.out.println("     5. 정렬");
			System.out.println("     6. 끝");
			System.out.print("숫자를 입력하세요 : ");
			num = sc.nextInt();
			if(num > 6 || num < 1) {
				System.out.println("1 ~ 6 중에 선택하세요");
				continue;
			}
			if(num == 6) break;
			
			if(num == 1) {
				sungjuk = new SungJukInsert();
				sungjuk.execute(list);
				continue;
			} else if(num == 2) {
				sungjuk = new SungJukPrint();
				sungjuk.execute(list);
				continue;
			} else if(num == 3) {
				sungjuk = new SungJukUpdate();
				sungjuk.execute(list);
			} else if(num == 4) {
				sungjuk = new SungJukDelete();
				sungjuk.execute(list);
			} else if(num == 5) {
				sungjuk = new SungJukSort();
				sungjuk.execute(list);
			}
		}
	}
}
