package ezen.ams.app;

import ezen.ams.domain.Account;
import ezen.ams.exception.NotBalanceException;
/**
 * 예외처리 사용 예제
 * @author 홍재헌
 *
 */
public class AMSExample {

	public static void main(String[] args) {
		Account account = null;
		try {
			account = new Account("홍재헌", 1000, 1000);
		} catch (NotBalanceException e) {
			e.printStackTrace();
		}
		try {
			long restMoney = account.deposit(1000);
			System.out.println("정상처리 : "+ account.getRestMoney());
			
			restMoney = account.withdraw(20);
			System.out.println("출금 후 잔액: "+restMoney);
		} catch (NotBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}