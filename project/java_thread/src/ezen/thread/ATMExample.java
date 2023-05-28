package ezen.thread;
/**
 * 출금기능에서 싱크로나이즈드를 사용한 것 - ATMExample
 * @author 홍재헌
 * 230525 수업
 */
public class ATMExample {

	public static void main(String[] args) {
//		멀티스레드 공유 객체
		ATM atm = new ATM();
		
		new Thread() {
			@Override
			public void run() {
				// 테스트를 위한 무한 출금
				while (true) {
					atm.withdrawMoney("1111-2222", 1111, 10000, "아빠");					
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				while (true) {
					atm.withdrawMoney("1111-2222", 1111, 10000, "아들");					
				}
			}
		}.start();
		
	}

}
