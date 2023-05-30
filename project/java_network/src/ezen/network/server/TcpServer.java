package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 네트워크 서버 클래스
 * @author 홍재헌
 * 230530 수업
 */
public class TcpServer {

	public static void main(String[] args) {
		int serverPort = 7777;
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("??? 서버가 정상 실행되었습니다");
			
//			서버는 누가 끊기 전까진 계속 돌아야하기 때문에 while문 반복
			while(true) {
				Socket socket = serverSocket.accept();							// 블락 메소드
				System.out.println("??? 클라이언트 연결해옴");
			}
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다.");
		}
	}

}
