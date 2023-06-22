package ezen.ams.domain;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import ezen.ams.exception.NotBalanceException;

public class FileAccountRepository implements AccountRepository {

	/** 파일 저장 경로 */
	private static final String FILE_PATH = "files/accounts.dbf";

	/** 레코드수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int ACCOUNT_COUNT_LENGTH = 4;

	/** 레코드(친구 이름,나이,몸무게,전화번호) 저장을 위한 컬럼별 사이즈 고정 -> 이것을 고정형 사이즈라고 한다 */
	private static final int ACCOUNTNUM_LENGTH = 40; 		// 계좌번호(40바이트) - 계좌 자리수 확보
	private static final int ACCOUNTOWNER_LENGTH = 10; 		// 예금주명(10바이트) - 5글자 자리수 확보
	private static final int PASSWARD_LENGTH = 4; 			// 비밀번호(4바이트) - int형이기 때문에 4바이트 고정 확보
	private static final int RESTMONEY_LENGTH = 8; 			// 계좌 잔액(8바이트) - 더블형이기 때문에 8바이트 고정 확보
	private static final int BORROWMONEY_LENGTH = 8; 		// 대출 잔액(8바이트) - 더블형이기 때문에 8바이트 고정 확보
//	String은 고정 자리를 확보해야한다 글자의 크기가 어디까지인지 모르기 때문이다
	/** 계좌정보 저장을 위한 레코드 사이즈 : 70바이트 */
	public static final int ACCOUNT_LENGTH = ACCOUNTNUM_LENGTH + ACCOUNTOWNER_LENGTH + PASSWARD_LENGTH + RESTMONEY_LENGTH + BORROWMONEY_LENGTH;
	
//	저장된 계좌 수
	private int accountCount = 0;
	
	private RandomAccessFile file;
	
	public FileAccountRepository() throws IOException {
		// 읽고 쓰기 가능한 RandomAccessFile 객체 생성
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// 저장된 파일이 있는 경우..
		if (file.length() != 0) {
			accountCount = file.readInt();
		}
	}
	
	@Override
	public int getCount() {
		return accountCount;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		for (int i = 0; i < accountCount; i++) {
			Account account = null;
			try {
				account = read(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			list.add(account);
		}
		return list;
	}
	
	/** 특정 위치의 레코드 정보를 Friend로 반환 - 헬퍼메소드*/
	private Account read(int index) throws IOException {
		Account account = null;
		String accountOwner = null;
		int passwd = 0;
		long restMoney = 0;
		String accountNum = null;
		
		file.seek((index * ACCOUNT_LENGTH) + ACCOUNT_COUNT_LENGTH);
		for (int i = 0; i < (ACCOUNTOWNER_LENGTH / 2); i++) {
			accountOwner += file.readChar();  // "김기정  "
		}
		accountOwner = accountOwner.trim(); // "김기정"	- trim을 안하면 김,기,정,' ',' ' 이런식으로 나오기 때문에 제거해줘야한다
		passwd = file.readInt();
		restMoney = file.readLong();
		for (int i = 0; i < (ACCOUNTNUM_LENGTH / 2); i++) {
			accountNum += file.readChar();
		}
		accountNum = accountNum.trim(); // 전화번호도 마찬가지로 뒤에 2바이트가 빈 공간이기때문에 trim 추가해준다

		try {
			account = new Account(accountOwner, passwd, restMoney);
		} catch (NotBalanceException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public boolean addAccount(Account account) {
			// 파일의 마지막 위치로 파일 포인터 이동.
			try {
				file.seek((accountCount * ACCOUNTNUM_LENGTH) + ACCOUNT_COUNT_LENGTH);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}		//(RECORD_COUNT_LENGTH : 친구의 목록 수) + ((recordCount * RECORD_LENGTH) : 친구 목록의 정보들)

			// 새로운 레코드(계좌) 추가
			// 10 + 4 + 8 + 40 >>이름, 비밀번호, 계좌 잔액, 계좌 번호
			String accountOwner = account.getAccountOwner();
			int passwd = account.getPasswd();
			long restMoney = account.getRestMoney();
			String accountNum = account.getAccountNum();
			
			int charCount = accountOwner.length();
			// 10바이트(5글자)로 이름 저장
			for (int i = 0; i < (ACCOUNTOWNER_LENGTH / 2); i++) {						//(TELEPHONE_LENGTH / 2) : 길이/2 하는 이유는 문자열 하나에 2바이트씩 쓰기 때문에 10바이트 = 5글자라는 뜻
				try {
					file.writeChar((i < charCount ? accountOwner.charAt(i) : ' '));
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage());
				}			
			}

			// 나이(4바이트)
			try {
				file.writeInt(passwd);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 몸무게(8바이트)
			try {
				file.writeDouble(restMoney);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}

			// 40바이트(20글자)로 전화번호 저장
			charCount = accountNum.length();
			for (int i = 0; i < (ACCOUNTNUM_LENGTH / 2); i++) {
				// EX) "010-9179-8707 "
				try {
					file.writeChar((i < charCount ? accountNum.charAt(i) : ' '));
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage());
				}
			}

			// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
			// 등록된 레코드(친구) 수 1 증가
			try {
				file.seek(0);
				file.writeInt(++accountCount);
				return true;
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
	}

	@Override
	public Account searchAccount(String accountNum) {
		Account account = null;
		String accountOwner = null;
		int passwd = 0;
		long restMoney = 0;
		
		try {
//			파일의 끝으로 이동 - 이름이 같은 곳으로 이동해야함
			file.seek((accountCount * ACCOUNTNUM_LENGTH) + ACCOUNT_COUNT_LENGTH);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		for (int i = 0; i < (ACCOUNTOWNER_LENGTH / 2); i++) {
			try {
				accountOwner += file.readChar();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			} 
		}
		accountOwner = accountOwner.trim();
		try {
			passwd = file.readInt();
			restMoney = file.readLong();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		for (int i = 0; i < (ACCOUNTNUM_LENGTH / 2); i++) {
			try {
				accountNum += file.readChar();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		accountNum = accountNum.trim(); // 계좌번호도 마찬가지로 뒤에 2바이트가 빈 공간이기때문에 trim 추가해준다

		try {
			account = new Account(accountOwner, passwd, restMoney);
		} catch (NotBalanceException e) {
			throw new RuntimeException(e.getMessage());
		}
		return account;
	}

	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		return null;
	}

	@Override
	public boolean removeAccout(String accountNum) {
		return false;
	}
	
	public void close() {
		try {
			if (file != null) file.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
