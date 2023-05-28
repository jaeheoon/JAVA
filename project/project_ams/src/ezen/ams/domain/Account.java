package ezen.ams.domain;

import ezen.ams.exception.NotBalanceException;

/**
 * 은행계좌 추상화
 */
public class Account {
//	필드 캡슐화(은닉화) - private
//	인스턴스 변수들
	private String accountNum, accountOwner;
	private int passwd;
	private long restMoney;
	
//	스태틱(정적, 클래스 변수)변수들
//	public static String bankName = "이젠은행";  - 여기서 바로 초기화도 가능하고
//	상수(값을 변경할 수 없게끔 함) - final 앞이나 뒤에 static 붙이면 됨, final을 붙이려면 값 초기화를 해야함
//	상수는 관례상 전부 대문자로 사용함, 두 단어를 이어서 사용할 시 언더바(_) 사용함
	public final static String BANK_NAME = "이젠은행";				//사용할 곳에서 초기화도 가능
//	private static int accountId = 1000;
	private static int accountId;
//	1. 초기화 블록 사용하기 전에 선언 하고
//	2. 밑에 중괄호{}만 사용하여 블록을 생성한다
	
//	생성자를 만들 시 우클릭 후 Source 메뉴에서 
//	기본 생성자는 Generate Constructor using Fields...
//	전체 생성자는 Generate Constructor from Superclass...
//	를 클릭하면 생성된다
	
//	초기화블록 - 주로 애플리케이션 환경설정 파일의 내용을 읽어오는 코드
//	초기화 블록 사용
//	스태틱 초기화 블록
	static {
//		System.out.println("초기화 블록 실행됨.");
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
//		System.out.println("생성자 실행됨");
		this.accountNum = (accountId++) + "";
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

//	private의 setter/getter 메소드를 만들 시 우클릭 후 Source 메뉴에서 
//	Generater Getter and Setter를 누르면 자동으로 만들어진다
	
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
		System.out.println(accountNum+"\t"+accountOwner+"\t******\t"+ getRestMoney());
	}
	
	
	@Override
	public String toString() {
//	의미있게끔 값을 변경해 준 함수
	return accountNum+"\t"+accountOwner+"\t******\t"+ restMoney;
//	기본 Overriding을 하면 나오는 함수
//		return "Account [accountNum=" + accountNum + ", accountOwner=" + accountOwner + ", passwd=" + passwd
//				+ ", restMoney=" + restMoney + "]";
	}
	
//	equals도 오버라이딩도 해야하는데 이때 이것도 소스쪽에서 자동으로 생성해준다
//	객체를 비교해야할때 equals도 오버라이딩 필수다
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Account other = (Account) obj;
//		return Objects.equals(accountNum, other.accountNum) && Objects.equals(accountOwner, other.accountOwner)
//				&& passwd == other.passwd && restMoney == other.restMoney;
		
//		위 아래 코드는 같다
		return toString().equals(obj.toString());
	}
	
	

	//	스태틱(클래스) 메소드
	public static int getAccountId() {
		return accountId;
	}

	
	
	
}
