package ezen.io.bytee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 이미지 파일 읽어들이기
 * @author 홍재헌
 * 230525 수업
 */
public class FileInputExample2 {
	public static void main(String[] args) {
		String urlString = "https://mml.pstatic.net/www/mobile/edit/20230523_1095/upload_1684853651858jmD48.png";
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		InputStream in = null;
		try {
			in = url.openStream();
			
			byte[] buffer = new byte[1024];
			int byteCount = 0;
			int totalBytes = 0;
			/*int byteCount = in.read(buffer);
			int totalBytes = 0;
			for (int i = 0; i < byteCount; i++) {
				totalBytes += byteCount;
				System.out.println(totalBytes);
			}*/  //기본 개념
			while ((byteCount = in.read(buffer)) != -1) {	//읽는 파일의 끝인 -1이 아닐 경우 계속 읽는다
				totalBytes += byteCount;
				for (int i = 0; i < byteCount; i++) {
					System.out.println(buffer[i]);
				}
			}
			
			System.out.println("파일을 다 읽었습니다");
			
//			표준 입력(키보드)
			System.out.print("아무키나 입력하세요: ");
			in = System.in;								//System.in;은 키보드 입력값 받는 역할
//			int byteData = in.read();
//			System.out.println(byteData);
			byte[] buffer2 = new byte[10];
			byteCount = 0;
			while((byteCount = in.read(buffer2)) != -1) {
				for (int i = 0; i < byteCount; i++) {
//					문자 디코딩
					char c = (char)buffer2[i];
					System.out.print(buffer2[i] + " ");		//값을 abcd로 입력하면 4개(97 98 99 100)로 나와야하지만 실질적으로는 6개가 나옴(13 10 추가) 왜냐하면 13, 10은 엔터 값임
					System.out.print(c);
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
