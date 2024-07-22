package book;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 도서 추가
 */
public class BookInsert implements Book{
	BookDTO bookDTO = new BookDTO();
	Scanner sc = new Scanner(System.in);

	@Override
	public void work(ArrayList<BookDTO> list) {
		System.out.println();
		System.out.print("코드 입력 : ");
		bookDTO.setCode(sc.nextInt());
		System.out.print("책 제목 입력 : ");
		bookDTO.setTitle(sc.next());
		System.out.print("저자 입력 : ");
		bookDTO.setAuthor(sc.next());
		System.out.print("단가 입력 : ");
		bookDTO.setPrice(sc.nextInt());
		System.out.print("개수 입력 : ");
		bookDTO.setQty(sc.nextInt());
		bookDTO.calc();
		
		list.add(bookDTO);
	}
	
}
