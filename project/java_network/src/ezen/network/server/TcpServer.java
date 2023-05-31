package ezen.network.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

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
			System.out.println("??? 서버["+ serverSocket.getLocalPort() +"]가 정상 실행되었습니다");
			
//			서버는 누가 끊기 전까진 계속 돌아야하기 때문에 while문 반복
			while(true) {
				Socket socket = serverSocket.accept();							// 블락 메소드
				String clientIp = socket.getInetAddress().toString();
				System.out.println(clientIp+" 클라이언트 연결해옴");
				
//				출력을 위한 출력 스트림 생성
//				OutputStream out = socket.getOutputStream();										//변수처리 필요 없으니 그냥 변수처리 안하고 새로 생성
				PrintWriter out = new PrintWriter(socket.getOutputStream());						// String으로 만들때 사용
				out.printf("%1$tF %1$tT", Calendar.getInstance());									//소켓에 시간 정보 저장
				out.flush();
				socket.close();
			}
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다.");
		}
	}

}
