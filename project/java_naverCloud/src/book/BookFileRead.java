package book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 파일 읽어오기
 */
public class BookFileRead implements Book, Serializable{
	Book book;
	
	@Override
	public void work(ArrayList<BookDTO> list) {
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream("book.txt"));
			ArrayList<BookDTO> list2 = (ArrayList<BookDTO>)os.readObject();
			for (BookDTO bookDTO : list2) {
				list.add(bookDTO);
			}
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		book = new BookPrint();
		book.work(list);
		System.out.println("불러오기에 성공하였습니다.");
		System.out.println();
	}
	
}
