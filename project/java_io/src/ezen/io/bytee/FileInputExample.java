package ezen.io.bytee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 이미지 파일 읽어들이기
 * @author 홍재헌
 * 230525 수업
 */
public class FileInputExample {
	public static void main(String[] args) {
//		String file = "c:/fullstack/....";		//정적으로 경로 알아오기
		String file = FileInputExample.class.getResource("/assets/cosmo.jpg").getFile();		//동적으로 경로 알아오기
		InputStream in = null;
		try {
//			입력빨때	
			in = new FileInputStream(file);
			/*
			while (true) {
				
				int byteData = in.read();	//한바이트 데이터 읽어옴
				if (byteData == -1) {
					break;
				}
				System.out.println(byteData);
			}
			*/
//	한바이트씩 읽는 방법
			/*
			int byteData = 0;
			while ((byteData = in.read()) != -1) {
				System.out.println(byteData);
			}
			*/
//	효율적으로 파일 바이트 읽는 방법 - read(byte[] buffer)는 바이트 배열이 담겨있는 수를 세준다
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
				System.out.println(totalBytes); 	//사진의 바이트 크기 확인
			}
			
			
			System.out.println("파일을 다 읽었습니다");
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
