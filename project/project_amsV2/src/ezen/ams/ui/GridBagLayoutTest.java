package ezen.ams.ui;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutTest extends Frame{
	GridBagLayout grid;
	GridBagConstraints con;
	
	public GridBagLayoutTest( ){
//		GridBagLayout 생성
		grid = new GridBagLayout();
//		GridBagConstraints 생성
		con = new GridBagConstraints();
//		프레임의 배치 관리자로 GridBagLayout 설정
		setLayout(grid);
/* 		GridBagConstraints의 채우기 스타일 설정
 * 		HORIZONTAL - 남는 공간을 확보했을 경우 양 옆으로 꽉 채운다
 *		VERTICAL - 남는 공간을 확보했을 경우 위아래로 꽉 채운다
 * 		BOTH - 남는 공간을 확보했을 경우 상하좌우 모두 꽉 채운다
 *		NONE - 남는 공간이 있어도 채우지 말고 기본 크기를 유지한다.(기본값) */
		con.fill = GridBagConstraints.NONE;
//		GridBagConstraints에 X축 가중치 설정
		con.weightx = 1.0 ;
		con.weighty = 1.0 ;
	
		Button btn1 = new Button("버튼1");
//		GridBagConstraints에 컴포넌트의 위치 값 설정
		con.gridx=0;
		con.gridy=0;
		con.gridwidth=2;
		con.gridheight=1;
//		GridBagLayout에 GridBagConstraints 설정
		grid.setConstraints(btn1, con);
//		프레임에 컴포넌트를 배치
		add(btn1);
		Button btn2 = new Button("버튼2");
		addCom(btn2, 2, 0, 1, 2);
		Button btn3 = new Button("버튼3");
		addCom(btn3, 0, 1, 1, 1);
		Button btn4 = new Button("버튼4");
		addCom(btn4, 1, 1, 1, 1);
//		프레임 내부의 컴포넌트 크기에 맞추어서 프레임이 자동 조정되도록 설정
		
		pack();
		setVisible(true);
	}
	
	
	
	
	
	
	private void addCom(Component c, int x, int y, int w, int h){
//		컴포넌트의 위치 값 설정
		con.gridx= x;
		con.gridy= y; 
		con.gridwidth=w;
		con.gridheight=h;
//		컴포넌트를 GridBagConstraints에 설정
		grid.setConstraints(c, con);
//		프레임에 컴포넌트 배치
		add(c);
	}

	public static void main(String[] args) {
		new GridBagLayoutTest( );
	}

}
