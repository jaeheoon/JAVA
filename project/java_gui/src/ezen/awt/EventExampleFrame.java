package ezen.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 이벤트 처리를 위한 클래스 생성
 * @author 홍재헌
 * 230523 수업
 */

public class EventExampleFrame extends Frame{
	
	Button button1, button2, button3;
	TextField tf;
	Choice choice;
	Checkbox javaCB, cCB, pythonCB;
	
	public EventExampleFrame() {
		this("No-Title");
	}
	
	public EventExampleFrame(String title) {
		super(title);
		button1 = new Button("등록");
		button2 = new Button("목록");
		button3 = new Button("삭제");
		tf = new TextField(20);
		choice = new Choice();
		choice.add("두산 베어스");
		choice.add("LG 트윈스");
		choice.add("삼성 라이온즈");
		choice.add("롯데 자이언츠");
		
		javaCB = new Checkbox("자바", true);		//보여질 이름, true면 체크상태, false면 해제상태(defult 상태는 false)
		cCB = new Checkbox("C언어", false);
		pythonCB = new Checkbox("파이썬");
	}
	
//	컴포넌트 처리
	public void init() {
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(button3);
		add(tf);
		add(choice);
		add(javaCB);
		add(cCB);
		add(pythonCB);
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	public void showList() {
		System.out.println("List 목록 구현하기");
	}
	
	public void removeList() {
		System.out.println("Remove 삭제 구현하기");
	}
	
	public void exit() {
		setVisible(false);
//		os로부터 얻어온 그래픽 처리 리소스 반납
		dispose();
		System.exit(0);
	}
	
	public void showDialog() {
		Dialog dialog = new Dialog(this, true);
		dialog.setSize(300, 200);
		dialog.setVisible(true);
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
				dispose();
			}
		});
	}
	
	public void selectTeam(String team) {
		System.out.println(team + "을 선택했습니다");
	}
	
//	이벤트 처리
	public void eventHandling() {
/*
//		이름있는 지역 내부클래스
		class MouseEventHandler1 extends MouseAdapter {
			
			@Override
			public void mouseClicked(MouseEvent e) {
//						System.out.println("Mouse Clicked");
				showMessage("Mouse Clicked");
//						exit();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setBackground(Color.YELLOW);
			}
		}
*/
		
//		MouseListener lisener = new MouseEventHandler1();
		
//		이벤트 처리(지역 내부클래스)
		class ActionHandler implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					Object eventSource = e.getSource();								//이벤트가 발생했을때 이벤트 소스(어떤 버튼이 눌렸는지)를 확인하는 메소드
					if (eventSource == button2) {
						showList();
					}
					else if (eventSource == button3) {
						removeList();
					}
			}
			
		}
		
		class ItemHandler implements ItemListener{
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {				//선택될때
					Object eventSource = e.getSource();
					if (eventSource == javaCB) {
						EventExampleFrame.this.setBackground(Color.RED);
						System.out.println("JAVA 체크박스 선택");
					}
					else if(eventSource == cCB) {
						EventExampleFrame.this.setBackground(Color.GREEN);
						System.out.println("C언어 체크박스 선택");
					}
					else {
						EventExampleFrame.this.setBackground(Color.BLUE);
						System.out.println("파이썬 체크박스 선택");
						
					}
				}
				else if (e.getStateChange() == ItemEvent.DESELECTED) {			//선택 해제될때
					Object eventSource = e.getSource();
					if (eventSource == javaCB) {
						EventExampleFrame.this.setBackground(Color.WHITE);
						System.out.println("JAVA 체크박스 선택해제");
					}
					else if(eventSource == cCB) {
						EventExampleFrame.this.setBackground(Color.WHITE);
						System.out.println("C언어 체크박스 선택해제");
					}
					else {
						EventExampleFrame.this.setBackground(Color.WHITE);
						System.out.println("파이썬 체크박스 선택해제");
						
					}
				}
			}
		}
		
//		이름없는 지역 내부클래스(익명개체) - 반드시 클래스를 상속받거나, 인터페이스를 구현해야만 한다
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int buttonType = e.getButton();
				if (buttonType == MouseEvent.BUTTON3) {				//마우스 버튼 좌, 우, 휠클릭 선택
					showMessage("Mouse Right Clicked");
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setBackground(Color.YELLOW);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
//				showDialog();
			}
			
		});
		
//		목록버튼(button2) 액션 이벤트 처리
		button2.addActionListener(new ActionHandler());
		
//		삭제버튼(button3) 액션 이벤트 처리
		button3.addActionListener(new ActionHandler());
		
//		아이템 이벤트 처리
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedTeam = null;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedTeam = (String)e.getItem();
				}
				selectTeam(selectedTeam);
			}
		});
		
		javaCB.addItemListener(new ItemHandler());
		cCB.addItemListener(new ItemHandler());
		pythonCB.addItemListener(new ItemHandler());
	}
	
	public static void main(String[] args) {
		EventExampleFrame frame = new EventExampleFrame("이벤트 처리 예제");
		frame.init();
		frame.eventHandling();
		frame.setSize(500, 400);
		frame.setVisible(true);
		
	}
/*
//	멤버 내부클래스 생성
	class MouseEventHandler1 extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
//			System.out.println("Mouse Clicked");
			showMessage("Mouse Clicked");
//			exit();
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			button1.setBackground(Color.BLUE);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			button1.setBackground(Color.YELLOW);
		}
		
	}
*/
	
}
