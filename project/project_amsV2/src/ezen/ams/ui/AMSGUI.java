package ezen.ams.ui;

public class AMSGUI {

	public static void main(String[] args) {
		AMSFrame amsFrame = new AMSFrame("EZEN-BANK AMS");
		amsFrame.setSize(600, 500);
		amsFrame.addEventListner();
		amsFrame.setResizable(false);			//창 크기 조절 못하게끔 하는 코드
		}

}
