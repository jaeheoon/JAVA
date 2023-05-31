package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import ezen.chat.protocol.MessageType;
import ezen.chat.protocol.Validator;
/**
 * 채팅 프로그램 틀
 * @author 홍재헌 
 * 230531 수업
 */
public class ChatFrame extends Frame {
	
	Label nicknameL;
	TextField nicknameTF, inputTF;
	Button loginB, sendB;
	TextArea messageTA, nicknameList;
	
	Panel northP, southP;
	
	ChatClient chatClient;
	String nickName;
	
	public ChatFrame() {
		this("No-Title");
	}
	
	public ChatFrame(String title) {
		super(title);
		// 복합연관
		nicknameL = new Label("닉네임");
		nicknameTF = new TextField();
		inputTF = new TextField();
		loginB = new Button("연 결");
//		loginB.setBackground(new Color(255, 255, 255));
//		loginB.setBackground(Color.BLUE);
//		loginB.setForeground(Color.WHITE);
//		loginB.setFont(new Font("궁서", Font.BOLD, 35));
		sendB = new Button("보내기");
		messageTA = new TextArea();
		nicknameList = new TextArea(10, 10);
		northP = new Panel(new BorderLayout(5, 5));
		southP = new Panel(new BorderLayout(5, 5));
	}
	
//	컴포넌트 배치
	public void init() {
//		Frame의 디폴트레이아웃매니저 : BorderLayout
		northP.add(nicknameL, BorderLayout.WEST);
		northP.add(nicknameTF, BorderLayout.CENTER);
		northP.add(loginB, BorderLayout.EAST);
		
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(nicknameList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
	}
	
	public void connect() {
		nickName = nicknameTF.getText();
		if (!Validator.hasText(nickName)) {
			JOptionPane.showMessageDialog(this, "닉네임을 입력하세요"); 						//입력이 안됐을 때 닉네임 입력하라는 창 생성
			return;
		} else {
			chatClient = new ChatClient(this);
			try {
				chatClient.connectServer();
				setEnable(false);
				chatClient.sendMessage(MessageType.CONNECT+"|"+ nickName);									//닉네임 보내고
				chatClient.receiveMessage();													//다른 사람이 보낸 메세지 받기
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "ChatServer를 연결할 수 없습니다"); 		//연결이 되지 않았을 때(네트워크, 서버를 찾을 수 없을때 등등)나오는 창
			}
		}
	}
	
//	닉네임창 입력되면 비활성화, 안입력했으면 활성화
	private void setEnable(boolean enable) {
		nicknameTF.setEnabled(enable);
	}
	
//	메세지를 클라이언트에서 받아서 TextArea에 저장해주는 기능
	public void appendMessage(String message) {
		messageTA.append(message + "\n");
	}
	
//	텍스트를 서버로 보내주는 역할
	private void sendChatMessage() {
		String message = inputTF.getText();
		if (Validator.hasText(message)) {
			try {
//				chatClient.sendMessage("["+nickName+"]: " + message);
				chatClient.sendMessage(MessageType.CHAT_MESSAGE+"|"+ nickName +"|"+ message);
				inputTF.setText("");
			} catch (IOException e) {
			}
		} 
	}
	
	private void disConnect() {
		try {
			chatClient.sendMessage(MessageType.DIS_CONNECT + "|"+nickName);
		} catch (IOException e) {
		}
		exit();
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void addEventListener() {
//		종료처리
		addWindowListener(new WindowAdapter() {					//윈도우 관련 이벤트 생성(익명개체로 생성함)
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
			}
		});
		
//		연결처리
		loginB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
//		닉네임 엔터 눌러도 연결되는 것
		nicknameTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		inputTF.addActionListener(new ActionListener() {		//엔터 눌렀을 때 서버에 메세지 보내기
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChatMessage();
			}
		});
		
		sendB.addActionListener(new ActionListener() {			//보내기 버튼 눌렀을 때 서버에 메세지 보내기
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChatMessage();
			}
		});
	}
	
	

}






