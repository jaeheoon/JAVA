package ezen.ams.domain;

import java.util.List;

/**
 * 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 명세
 * @author 홍재헌
 *
 */
public interface AccountRepository {
	
//	전체 계좌 목록 수
	public int getCount();
//	전체 계좌 배열(정보) 리턴
	public List<Account> getAccounts();
//	계좌 등록 성공 여부
	public boolean addAccount(Account account);
//	계좌 검색 후 계좌 리턴
	public Account searchAccount(String accountNum);
//	검색된 계좌 배열(정보) 리턴
	public List<Account> searchAccountByOwner(String accountOwner);
//	계좌 삭제 성공 여부
	public boolean removeAccout(String accountNum);	
}
