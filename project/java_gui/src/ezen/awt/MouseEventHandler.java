package ezen.awt;
/**
 * 이벤트 처리를 위한 클래스
 */
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
	EventExampleFrame frame;
	
	public MouseEventHandler(EventExampleFrame frame) {
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		frame.button1.setBackground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		frame.button1.setBackground(Color.YELLOW);
	}

}
