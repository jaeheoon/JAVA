package ezen.ams.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 메모리(콜렉션.List)를 통해 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 홍재헌
 * 230519 수업
 * 인터페이스 구현은 기존에 있던 인터페이스를 수정해야되기 때문에 수업에서 삭제
 * 기존에 있던 함수를 List를 이용해 수정함, 간결해지고 직관성이 있다
 */
public class ListAccountRepository implements AccountRepository{
	
	private List<Account> accounts;
	
//	ArrayList<>();를 쓰면 크기가 필요할 수도 있지만 LinkedList는 필요없다
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
//		데이터 검증이 필요하지만 편의상 생략
//		accounts[count++] = account;
		accounts.add(account);
		return true;
	}
	
	/**
	 * 
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
//		for (int i = 0; i < count; i++) {
//			String number = accounts[i].getAccountNum();
//			// 동일 계좌번호 여부 확인
//			if(number.equals(accountNum)) {
//				return accounts[i];
//			}
//		}
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
//	public Account[] searchAccountByOwner(String accountOwner) {
//		Account[] searchList = null;
//		
//		int searchCount = getCountByOwner(accountOwner);
//		if(searchCount == 0) {
//			return null;
//		}
//		
//		searchList = new Account[searchCount];
//		int listIndex = 0;
//		for (int i = 0; i < count; i++) {
//			if(accounts[i].getAccountOwner().equals(accountOwner)) {
//				searchList[listIndex++] = accounts[i];
//			}
//		}
		List<Account> searchAccounts = new ArrayList<>();					//찾은 배열을 담아놓기 위한 ArrayList
		for (Account account : accounts) {
			if(account.getAccountOwner().equals(accountOwner)) {
				searchAccounts.add(account);
			}
		}
		
		return searchAccounts;
	}
	
//	private 헬퍼메소드
//	private int getCountByOwner(String accountOwner) {
//		int searchCount = 0;
//		for (int i = 0; i < count; i++) {
//			String name = accounts[i].getAccountOwner();
//			// 동일 예금주 여부 확인
//			if(name.equals(accountOwner)) {
//				searchCount++;
//			}
//		}
//		return searchCount;
//	}
	
	
	public boolean removeAccout(String accountNum) {
//	public boolean removeAccout(String accountNum) {
//		for (int i = 0; i < count; i++) {
//			String number = accounts[i].getAccountNum();
//			// 동일 계좌번호 여부 확인
//			if(number.equals(accountNum)) {
//				for(int j=i; j < count-1; j++){
//					accounts[j] = accounts[j+1];					
//				}
//				count--;
//				return true;
//			}
//		}
		for (int i = 0; i < accounts.size(); i++) {					//확장 for문은 get에 해당하는 숫자를 가져올 수 없기 때문에 일반 for문을 사용함, 각 코드에 맞게끔 확장/일반 for문 사용할줄 알아야함
			Account account = accounts.get(i);
			if(account.getAccountNum().equals(accountNum)) {
				accounts.remove(i);
				return true;
			}
		}
		return false;
	}
	
}

	
























