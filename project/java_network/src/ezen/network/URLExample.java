package ezen.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * IP주소 중 URL 관련 클래스
 * @author 홍재헌
 * 230530 수업
 */
public class URLExample {

	public static void main(String[] args) throws IOException {
		/*
		 * https://www.naver.com/index.html
		 * https - 프로토콜
		 * www.naver.com - Host
		 * index.html - 주소값(path)
		 */
//		String urlString = "https://www.naver.com/index.html";		//domain = ip주소
		String urlString = "https://www.daum.net";		//domain = ip주소
		URL url = new URL(urlString);
		
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getPort());
		
//		네트워크 통신을 통해 리소스 데이터 읽기
		InputStream in = url.openStream();				// byte 스트림을 in에다 저장
//		System.out.println(in);
//		in.read();
		
//		바이트스트림 이용해서 읽어드리는 것 
		/*
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = in.read(buffer)) != 1) {
			for (byte b : buffer) {
				System.out.println(b);
			}
		} */
		
//		BufferedReader br = new BufferedReader(in); inputStream은 버퍼리더에 넣을 수 없다, 인자에 최상위클래스인 Reader를 받고있기 때문에 하위 클래스인 InputStream은 넣을 수 없다
		BufferedReader br = new BufferedReader(new InputStreamReader(in));				//InputStreamReader - 브릿지 스트림 역할 활용
		String html = "null";
		while ((html = br.readLine()) != null) {
			System.out.println(html);
		}
		
		
		
		in.close();
		
	}

}
