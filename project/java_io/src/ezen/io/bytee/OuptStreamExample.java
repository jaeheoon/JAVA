package ezen.io.bytee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OuptStreamExample {

	public static void main(String[] args) throws IOException {
		String file = OuptStreamExample.class.getResource("/assets/").getFile();
		file += "example.dat";
		
		OutputStream out = new FileOutputStream(file, true);
//		byte byteData = 97;
//		out.write(byteData);
//		out.close();
		
		byte[] buffer = {97, 98, 99, 100, 101};
//		out.write(buffer);
		out.write(buffer, 0,3);
		System.out.println("파일 출력 완료...");
		
		out = System.out;
		//out.write((char)97);
		out.close();
		
	}

}






