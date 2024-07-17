package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukInsert implements SungJuk{
	
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		SungJukDTO sungJukDTO = new SungJukDTO();
		Scanner sc = new Scanner(System.in);
		int kor, eng, math;
		
		System.out.print("번호 입력 : ");
		sungJukDTO.setNo(sc.nextInt());
		System.out.print("이름 입력 : ");
		sungJukDTO.setName(sc.next());
		System.out.print("국어 입력 : ");
		kor = sc.nextInt();
		sungJukDTO.setKor(kor);
		System.out.print("영어 입력 : ");
		eng = sc.nextInt();
		sungJukDTO.setEng(eng);
		System.out.print("수학 입력 : ");
		math = sc.nextInt();
		sungJukDTO.setMath(math);
		sungJukDTO.calc(kor, eng, math);
		
		list.add(sungJukDTO);
		System.out.println("입력되었습니다.");
	}
	
}
