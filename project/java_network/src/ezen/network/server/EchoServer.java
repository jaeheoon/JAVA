package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 네트워크 서버 클래스
 * @author 홍재헌
 * 230531 수업
 */
public class EchoServer {

	public static void main(String[] args) {
		int serverPort = 7777;
		
//		다중 채팅을 위해 에코 핸들러의 객체를 저장할 수 있는 콜렉터 생성
//		동기화 처리가 되어있는 HashTable로 생성 - 동기화 처리가 되어야지 메세지가 동시에 나오기 때문
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("Echo 서버["+ serverSocket.getLocalPort() +"]가 정상 실행되었습니다");
			
//			서버는 누가 끊기 전까진 계속 돌아야하기 때문에 while문 반복
			while(true) {
				Socket socket = serverSocket.accept();							// 블락 메소드
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println(clientIp+" 클라이언트 연결해옴");
				
/*				이 작업은 메인 메소드에서 하는 것이 아닌 다른 클래스에서 해주면 됨 - EchoHandler에 생성
				DataInput in = new DataInputStream(socket.getInputStream());
				DataOutput out = new DataOutputStream(socket.getOutputStream());					// String으로 만들때 사용

				while(true) {
//					입력을 위한 입력 스트림 생성
					String clientMessage = in.readUTF();
					System.out.println("- 원격 클라이언트로부터 수신한 메세지: "+ clientMessage);
				
//					출력을 위한 출력 스트림 생성
//					OutputStream out = socket.getOutputStream();										//변수처리 필요 없으니 그냥 변수처리 안하고 새로 생성
					out.writeUTF(clientMessage);														//클라이언트에게 받은 메세지를 그대로 출력, 이것이 에코 서버
					if (clientMessage.equalsIgnoreCase("break")) {
						System.out.println(clientIp+"- 원격 클라이언트가 접속을 종료하였습니다");
						break;
					}
				}*/
				
//				데이터 수신 및 송신 에코 쓰레드 생성 및 실행
				EchoHandler echoHandler = new EchoHandler(socket);
				echoHandler.start();
			}
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다.");
		}
	}

}
