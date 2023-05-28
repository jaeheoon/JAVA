

import ezen.oop.ams.Account;

public class AccountExample {

	public static void main(String[] args) {
//		메모리상에 account 인스턴스 생성
		Account account = new Account();
		
//		account.accountNum = "3456-8503-9430-7659";
		account.setAccountNum("3456-8503-9430-7659");
		
//		account.accountOwner = "홍재헌";
		account.setAccountOwner("홍재헌");
		
//		account.passwd = 1234;
		account.setPasswd(1234);
		
//		account.restMoney = 10000;
		account.setRestMoney(10000);
		
//		개설된 계좌의 기능 사용
		if(account.checkPasswd(1234)){
			System.out.println("비밀번호가 맞습니다.");
			
			System.out.println(account.getAccountNum());
			long money = account.getRestMoney();
			System.out.println("현재 잔액은 : "+money+"원");
			
			long restMoney = account.deposit(100000000L);
			System.out.println("입금 후 잔액은 : " + restMoney + "원");
			
			System.out.println("출금 후 잔액은 : " + account.withdraw(10000L) + "원");
		}
		else {
			System.out.println("비밀번호가 다릅니다.");
		}
		
//		스태틱 변수는 클래스 이름으로 접근 가능하다.
//		Account.bankName = "이젠은행"; - 상수처리하여 변경할 수 없다.
		System.out.println(Account.BANK_NAME);
		
		Account a1 = new Account("홍재헌", 1111, 1000);
		Account a2 = new Account("재헌", 1111, 1000);
		Account a3 = new Account("헌", 1111, 1000);
		System.out.println(a1.getAccountNum());
		System.out.println(a2.getAccountNum());
		System.out.println(a3.getAccountNum());
		
//		스태틱 메소드도 스태틱 변수처럼 인스턴스 생성 없이 클래스이름으로 바로 접근하여 사용할 수 있다.
		System.out.println(Account.getAccountId());
		
	}

}
