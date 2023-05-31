package ezen.network.client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 네트워크 클라이언트 클래스
 * @author 홍재헌
 * 230531 수업
 */
public class EchoClient {

	public static void main(String[] args) {
		int serverPort = 7777;
//		String serverip = "192.168.0.177";				//내 컴퓨터 IP이기 때문에 localhost라고도 함, 밑에 두개가 똑같은 말
//		String serverip = "localhost";
//		String serverip = "127.0.0.1";
		String serverip = "192.168.20.35";				//쌤 ip
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket(serverip, serverPort);
			System.out.println("Echo 서버와 TCP 연결됨");
			
//			출력을 위한 출력 스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());					// String으로 만들때 사용
			DataInput in = new DataInputStream(socket.getInputStream());
			
			while(true) {
				System.out.println("서버에 전송하고자 하는 메세지 입력: ");
				String inputMessage = scanner.nextLine();
				if (inputMessage.equalsIgnoreCase("q")) {
					out.writeUTF("break");														//클라이언트쪽만 나가는 것이 아닌 서버에도 나간다고 보내줘야한다
					break;
				}
			
//				서버에 메세지 전송
				out.writeUTF(inputMessage);
			
//				입력을 위한 입력 스트림 생성
				String echoedMessage = in.readUTF();
				
				System.out.println("Echo 메세지: " + echoedMessage);
			}
			socket.close();
			scanner.close();
			
		} catch (IOException e) {
			System.out.println("Echo 서버와 연결할 수 없습니다");
		}
	}

}
