package ezen.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ezen.chat.protocol.MessageType;
/**
 * 채팅 구현 프로그램 서버
 * @author 홍재헌
 * 230531 수업
 */

public class ChatServer {

	private static final int SERVER_PORT = 7777;
	private ServerSocket serverSocket;
	private boolean running;
	private Map<String, ChatHandler> clients;

	/** ChatServer 구동 */
	public void startup() throws IOException {
		serverSocket = new ServerSocket(SERVER_PORT);
		System.out.println("========= [ChatServer(" + SERVER_PORT + ")] Start =========");
		running = true;																									//생성자가 없기때문에 startup이 진행되면 true로 값을 넣어줘서 실행
		clients = new Hashtable<String, ChatHandler>();																	//채팅 클라이언트 정보 동기화로 저장
		try {
			while (running) {
				System.out.println("[ChatServer(" + SERVER_PORT + ")] ChatClient Connect Listenning ..");
				Socket socket = serverSocket.accept();																	//서버 소켓 시작
				System.out.println("[ChatCleint(" + socket.getInetAddress().getHostAddress() + ")] 연결해옴...");		//디버깅 차원
				
				// 데이터 송수신 스레드 생성 및 실행
				ChatHandler chatHandler = new ChatHandler(socket, this);												//소켓 넘겨주는 작업
				
				chatHandler.start();
			}
		} catch (IOException e) {
			System.err.println("[ChatServer(" + SERVER_PORT + ")] 실행 중 아래와 같은 오류가 발생하였습니다.");
			System.err.println("오류 내용 :  " + e.getMessage());
		}
	}

	/** 접속한 클라이언트를 콜렉션에 추가 */
	public void addChatClient(ChatHandler chatHandler) {
		clients.put(chatHandler.getNickName(), chatHandler);								// chatHandler.getName() 일 수도 있음
		System.out.println("[현재 채팅에 참여중인 클라이언트 수] : " + clients.size());
	}

	/** 접속한 클라이언트를 콜렉션에 제거 */
	public void removeChatClient(ChatHandler chatHandler) {
		clients.remove(chatHandler.getNickName());
		System.out.println("[현재 채팅에 참여중인 클라이언트 수] : " + clients.size());
	}
	
	/** 접속한 모든 클라이언트에게 메시지 전송 
	 * @throws IOException */
	public void sendMessageAll(String message) throws IOException {
		Collection<ChatHandler> list = clients.values();
		for (ChatHandler chatHandler : list) {
			chatHandler.sendMessage(message);
		}
	}
	/** 닉네임에 해당하는 ChatHandler 검색 */
	public ChatHandler searchByNickname(String nickName) {
		return clients.get(nickName);
	}
	
	/** 서버에 유저 목록 제공 
	 * @throws IOException */
	public Collection<ChatHandler> getServerList() {
		return clients.values();
	}

	/** ChatServer 종료 */
	public void shutdown() {
		try {
			serverSocket.close();
			System.err.println("[ChatServer(" + SERVER_PORT + ")] 종료됨...");
		} catch (IOException e) {
		}
	}

}
