package ezen.ams.app;

import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;
import ezen.ams.domain.ListAccountRepository;
import ezen.ams.domain.MinusAccount;
import ezen.ams.exception.NotBalanceException;
import ezen.ams.ui.AMSFrame;

public class AMSui {
	public static AccountRepository repository = new ListAccountRepository();
	
	public static void main(String[] args) throws NotBalanceException {
		AMSFrame amsFrame = new AMSFrame("EZEN-BANK AMS");
		amsFrame.setSize(600, 500);
		amsFrame.addEventListner();
		amsFrame.setResizable(true);			//창 크기 조절 못하게끔 하는 코드
		
//		임시 더미데이터 입력
		repository.addAccount(new Account("김기정", 1111, 10000000));
		repository.addAccount(new Account("홍재헌", 1111, 1000000));
		repository.addAccount(new Account("김재헌", 1111, 1000000));
		repository.addAccount(new Account("최재헌", 1111, 1000000));
		repository.addAccount(new Account("양재헌", 1111, 1000000));
		repository.addAccount(new MinusAccount("양재헌", 1111, 1000000, 10000000));
		repository.addAccount(new MinusAccount("양재헌", 1111, 1000000, 10000000));
		repository.addAccount(new Account("양재헌", 1111, 1000000));
		
		
	}
}








