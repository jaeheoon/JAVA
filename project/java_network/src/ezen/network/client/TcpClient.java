package ezen.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		String serverip = "localhost";
//		String serverip = "127.0.0.1";
//		String serverip = "192.168.20.35";				//쌤 ip
		try {
			Socket socket = new Socket(serverip, serverPort);
			System.out.println("타임 서버와 TCP 연결됨");
			/*
			 * BufferedReader - 문자스트림 읽을때 필요
			 * InputStreamReader - BufferedReader에 InputStream을 바로 넣을 수 없기 때문에 브릿지 역할
			 * getInputStream - 소켓 안에 있는 정보 읽어오는 역할
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String time = in.readLine();
			System.out.println("서버에서 수신한 시간: " + time);
			socket.close();
			
		} catch (IOException e) {
			System.out.println("??? 서버와 연결할 수 없습니다");
		}
	}

}
