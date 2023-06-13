package ezen.ams.domain;

import ezen.ams.exception.NotBalanceException;

/**
 * 상속 관련 클래스 생성
 * @author 홍재헌
 *
 */
public class MinusAccount extends Account{
//	부모클래스에 없는필드나 메소드를 추가(확장)
	private long borrowMoney;
	
	public MinusAccount() {}		//이렇게만 추가해도
//	컴파일 시 부모클래스의 디폴트 생성자를 호출하는 super(); 자동 추가
/*	public MinusAccount() {		
	 	
		super();					이렇게 추가되는 격이다
	}	
*/
	public MinusAccount(String accountOwner, int passwd, long restMoney, long borrowMoney) throws NotBalanceException {
		super(accountOwner, passwd, restMoney);				//부모클래스의 생성자를 호출할때 사용하는 함수
		this.borrowMoney = borrowMoney;
	}
	
//	메소드 추가
	public long getBorrowMoney() {
		return borrowMoney;
	}
	
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	public long Mideposit(long money) {
		return borrowMoney += money;
	}
	@Override
	public String toString() {
		return super.toString()+"         "+borrowMoney;
	}
	
	
}
