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
 * @author 김기정
 */
public class GridBagLayoutExampleFrame2 extends Frame {
	Label receiveLabel, attachLabel;
	TextField receiveTF, attachTF;
	Button searchButton;
	TextArea contentsArea;
	Button sendButton, cancleButton;
	Panel buttonPanel;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public GridBagLayoutExampleFrame2() {
		this("기본 타이틀");
	}
	
	public GridBagLayoutExampleFrame2(String title) {
		receiveLabel = new Label("받는사람", Label.CENTER);
		receiveTF = new TextField();
		attachLabel = new Label("첨부파일", Label.CENTER);
		attachTF = new TextField();
		searchButton = new Button("찾 기");
		contentsArea = new TextArea();
		sendButton = new Button("전  송");
		cancleButton = new Button("취  소");
		buttonPanel = new Panel();
	}
	
	public void init() {
		
		buttonPanel.add(sendButton);
		buttonPanel.add(cancleButton);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setLayout(gridBagLayout);
		addComponent(receiveLabel,  0, 0, 1, 1, 0.0);
		addComponent(receiveTF,     1, 0, 2, 1, 1.0);
		addComponent(attachLabel,   0, 1, 1, 1, 0.0);
		addComponent(attachTF,      1, 1, 2, 1, 1.0);
		addComponent(searchButton,  3, 1, 1, 1, 0.1);
		addComponent(contentsArea,  0, 2, 4, 2, 1.0);
		addComponent(buttonPanel,   0, 4, 4, 1, 1.0);
	}
	
	// GridBagLayout을 이용한 컴포넌트 배치
	private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx) {
		
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		gridBagConstraints.weightx = weightx; // 가중치
		gridBagConstraints.weighty = 0.0;
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	private void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	// 이벤트 소스에 이벤트 리스너 연결(등록)
	public  void addEventListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	public static void main(String[] args) {
		GridBagLayoutExampleFrame2 frame = new GridBagLayoutExampleFrame2("GridBagLayout");
		frame.init();
		frame.addEventListener();
		//frame.setSize(400, 300);
		frame.pack();
		frame.setVisible(true);
	}
}


