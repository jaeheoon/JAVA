package ezen.chat.client;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

import ezen.chat.protocol.MessageBuilder;
import ezen.chat.protocol.MessageType;

public class ChatFrame extends Frame {
	
	Label nicknameL;
	TextField nicknameTF, inputTF;
	Button loginB, sendB;
	TextArea messageTA, nicknameList;
	
	Choice userChoice;
	
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
		loginB = new Button("연  결");
//		loginB.setBackground(new Color(255, 255, 255));
//		loginB.setBackground(Color.BLUE);
//		loginB.setForeground(Color.WHITE);
//		loginB.setFont(new Font("궁서", Font.BOLD, 35));
		sendB = new Button("보내기");
		messageTA = new TextArea();
		nicknameList = new TextArea(10, 10);
		
		userChoice = new Choice();
		userChoice.addItem("전체에게");
		
		northP = new Panel(new BorderLayout(5, 5));
		southP = new Panel(new BorderLayout(5, 5));
	}
	
//	컴포넌트 배치
	public void init() {
//		Frame의 디폴트레이아웃매니저 : BorderLayout
		northP.add(nicknameL, BorderLayout.WEST);
		northP.add(nicknameTF, BorderLayout.CENTER);
		northP.add(loginB, BorderLayout.EAST);
		
		southP.add(userChoice, BorderLayout.WEST);
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(nicknameList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
	}
	
	private void connect() {
		nickName = nicknameTF.getText();
		if(!Validator.hasText(nickName)) {
			JOptionPane.showMessageDialog(this, "닉네임을 입력하세요");
			return;
		}
		chatClient = new ChatClient(this);
		try {
			chatClient.connectServer();
			setEnable(false);
//			chatClient.sendMessage("CONNECT|" + nickName);
//			chatClient.sendMessage(MessageType.CONNECT+"|" + nickName);
			chatClient.sendMessage(MessageBuilder.build(MessageType.CONNECT, nickName));
			chatClient.receiveMessage();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "ChatServer를 연결할 수 없습니다..");
		}
	}
	
	private void setEnable(boolean enable) {
		nicknameTF.setEnabled(enable);
		loginB.setEnabled(enable);
	}
	
	public void appendMessage(String message) {
		messageTA.append(message + "\n");
	}
	
	public void clearMessage() {
		messageTA.setText("");
	}
	
	public void appendNicknameList(String nickNameList) {
		nicknameList.append(nickNameList );
	}
	
	public void clearNicknameList() {
		nicknameList.setText("");
	}
	
	public void appendNicknameChoice(String nickNameList) {
		userChoice.removeAll();
		userChoice.add("전체에게");
		String[] nickNames = nickNameList.split("\n");
		for (String nickName : nickNames) {
			userChoice.add(nickName);
		}
	}
	
	private void sendChatMessage() {
		String message = inputTF.getText();
		if(Validator.hasText(message)) {
			try {
//				chatClient.sendMessage("["+nickName+"] : " + message);
//				chatClient.sendMessage("CHAT_MESSAGE|"+nickName+"|" + message);
//				chatClient.sendMessage(MessageType.CHAT_MESSAGE +"|"+nickName+"|" + message);
				
//				chatClient.sendMessage(MessageBuilder.build(MessageType.CHAT_MESSAGE, nickName, message));
				
				// DM 전송에 따른 분기
				if(userChoice.getSelectedIndex() != 0) {
					String receiveNickname = userChoice.getSelectedItem();
					chatClient.sendMessage(MessageBuilder.build(MessageType.DM_MESSAGE, nickName,  receiveNickname, message));
				}else {
					chatClient.sendMessage(MessageBuilder.build(MessageType.CHAT_MESSAGE, nickName, message));
				}
				
				inputTF.setText("");
				
			} catch (IOException e) {}
		}
	}
	
	private void disConnect() {
		try {
//			chatClient.sendMessage("DIS_CONNECT|"+nickName);
//			chatClient.sendMessage(MessageType.DIS_CONNECT+"|"+nickName);
			chatClient.sendMessage(MessageBuilder.build(MessageType.DIS_CONNECT, nickName));
			exit();
		} catch (IOException e) {
			
		}
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void addEventListener() {
		// 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();
			}
		});
		
		// 연결 처리
		loginB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		nicknameTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		// 전송 처리
		inputTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChatMessage();
			}
		});
		
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChatMessage();
			}
		});
		
	}
	
	
	

}






