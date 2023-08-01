package ezen.thread;

/*
 * 은행계좌 추상화
 */
public  class Account/* extends Object */{
	
	// 필드 캡슐화(은닉화)
	// 인스턴스 변수들...
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
//	스태틱(정적, 클래스변수)변수들..
//	public static String bankName = "이젠은행";
//	상수
//	관례상 All 대문자로 표기한다.
	public final static String BANK_NAME = "이젠은행";
//	private static int accountId = 1000;
	private static int accountId;
	
//	초기화 블록
//	static 초기화 블록
	static {
//		System.out.println("초기화 블록 실행됨...");
		// 주로 애플리케이션 환경설정파일의 내용을 읽어 오는 코드...
		//--
		//--
		accountId = 1000;
	}
	
//	생성자 오버로딩
	public Account() {}
		
	public Account(String accountOwner, int passwd, long restMoney) {
//		System.out.println("생성자 실행됨...");
		this.accountNum = (accountId++) + "";
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
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
	
	/*
	 * 입금기능
	 */
	public long deposit(long money) {
		return restMoney += money;
	}
	
	/*
	 * 출금기능
	 */
	public long withdraw(long money) {
		return restMoney -= money;		
	}
	
	/*
	 * 잔액조회 기능
	 */
	public long getRestMoney() {
		return restMoney;		
	}
	
	/*
	 * 비밀번호 확인 기능
	 */
	public boolean checkPasswd(int pwd) {
		return passwd == pwd;
	}
	
	/*
	 * 계좌 모든 정보 출력
	 */
	public void printInfo() {
		System.out.println(accountNum+"\t"+accountOwner+"\t******\t"+restMoney);
	}
		
	
	@Override
	public String toString() {
		return accountNum +"\t" + accountOwner+ "\t******\t" + restMoney;
//		return "Account [accountNum=" + accountNum + ", accountOwner=" + accountOwner + ", passwd=" + passwd
//				+ ", restMoney=" + restMoney + "]";
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




