package ezen.chat.server.handler;

import java.io.IOException;

import ezen.chat.server.ChatHandler;
import ezen.chat.server.ChatServer;

/**
 * 채팅 메시지에 대한 응답 처리
 * @author 김기정
 */
public class ChatMessageHandler implements MessageListener{

	@Override
	public void doResponse(ChatServer chatServer, ChatHandler chatHandler, String clientMessage) throws IOException {
		chatServer.sendMessageAll(clientMessage);	
	}
	

}
