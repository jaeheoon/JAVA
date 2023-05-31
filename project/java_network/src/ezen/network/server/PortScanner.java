package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ServerSocket을 이용한 포트 스캐너
 * 내 컴퓨터에서 사용중인 포트 넘버 확인
 * @author 홍재헌
 * 230531 수업
 */
public class PortScanner {

	public static void main(String[] args) {
		System.out.println("내 컴퓨터에서 사용 중인 포트 번호 목록");
		for (int i = 0; i < 65535; i++) {
			try {
				ServerSocket serverSocket = new ServerSocket(i);
			} catch (IOException e) {
				System.out.println("포트번호: "+i);
			}
		}
	}

}
