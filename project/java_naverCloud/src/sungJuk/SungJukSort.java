package sungJuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukSort implements SungJuk, Comparator<SungJukDTO>{
	Scanner sc = new Scanner(System.in);

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		while(true) {
			int num = 0;
			System.out.println("********************");
			System.out.println("1. 총점으로 내림차순");
			System.out.println("2. 이름으로 오름차순");
			System.out.println("3. 이전 메뉴");
			System.out.println("********************");
			System.out.print("숫자를 입력하세요 : ");
			num = sc.nextInt();
			if(num > 4 || num < 1) {
				System.out.println("1 ~ 3 중에 선택하세요");
				continue;
			}
			if(num == 3) break;
			if(num == 1) {
				totSort(list);
				break;
			}
			else if(num == 2) {
				nameSort(list);
				break;
			}
		}
	}
	
	public void totSort(ArrayList<SungJukDTO> list) {
		Collections.sort(list, new SungJukSort());
	}
	public void nameSort(ArrayList<SungJukDTO> list) {
		Collections.sort(list);
	}

	@Override
	public int compare(SungJukDTO sungJuk1, SungJukDTO sungJuk2) {
		return sungJuk1.getTot() < sungJuk2.getTot() ? 1 :
			   sungJuk1.getTot() > sungJuk2.getTot() ? -1 : 0;
	}
}


