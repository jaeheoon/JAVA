package sungJuk;

import java.util.ArrayList;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukPrint implements SungJuk{

	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for (SungJukDTO sungJukDTO : list) {
			System.out.println(sungJukDTO);
		}
	}
	
}
