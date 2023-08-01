package ezen.ams.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 파일을 통해 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 김기정
 * @author 강소영
 * @since 1.0
 */
public class FiletAccountRepository  implements AccountRepository {
		
	private List<Account> accounts;
	
	public FiletAccountRepository() {
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
//		데이터 검증이 필요하지만 편의상 생략
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
	

	@Override
	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean removeAccount(String accountNum) {
		for (int i=0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.getAccountNum().equals(accountNum)) {
				accounts.remove(i);
				return true;
			}			
		}
		return false;
	}
}























