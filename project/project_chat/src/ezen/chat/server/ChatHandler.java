package ezen.chat.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ezen.chat.protocol.MessageType;
/**
 * 채팅 서버 틀
 * @author 홍재헌
 * 230531 수업
 */
public class ChatHandler extends Thread {
	
	private Socket socket;
	private DataInput in;
	private DataOutput out;
	private ChatServer chatServer;
	private String nickName;
	private boolean running;
	
	public ChatHandler(Socket socket, ChatServer chatServer) throws IOException {
		this.socket = socket;
		this.chatServer = chatServer;												//chatserver와 서로 참조할 수 있게끔 넣어놓는다
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		running = true;
		
		String clientMessage = in.readUTF();										//현재는 메세지종류|닉네임|메세지 로 들어오기 때문에 토큰링 작업이 필요함
		String[] tokens = clientMessage.split("\\|");								//split - 정규표현식을 지원하고 매개변수에 의해 잘려진 것이 배열로 들어온다
		nickName = tokens[1];														//split으로 잘려진 것(0, 1, 2) 중에 1번 = 닉네임
		
		chatServer.addChatClient(this);
		start();
//		chatServer.sendMessageAll(nickName+">>>>>>>연결하였습니다");
		chatServer.sendMessageAll(clientMessage);			//CONNECT|방그리 - 접속하면 이런식으로 날라온다
		
	}
	
	public ChatServer getChatServer() {
		return chatServer;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public DataInput getIn() {
		return in;
	}
	
	public DataOutput getOut() {
		return out;
	}

	public void process() throws IOException {
		while(running) {
			String clientMessage = in.readUTF();
			System.out.println("[디버깅: "+nickName+"] : " + clientMessage);
			
			String[] tokens = clientMessage.split("\\|");
			MessageType messageType = MessageType.valueOf(tokens[0]);											//메세지 종류 구분을 위해 split 사용
			String senderNickName = tokens[1];										//보내는 사람 or 받는 사람 닉네임 일 수도 있기 때문에 받아놓는다(귓속말 보낼때 사용)
//			클라이언트 전송 메세지 종류에 따른 처리
			switch (messageType) {
			case CHAT_MESSAGE: 
				chatServer.sendMessageAll(clientMessage); break;
			case DIS_CONNECT:  
				chatServer.removeChatClient(this);									//닉네임을 그냥 뺀 메소드
				chatServer.sendMessageAll(clientMessage); 
				running = false;
				break;
			}
		}
		close();
	}
	
	// 자기 자신에게 메시지 출력
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);		
	} 
	
	public void close() {
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	
	@Override
	public void run() {
		try {
			process();
		} catch (IOException e) {
			System.err.println("에코 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
