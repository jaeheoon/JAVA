package ezen.awt;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * GridLayout
 */
public class GridLayoutExampleFrame extends Frame {
	
//	Button button1, button2, button3, button4;
	List<Button> buttons;
	GridLayout gridLayout;
	
	public GridLayoutExampleFrame() {
		this("기본 타이틀");
	}
	
	public GridLayoutExampleFrame(String title) {
//		gridLayout = new GridLayout(2, 2);
		
//		button1 = new Button("Button1");
//		button2 = new Button("Button2");
//		button3 = new Button("Button3");
//		button4 = new Button("Button4");
		
		gridLayout = new GridLayout(10, 10);
		
		buttons = new ArrayList<Button>();
		for (int i = 1; i <= 100; i++) {
			buttons.add(new Button(String.valueOf(i)));
		}
	}
	
	public void init() {
		setLayout(gridLayout);
		for (Button button : buttons) {
			add(button);
		}
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	
	// 이벤트 처리
	public  void addEventListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	public static void main(String[] args) {
		GridLayoutExampleFrame frame = new GridLayoutExampleFrame("GridBagLayout");
		frame.init();
		frame.addEventListener();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}


