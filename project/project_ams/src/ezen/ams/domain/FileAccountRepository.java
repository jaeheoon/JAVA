package ezen.ams.domain;

import java.io.File;

public class FileAccountRepository implements AccountRepository {

	File file;
	
	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public Account[] getAccounts() {
		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		return false;
	}

	@Override
	public Account searchAccount(String accountNum) {
		return null;
	}

	@Override
	public Account[] searchAccountByOwner(String accountOwner) {
		return null;
	}

	@Override
	public boolean removeAccout(String accountNum) {
		return false;
	}

}
