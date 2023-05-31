package ezen.chat.server;

import java.io.IOException;

/**
 * 서버 구동 클래스
 * @author 홍재헌
 * 230531 수업
 */
public class EzenTalkServer {

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		try {
			chatServer.startup();
		} catch (IOException e) {
			System.out.println("ChatServer 실행 중 예외 발생");
			System.out.println("-"+e.getMessage());
		}
	}

}
