package ezen.io.bytee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 이미지 파일 출력하기
 * @author 홍재헌
 * 230525 수업
 */
public class FileOutputExample {

	public static void main(String[] args) throws IOException {
		String file = FileOutputExample.class.getResource("/assets/").getFile();		//동적으로 경로 알아오기
		file += "example.dat";
		
		OutputStream out = new FileOutputStream(file, false);	//FileOutputStream(파일, 데이터 추가 작업)
		/*
		byte byteData = 10;
		out.write(byteData);
		out.close();
		*/			//기본
		byte[] buffer = {97, 98, 99, 100, 101};
		out.write(buffer);
		System.out.println("파일 생성 완료");
		
		out = System.out;
		out.write((char)97);		//출력이 되고있으나 디버깅창 오류
		out.close();
		
	}

}
