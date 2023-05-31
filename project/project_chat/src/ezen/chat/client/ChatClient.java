package ezen.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ezen.chat.protocol.MessageType;

/**
 * TCP/IP 기반의 ChatClient, Server와 통신하기 위한 클래스
 * @author 홍재헌
 * 230531 수업
 */
public class ChatClient {
	
	private static final String SERVER_IP = "localhost";
//	private static final String SERVER_IP = "192.168.20.35";
	private static final int SERVER_PORT = 7777;
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ChatFrame chatFrame;
	
	public ChatClient(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
	
	// 서버 연결
	public void connectServer() throws IOException {
		socket = new Socket(SERVER_IP, SERVER_PORT);
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	// 서버 연결 종료
	public void disConnectServer() throws IOException {
		if(socket != null) {
			socket.close();
		}
	}
	
	// 메시지 전송
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);													//서버에게 보내는 역할
	}
	
	// 메시지 수신
	public void receiveMessage() {
		// 서버로부터 전송되는 메시지를 실시간 수신하기 위해 스레드 생성 및 시작
		Thread thread = new Thread() {
			public void run() {
				try {
					while (true) {
						String serverMessage = in.readUTF();					//서버에서 받아서 읽어오는 역할
						
						String[] tokens = serverMessage.split("\\|");
						MessageType messageType = MessageType.valueOf(tokens[0]);											//메세지 종류 구분을 위해 split 사용
						String senderNickName = tokens[1];										//보내는 사람 or 받는 사람 닉네임 일 수도 있기 때문에 받아놓는다
						
//						클라이언트 전송 메세지 종류에 따른 처리
						switch (messageType) {
						case CONNECT:
							chatFrame.appendMessage("@@@@@@ "+senderNickName+"님이 연결하였습니다 @@@@@@"); 
							break;
						case CHAT_MESSAGE: 
							String chatMessage = tokens[2];											//메세지 내용
							chatFrame.appendMessage("["+senderNickName+"]: "+ chatMessage); 
							break;
						case DIS_CONNECT:  
							chatFrame.appendMessage("###### "+ senderNickName +"님이 연결 해제하였습니다 ######"); 
							break;
						}
//						chatFrame.appendMessage(serverMessage);					//서버에서 받아온 메세지를 TextArea에 붙여주는 역할
					}
				} catch (IOException e) {
					
				} 
				finally {
					
				}
			}
		};
		thread.start();
	}
}








