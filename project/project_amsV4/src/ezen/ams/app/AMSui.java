package ezen.ams.app;

import ezen.ams.exception.NotBalanceException;
import ezen.ams.ui.AMSFrame;

public class AMSui {
	
	public static void main(String[] args) throws NotBalanceException {
		AMSFrame amsFrame = new AMSFrame("EZEN-BANK AMS");
		amsFrame.setSize(600, 500);
		amsFrame.setResizable(true);			//창 크기 조절 못하게끔 하는 코드
	}
}








