package ezen.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 * GUI 생성 작업(컨테이너 생성 및 화면 보이기+컴포넌트 생성 및 배치)
 * 연습때 사용하는 것, 보통 이렇게 사용 안하고 클래스를 만들어서 사용함
 * @author 홍재헌
 *230523 수업
 */
public class AWTExample {

	public static void main(String[] args) {
//		Contanier 생성 및 화면 보이기
//	Frame을 사용할때 필요, 잘 사용 안한다 보통 panel을 사용하여 영역을 지정해서 사용함
		Frame frame = new Frame("Frame 타이틀입니다");					
		frame.setSize(800, 600);										//컨테이너 사이즈 설정
		frame.setVisible(true);											//보이게끔 하는 것 기본은 false, 보이게 하려면 true
//		frame.setLayout(new FlowLayout());								//Layout을 변경하는 메소드, 기본은 BorderLayout을 많이 씀

//		패널의 디폴트 레이아웃 매니저는 FlowLayout
//		Panel panel = new Panel();
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));		//flowlayout은 기본적으로 가운데 정렬, 다른 정렬할땐 상수 이용
		panel.add(new Label("이름: "));
		panel.add(new TextField(20));									//textField(글자를 넣고싶은 수)
		
		
//	Frame을 사용할때 필요, 잘 사용 안한다 보통 panel을 사용하여 영역을 지정해서 사용함
//		비주얼 컴포넌트 생성 및 컨테이너에 부착
		Button button = new Button("Button");
//		클래스 자동형변환 이용하여 컴포넌트 부착
		frame.add(button, BorderLayout.CENTER);												//컨테이너에 버튼 추가(가운데 배치)
		frame.add(new Label("라벨1"), BorderLayout.EAST);									//컨테이너에 라벨 추가(동쪽 배치)
		frame.add(new Label("라벨2"), BorderLayout.WEST);									//컨테이너에 라벨 추가(서쪽 배치)
		frame.add(new Label("라벨3"), BorderLayout.SOUTH);									//컨테이너에 라벨 추가(남쪽 배치)
		frame.add(panel, BorderLayout.NORTH);												//컨테이너에 라벨 추가(북쪽 배치)
		
	}

}
