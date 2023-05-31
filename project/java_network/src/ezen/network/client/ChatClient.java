package ezen.network.client;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.midi.Track;

/**
 * 네트워크 클라이언트 클래스
 * @author 홍재헌
 * 230531 수업
 */
public class ChatClient {

	public static void main(String[] args) {
		int serverPort = 7777;
		String serverip = "localhost";
//		String serverip = "127.0.0.1";
//		String serverip = "192.168.20.35";				//쌤 ip
		Scanner scanner = new Scanner(System.in);
		
		try {
			Socket socket = new Socket(serverip, serverPort);
			System.out.println("Chat 서버와 TCP 연결됨");
			
//			출력을 위한 출력 스트림 생성
			DataOutput out = new DataOutputStream(socket.getOutputStream());					// String으로 만들때 사용
			DataInput in = new DataInputStream(socket.getInputStream());
			
			while(true) {
//				입력을 위한 입력 스트림 생성
//				임시 익명 쓰레드 생성 및 시작
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						String chatMessage;
						try {
							while (true) {
								chatMessage = in.readUTF();
								System.out.println(chatMessage);
								if (chatMessage.equalsIgnoreCase("q")) {
									break;
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				thread.start();
				
				System.out.println("[홍재헌] : ");
				String inputMessage = scanner.nextLine();
				if (inputMessage.equalsIgnoreCase("q")) {
					out.writeUTF("q");														//클라이언트쪽만 나가는 것이 아닌 서버에도 나간다고 보내줘야한다
					break;
				}
			
//				서버에 메세지 전송
				out.writeUTF("[홍재헌] : " + inputMessage);
			}
			socket.close();
			scanner.close();
			
		} catch (IOException e) {
			System.out.println("Chat 서버와 연결할 수 없습니다");
		}
	}

}
