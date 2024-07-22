package book;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 도서 제목으로 정렬
 */
public class BookTitleAsc implements Book{
	Book book;

	@Override
	public void work(ArrayList<BookDTO> list) {
		Collections.sort(list);
		book = new BookPrint();
		System.out.println();
		System.out.println("정렬되었습니다");
		book.work(list);
	}
	
}
