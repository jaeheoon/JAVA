package ezen.network.client;

import java.io.IOException;
import java.net.Socket;

/**
 * 네트워크 클라이언트 클래스
 * @author 홍재헌
 * 230530
 */
public class TcpClient {

	public static void main(String[] args) {
		int serverPort = 7777;
//		String serverip = "192.168.0.177";			//내 컴퓨터 IP이기 때문에 localhost라고도 함, 밑에 두개가 똑같은 말
//		String serverip = "localhost";
//		String serverip = "127.0.0.1";
		String serverip = "192.168.20.35";				//쌤 ip
		try {
			Socket socket = new Socket(serverip, serverPort);
			System.out.println("??? 서버와 TCP 연결됨");
		} catch (IOException e) {
			System.out.println("??? 서버와 연결할 수 없습니다");
		}
	}

}
