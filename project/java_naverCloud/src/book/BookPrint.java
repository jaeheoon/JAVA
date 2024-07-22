package book;

import java.util.ArrayList;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 저장되어있는 도서 목록 출력
 */
public class BookPrint implements Book{
	
	@Override
	public void work(ArrayList<BookDTO> list) {
		System.out.println();
		System.out.println("코드\t제목\t저자\t가격\t수량\t합계");
		for (BookDTO bookDTO : list) {
			System.out.println(bookDTO.getCode() + "\t" 
						     + bookDTO.getTitle() + "\t"
						     + bookDTO.getAuthor() + "\t"
						     + bookDTO.getPrice() + "\t"
						     + bookDTO.getQty() + "\t"
						     + bookDTO.getTotal());
		}
		System.out.println();
	}
}
	
