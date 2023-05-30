package ezen.io.diary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Diary extends Frame{
	
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem newMI, openMI, saveMI, exitMI;
	Label todayL;
	TextArea contentsTA;
	
	private static int contentLength = 0;
	
	public Diary() {
		this("제목없음");
	}
	
	public Diary(String title) {
		super(title);
		menuBar = new MenuBar();
		fileMenu = new Menu("파일");
		newMI = new MenuItem("새로 만들기");
		openMI = new MenuItem("열기");
		saveMI = new MenuItem("저장");
		exitMI = new MenuItem("끝내기");
		contentsTA = new TextArea();
		
		todayL = new Label("", Label.RIGHT);
	}
	
	public void init() {
		setMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_W));
		
		add(todayL, BorderLayout.NORTH);
		add(contentsTA, BorderLayout.CENTER);
	}
	
	private void setToday() {
		todayL.setBackground(Color.blue);
		todayL.setForeground(Color.white);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					String format = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
					todayL.setText(format);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	} 
//	지우는 기능
	private void setNew() {
		contentsTA.setText("");		
	}
	
//	파일 오픈하기
	private void openFile() throws IOException{
//		내가 작성한 코드
//		String diary;
//		FileDialog fd = new FileDialog(this, "일기 저장", FileDialog.LOAD);				//FileDialog(프레임 생성해야하는데 여기선 이미 있기때문에 this로 생성)
//		fd.setVisible(true);
//		String openFile = fd.getFile();
//		
//		File file = new File(openFile);											//파일이 있는지 없는지 유효성 검사
//		if (!file.exists()) {
//			throw new IOException("xxx열고자 하는 파일을 찾을 수 없습니다.");		// 검사하고 이름 지정하여 반환하는 쪽에 예외처리 후 메세지 출력
//		}
//		DataInputStream in = new DataInputStream(new FileInputStream(openFile));	
//		diary = in.readUTF();
//		while(diary.length() != 0) {
//			contentsTA.append(diary);
//		}
//		in.close();
		
//		강사님이 작성한 코드
		
		String openDirectoryName = "files";
		String contents = null;
		
		File openDirectory = new File(openDirectoryName);
		if(!openDirectory.exists()) {
			openDirectory.mkdir();
		}
		
		FileDialog fd = new FileDialog(this, "일기 열기", FileDialog.LOAD);
		fd.setDirectory(openDirectory.getAbsolutePath());
		fd.setVisible(true);
		String openFile = fd.getFile();
		if(openFile != null) {
			File file = new File(openFile);
			DataInputStream in = new DataInputStream(new FileInputStream(openDirectory.getAbsolutePath( ) + "/" + openFile));
//			String contents= in.readUTF();
			
			byte[] bytes = new byte[1024];												//배열단위로 읽어올때 이런식으로 사용
			int count = in.read(bytes);													// 이것이 더 효율적이다
			contentsTA.setText(new String(bytes, 0, count));
			
//			String contents = "";
//			for (int i=0; i<contentLength; i++) {
//				contents += in.readChar();												//두바이트씩 읽어오고 contents에 저장해놓는다
//			}
//			contentsTA.setText(contents);
			setTitle(openFile);
		}
	}
	
//	파일 저장하기
	private void saveFile() throws IOException{
//		내가 작성한 것
//		String text = contentsTA.getText();
//		String saveFileName = String.format("%1$tF_%1$tA.dat", Calendar.getInstance());		//날짜 저장, 제목에 넣을 것
//		String saveTitle = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());	//날짜 저장, 글 내용 첫번째 헤드에 넣을 것 
//		
//		File saveDirectory = new File(saveFileName);
//		if(!saveDirectory.exists()) {
//			saveDirectory.mkdir();
//		}
//		// 과제 : datainputStream, dataoutputStream으로 하기, 저장 위치는 현재 프로젝트 안에 Files라는 폴더 만들어서 저장
//		// 글 타이틀에 오늘 날짜 : 2023-05-26 금요일
//		// 두번째줄부터 일기장 내용 들어가게끔
//		
//		if (text.length() == 0) {
//			JOptionPane.showMessageDialog(this, "저장할 내용이 없습니다", "저장 오류", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		
//		FileDialog fd = new FileDialog(this, "일기 저장", FileDialog.SAVE);				//FileDialog(프레임 생성해야하는데 여기선 이미 있기때문에 this로 생성)
//		fd.setFile(saveFileName);
//		fd.setDirectory(saveDirectory.getAbsolutePath());
//		fd.setVisible(true);
//		
//		String saveFile = fd.getFile();
//		
//		if(saveFile != null) {
//			DataOutputStream out = new DataOutputStream(new FileOutputStream(saveDirectory.getAbsolutePath() + "/" +saveFile));
//			out.writeUTF(saveTitle+"\n");
//			out.writeUTF("-----------------------------\n");
//			out.writeUTF(text+"\n");
//			out.close();
//			setTitle(saveFile);
//			System.out.println("ok정보 파일 출력 완료");
//		}
		
//		강사님이 작업한 것
		String saveDirectoryName = "files";
		String saveFileName = String.format("%1$tF.dif", Calendar.getInstance());
		String saveTitle = String.format("%1$tF %1$tT (%1$tA)", Calendar.getInstance());
		String contents = contentsTA.getText();
		
		if(contents.length() == 0) {
			JOptionPane.showMessageDialog(this, "저장할 내용이 없습니다..", "저장 오류", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		File saveDirectory = new File(saveDirectoryName);
		if(!saveDirectory.exists()) {
			saveDirectory.mkdir();
		}
		
		FileDialog fd = new FileDialog(this, "일기 저장", FileDialog.SAVE);
		fd.setFile(saveFileName);
		fd.setDirectory(saveDirectory.getAbsolutePath());
		fd.setVisible(true);
		
		String saveFile = fd.getFile();
		
		if(saveFile != null) {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(saveDirectory.getAbsolutePath() + "/" +saveFile));
//			out.writeUTF(saveTitle);
			
//			out.writeBytes(saveTitle);								//이것이 더 효율적으로 작성할 수 있다
//			out.writeBytes("-----------------------------");		
//			out.writeBytes(contents.getBytes());					//바이트를 배열로 바꿔서 저장해주는 것
			out.write(contents.getBytes());							//출력할때 숫자로 저장됨
			
//			contentLength = contents.length();					
//			for (int i=0; i<contents.length(); i++) {				//종료되면 contentLength가 0으로 되기때문에 배열로읽는다
//				out.writeChar(contents.charAt(i));					//writeChar : 두바이트씩 있는 그대로 저장
//			}
//			
			out.close();
			setTitle(saveFile);
		}
		
		
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void addEventListener() {
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == newMI) {
					setNew();
				}else if(eventSource == openMI) {
					try {
						openFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(eventSource == saveMI) {
					try {
						saveFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(eventSource == exitMI) {
					exit();
				}
			}
		}
		ActionListener actionListener = new ActionHandler();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				setToday();
			}
		});
		
		newMI.addActionListener(actionListener);
		openMI.addActionListener(actionListener);
		saveMI.addActionListener(actionListener);
		exitMI.addActionListener(actionListener);
	}
	
	public static void main(String[] args) {
		Diary diary = new Diary();
		diary.init();
		diary.setSize(700, 500);
		diary.addEventListener();
		diary.setVisible(true);
	}
}
