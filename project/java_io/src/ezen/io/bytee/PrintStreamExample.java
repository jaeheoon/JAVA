package ezen.io.bytee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Calendar;

/**
 * Print Stream 수업
 * @author 홍재헌
 * 230526 수업
 */
public class PrintStreamExample {

	public static void main(String[] args) throws FileNotFoundException {
//		표준 출력
//		PrintStream out = System.out;					//기존에 System.out.println 할때 그 out은 PrintStream을 out으로 나타낸 것이다
//		out.println(5);
//		out.printf("%,+d", 100000000);
		String file = "example2.txt";
		
//		PrintStream out = new PrintStream(new FileOutputStream(file));
//		PrintStream out = new PrintStream(file);
		PrintStream out = new PrintStream(new File(file));
		out.print(true);
		out.print('김');
		out.print("기정");
		out.print(70);
		out.print(50.56);
		out.println();
		out.printf("%1$tF %1$tT", Calendar.getInstance());
		out.close();
		System.out.println("텍스트 파일 생성 완료");
	}

}
