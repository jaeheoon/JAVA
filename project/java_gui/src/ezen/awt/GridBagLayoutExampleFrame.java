package ezen.awt;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridBagLayout
 */
public class GridBagLayoutExampleFrame extends Frame {
	
	Button button1, button2, button3, button4;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public GridBagLayoutExampleFrame() {
		this("기본 타이틀");
	}
	
	public GridBagLayoutExampleFrame(String title) {
		button1 = new Button("Button1");
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		button4 = new Button("Button4");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
	}
	
	public void init() {
		// Frame의 LayoutManager를 GridBagLayout으로 설정
		setLayout(gridBagLayout);
		// gridBagConstraints에 배치 정보 설정
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		// GridBagLayout에 GridBagConstraints 설정
		gridBagLayout.setConstraints(button1, gridBagConstraints);
		// Frame에 버튼 추가
		add(button1);
		
		// gridBagConstraints에 배치 정보 설정
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 2;
		// GridBagLayout에 GridBagConstraints 설정
		gridBagLayout.setConstraints(button2, gridBagConstraints);
		// Frame에 버튼 추가
		add(button2);
		
		// gridBagConstraints에 배치 정보 설정
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		// GridBagLayout에 GridBagConstraints 설정
		gridBagLayout.setConstraints(button3, gridBagConstraints);
		// Frame에 버튼 추가
		add(button3);
		
		// gridBagConstraints에 배치 정보 설정
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		// GridBagLayout에 GridBagConstraints 설정
		gridBagLayout.setConstraints(button4, gridBagConstraints);
		// Frame에 버튼 추가
		add(button4);
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
		GridBagLayoutExampleFrame frame = new GridBagLayoutExampleFrame("GridBagLayout");
		frame.init();
		frame.addEventListener();
		frame.setSize(400, 300);
		//frame.pack();
		frame.setVisible(true);
	}
}


