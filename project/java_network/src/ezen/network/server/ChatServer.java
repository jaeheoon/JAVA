package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;

/**
 * 네트워크 서버 클래스
 * 채팅을 위해 채팅 서버 생성
 * HashTable을 생성하여 다중 클라이언트 담아놓고 키와 밸류 쌍으로 관리
 * @author 홍재헌
 * 230531 수업
 */
public class ChatServer {
	
//	다중 채팅을 위해 에코 핸들러의 객체를 저장할 수 있는 콜렉터 생성
//	동기화 처리가 되어있는 HashTable로 생성 - 동기화 처리가 되어야지 메세지가 동시에 나오기 때문
	static Hashtable<String, ChatHandler> clients = new Hashtable<String, ChatHandler>();
	
//	서버에 연결한 모든 클라이언트들에게 메세지 전송 기능
	public static void sendMessageAll(String message) throws IOException {
		Collection<ChatHandler> list = clients.values();			//Hashtable에 저장되어있는 값 리턴
		for (ChatHandler chatHandler : list) {
			chatHandler.sendMessage(message);									//chatHandler가 가지고 있는 Out을 출력
		}
	}

	public static void main(String[] args) {
		int serverPort = 7777;
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("chat 서버["+ serverSocket.getLocalPort() +"]가 정상 실행되었습니다");
			
//			서버는 누가 끊기 전까진 계속 돌아야하기 때문에 while문 반복
			while(true) {
				Socket socket = serverSocket.accept();							// 블락 메소드
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println(clientIp+" 클라이언트 연결해옴");
				
//				데이터 수신 및 송신 에코 쓰레드 생성 및 실행
				ChatHandler chatHandler = new ChatHandler(socket);
				clients.put(clientIp, chatHandler);
				chatHandler.start();
			}
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다.");
		}
	}

}
