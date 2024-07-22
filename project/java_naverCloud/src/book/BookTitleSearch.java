package book;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 도서 제목으로 검색
 */
public class BookTitleSearch implements Book{
	private String searchTitle;
	private boolean ck = false;
	private Book book = null;

	@Override
	public void work(ArrayList<BookDTO> list) {
		Scanner sc = new Scanner(System.in);
		ArrayList<BookDTO> searchList = new ArrayList<>();
		
		System.out.println();
		System.out.print("검색할 제목을 입력하세요 : ");
		searchTitle = sc.next();
		for (BookDTO bookDTO : list) {
			if(bookDTO.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
				searchList.add(bookDTO);
				ck = true;
			}
		}
		if (!ck) {
			System.out.println();
			System.out.println("검색된 내용이 없습니다");
			System.out.println();
		} else {
			book = new BookPrint();
			book.work(searchList);
		}
	}
	
}
