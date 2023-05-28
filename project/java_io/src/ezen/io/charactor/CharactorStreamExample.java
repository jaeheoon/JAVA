package ezen.io.charactor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * 문자스트림 이용하여 읽고 쓰기
 * @author 홍재헌
 * 230526 수업
 */
public class CharactorStreamExample {
	
	static String file = "src/ezen/io/bytee/BufferedInputExample.java";
	
//	텍스트 파일을 읽을땐 BufferedReader를 이용
	public static void readCharactor() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file)); 
//		String line = in.readLine();					//텍스트 라인별로 읽어오는 메소드, 지금은 하나밖에 없기때문에 첫줄만 읽어온다
		String txt = null;
		while((txt = in.readLine()) != null) {
			System.out.println(txt);
		}
		in.close();
	}
	
//	파일을 저장할때는 printWriter를 이용, BufferedWriter를 안쓰는 이유는 일일히 문자열의 줄을 바꿔줘야하기때문에 printWriter를 사용한다
	public static void writeCharactor() throws FileNotFoundException {
		String newFile = "exampleWrite.txt";
		
		PrintWriter out = new PrintWriter(newFile);					//프린트스트림이랑 똑같다
		out.print(true);
		out.print('김');
		out.print("기정");
		out.print(70);
		out.print(50.56);
		out.println();
		out.printf("%1$tF %1$tT", Calendar.getInstance());
		out.close();
	}

	public static void main(String[] args) throws IOException {
		readCharactor();
		writeCharactor();
	}


}
