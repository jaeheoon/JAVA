package ezen.chat.client;
/**
 * 채팅 프로그램을 만들기 위해 프레임 클래스 생성
 * @author 홍재헌
 * 230523 수업
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ChatFrame extends Frame{
	Label nicknameL;
	TextField nicknameTF, inputTF;
	Button loginB, sendB;
	TextArea messageTA, userList;
	
	Panel nothP, southP;
	
	public ChatFrame() {
		this("No-Title");
	}
	
	public ChatFrame(String title) {
		super(title);
//		복합연관 생성
		nicknameL = new Label("별 명");
		nicknameTF = new TextField();
		inputTF = new TextField();
		loginB = new Button("로그인");
//		loginB.setBackground(new Color(0, 0, 255));
//		loginB.setBackground(Color.BLUE);
//		loginB.setForeground(Color.WHITE);
//		loginB.setFont(new Font("궁서", Font.BOLD, 14));
		sendB = new Button("전 송");
		messageTA = new TextArea();
		userList = new TextArea(10, 15);
		nothP = new Panel(new BorderLayout(5, 5));
		southP = new Panel(new BorderLayout(5, 5));
	}
	
//	배치 기능 추가
	public void init() {
//		Frame의 디폴트 레이아웃 매니저 : Border Layout
		nothP.add(nicknameL, BorderLayout.WEST);
		nothP.add(nicknameTF, BorderLayout.CENTER);
		nothP.add(loginB, BorderLayout.EAST);
		
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(nothP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
	}
}
