package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukUpdate implements SungJuk{
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		int updateNum = 0;
		boolean ck = false;
		System.out.print("수정할 번호 입력 : ");
		updateNum = sc.nextInt();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == updateNum) {
				System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(list.get(i));
				System.out.print("수정할 이름 입력 : ");
				list.get(i).setName(sc.next());
				System.out.print("수정할 국어 성적 입력 : ");
				list.get(i).setKor(sc.nextInt());
				System.out.print("수정할 영어 성적 입력 : ");
				list.get(i).setEng(sc.nextInt());
				System.out.print("수정할 수학 성적 입력 : ");
				list.get(i).setMath(sc.nextInt());
				ck = true;
				break;
			}
		}
		if (!ck) System.out.println("잘못된 번호 입니다\n");
	}
	
}
