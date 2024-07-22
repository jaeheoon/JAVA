package book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 파일 저장
 */
public class BookFileWrite implements Book, Serializable{
	
	@Override
	public void work(ArrayList<BookDTO> list) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("book.txt"));
			os.writeObject(list);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("저장에 성공하였습니다.");
	}
	
}
