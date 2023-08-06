package ezen.ams.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ListAccountRepository implements AccountRepository{
	
	private List<Account> accounts;
	
	public ListAccountRepository() {
		this.accounts = new LinkedList<>();
	}
	
	/**
	 * 전체 계좌 목록 수 반환
	 * @return 목록수
	 */
	public int getCount() {
		return accounts.size();
	}

	/**
	 * 
	 * @return 전체계좌 목록
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * 신규계좌 등록
	 * @param account 신규계좌
	 * @return 등록 여부
	 */
	public boolean addAccount(Account account){
		accounts.add(account);
		return true;
	}
	
	/**
	 * 
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
		for (Account account : accounts) {
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	public List<Account> searchAccountByOwner(String accountOwner) {
		List<Account> searchAccounts = new ArrayList<>();
		for (Account account : accounts) {
			if(account.getAccountOwner().equals(accountOwner)) {
				searchAccounts.add(account);
			}
		}
		
		return searchAccounts;
	}
	
	public boolean removeAccount(String accountNum) {
		for (int i = 0; i < accounts.size(); i++) {	
			Account account = accounts.get(i);
			if(account.getAccountNum().equals(accountNum)) {
				accounts.remove(i);
				return true;
			}
		}
		return false;
	}
}


