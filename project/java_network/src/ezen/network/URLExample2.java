package ezen.network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * URL에 해당하는 이미지파일 다운로드
 * @author 홍재헌
 * 230530 수업
 */
public class URLExample2 {

	public static void main(String[] args) throws IOException {
		String urlString = "https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";		//domain = ip주소
		URL url = new URL(urlString);
		
//		네트워크 통신을 통해 리소스 데이터 읽기
		InputStream in = url.openStream();				// byte 스트림을 in에다 저장
		
		String saveFile = "google.png";
		FileOutputStream out = new FileOutputStream(saveFile);
		
//		바이트스트림 이용해서 읽어들이는 것 
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = in.read(buffer)) != 1) {
			out.write(buffer, 0, count);
		}
		
		System.out.println("파일 다운로드 완료!");
		
		out.close();
		in.close();
		
	}

}
