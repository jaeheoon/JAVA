package book;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 도서 관리 서비스
 */
public class BookService {
	private Book book;
	
	public void menu() {
		int num;
		ArrayList<BookDTO> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			num = 0;
			System.out.println("********************************");
			System.out.println("**************메뉴**************");
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("3. 파일 저장");
			System.out.println("4. 파일 읽기");
			System.out.println("5. 책 제목으로 오름차순");
			System.out.println("6. 책 제목 검색");
			System.out.println("7. 끝");
			System.out.println("********************************");
			System.out.println();
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			
			if(num == 7) break;
			if (num == 1) book = new BookInsert();
			else if (num == 2) book = new BookPrint();
			else if (num == 3) book = new BookFileWrite();
			else if (num == 4) book = new BookFileRead();
			else if (num == 5) book = new BookTitleAsc();
			else if (num == 6) book = new BookTitleSearch();
			else {
				System.out.println();
				System.out.println("1 ~ 7번을 입력해주세요");
				System.out.println();
				continue;
			}
			book.work(list);
		}
		sc.close();
	}
}