package ezen.thread;
/**
 * 싱글 쓰레드에서 쓰는 예제
 * 싱크로나이즈를 사용하지 않고 노티파이를 사용하면 오류가 나기 때문에
 * 단독적으로 사용할때는 사용 코드에서 wait를 걸어준다
 * @author 홍재헌
 *
 */
public class ATMExample2 {

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		new Thread() {
			@Override
			public void run() {
				synchronized (atm) {
					while (true) {
						atm.notify();
						atm.withdrawMoney("1111-2222", 1111, 10000, "아빠");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				synchronized (atm) {
					while (true) {
						atm.notify();
						atm.withdrawMoney("1111-2222", 1111, 10000, "아들");
						try {
							atm.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
	}

}
