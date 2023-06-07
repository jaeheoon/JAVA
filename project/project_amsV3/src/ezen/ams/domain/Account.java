package ezen.ams.domain;

import ezen.ams.exception.NotBalanceException;

/**
 * 은행계좌 추상화
 */
public class Account {
	private String accountNum, accountOwner;
	private int passwd;
	private long restMoney;
	
	public final static String BANK_NAME = "이젠은행";				//사용할 곳에서 초기화도 가능
	private static int accountId;
	
	static {
		accountId = 1000;
	}
	
	public Account() {	}
	
	public Account(String accountOwner, int passwd, long restMoney) throws NotBalanceException {
		if(passwd>99999999) {
			throw new NotBalanceException("비밀번호는 9자리를 초과할 수 없습니다.");
		}
		else if(passwd<1000) {
			throw new NotBalanceException("비밀번호는 4자리 이상이어야합니다.");
		}
		else if(restMoney%1000 > 0) {
			throw new NotBalanceException("초기 입금 금액은 1000원 이상이어야합니다.");
		}
		else if(accountOwner.length() <= 1) {
			throw new NotBalanceException("이름은 두자리 이상, 6자리 이하여야합니다.");
		}
		else if(accountOwner.length() > 6) {
			throw new NotBalanceException("이름은 두자리 이상, 6자리 이하여야합니다.");
		}
		this.accountNum = (accountId++) + "";
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getAccountOwner() {
		return accountOwner;
	}
	
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	
	public int getPasswd() {
		return passwd;
	}
	
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}


//	돈 입금하기 메소드
	public long deposit(long money) throws NotBalanceException{
		if(money <= 0) {
			throw new NotBalanceException("입금 금액은 0보다 작거나 같을 수 없습니다");
		}
		else if(money >= 100000000) {
			throw new NotBalanceException("1억 이상은 입금할 수 없습니다");
		}
		else if(money%100 > 0) {
			throw new NotBalanceException("100원 단위 이상만 입금할 수 있습니다");
		}
		return restMoney += money;
	}
	

//	돈 출금하기 메소드
	public long withdraw(long money) throws NotBalanceException{
		if(money <= 0) {
			throw new NotBalanceException("출금 금액은 0보다 작거나 같을 수 없습니다");
		}
		else if(money >= 100000000) {
			throw new NotBalanceException("1억 이상은 출금할 수 없습니다");
		}
		else if(money > restMoney) {
			throw new NotBalanceException("잔액이 부족합니다");
		}
		else if(money%1000 > 0) {
			throw new NotBalanceException("1000원 단위로만 출금할 수 있습니다");
		}
//		데이터검증 및 예외처리
		return restMoney -= money;
	}
	
//	잔액 조회하는 메소드
	public long getRestMoney() {
		return restMoney;
	}
	
//	비밀번호 틀리는지 맞는지 알아보는 메소드
	public boolean checkPasswd(int pwd) {
		return passwd == pwd;
	}
	
//	모든 정보 출력하는 코드
	public void printInfo() {
		System.out.println(accountNum+"       "+accountOwner+"       ******       "+ getRestMoney());
	}
	
	@Override
	public String toString() {
	return accountNum+"      "+accountOwner+"      ******      "+ restMoney;
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
	
	//	스태틱(클래스) 메소드
	public static int getAccountId() {
		return accountId;
	}

	
	
	
}
