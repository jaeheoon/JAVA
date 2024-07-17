package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukDelete implements SungJuk{
	Scanner sc = new Scanner(System.in);

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		String deleteName;
		int count = 0;
		System.out.print("삭제할 이름 입력 : ");
		deleteName = sc.next();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(deleteName)) {
				list.remove(i);
				count++;
			}
		}
		if(count > 0) System.out.println(count + "건의 항목을 삭제하였습니다");
		else System.out.println("회원의 정보가 없습니다");
	}
	
}
