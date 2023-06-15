package ezen.ams.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * RDB를 통해 은행계좌 목록 저장 및 관리 구현체
 * @author 홍재헌
 * 230613 제작
 */
public class JdbcAccountRepository implements AccountRepository {
	
//	나중에 propertie 파일로 변경할 예정
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password	= "hr";
	
	private Connection con;
	
	public JdbcAccountRepository() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, password);
	}
	
	/**
	 * 계좌 수 반환
	 */
	@Override
	public int getCount() {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*) cnt ")
		  .append("FROM account ");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());				// 컴파일 예외를 런타임 예외로 변환
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return count;
	}

	/**
	 * 계좌 전체 목록 반환
	 */
	@Override
	public List<Account> getAccounts() {
			
			List<Account> list = null;
			Account account = null;
			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT ")
			  .append("    accountnum, ")
			  .append("    accountowner, ")
			  .append("    passwd, ")
			  .append("    restmoney, ")
			  .append("    borrowmoney ")
			  .append("FROM ")
			  .append("    account ")
			  .append("GROUP BY ")
			  .append("    accountnum, ")
			  .append("    accountowner, ")
			  .append("    passwd, ")
			  .append("    restmoney, ")
			  .append("    borrowmoney ")
			  .append("ORDER BY accountnum ");
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
			try {
				Class.forName(driver);
				
				con =  DriverManager.getConnection(url, userid, password);
				pstmt = con.prepareStatement(sb.toString());
				rs = pstmt.executeQuery();
				list = new ArrayList<Account>();
				while (rs.next()) {
					String accountNum = rs.getString("accountnum");
					int passwd = rs.getInt("passwd");
					String accountowner = rs.getString("accountowner");
					Long restmoney = rs.getLong("restmoney");
					Long borrowmoney = rs.getLong("borrowmoney");
					if (borrowmoney != 0) {
						account = new MinusAccount();
						MinusAccount ma = (MinusAccount)account;
						ma.setBorrowMoney(borrowmoney);
					} else {
						account = new Account();
					}
					account.setAccountNum(accountNum);
					account.setPasswd(passwd);
					account.setAccountOwner(accountowner);
					account.setRestMoney(restmoney);
					list.add(account);
				} 
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (con != null) con.close();
				} catch (Exception e) {	}
			}
			return list;
		}

	/**
	 * 계좌 추가
	 */
	@Override
	public boolean addAccount(Account account) {
		boolean addAccount = false;
		
		StringBuilder sb = new StringBuilder();
		
		String accountowner = account.getAccountOwner();
		int passwd = account.getPasswd();
		Long restmoney = account.getRestMoney();
		Long borrowmoney;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			if (account instanceof MinusAccount) {
				MinusAccount ma = (MinusAccount)account;
				borrowmoney = ma.getBorrowMoney();
			} else {
				borrowmoney = (long) 0;
			}
			
			sb.append("INSERT INTO account ( ")
			.append("    accountnum, ")
			.append("    accountowner, ")
			.append("    passwd, ")
			.append("    restmoney, ")
			.append("    borrowmoney ")
			.append(") VALUES ( ")
			.append("    TO_CHAR(SYSDATE, 'YYYY')|| '-' || accountnum_seq.NEXTVAL, ")
			.append("?, ")
			.append("?, ")
			.append("?, ")
			.append("?)");
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, accountowner);
			pstmt.setInt(2, passwd);
			pstmt.setLong(3, restmoney);
			pstmt.setLong(4, borrowmoney);
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				addAccount = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return addAccount;
	}
	
	/**
	 * 계좌번호로 검색 기능
	 */
	@Override
	public Account searchAccount(String accountNum) {
		Account account = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ")
		  .append("    accountnum, ")
		  .append("    accountowner, ")
		  .append("    passwd, ")
		  .append("    restmoney, ")
		  .append("    borrowmoney ")
		  .append("FROM ")
		  .append("    account ")
		  .append("WHERE accountnum = ? ")
		  .append("GROUP BY ")
		  .append("    accountnum, ")
		  .append("    accountowner, ")
		  .append("    passwd, ")
		  .append("    restmoney, ")
		  .append("    borrowmoney ")
		  .append("ORDER BY accountnum ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, accountNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				accountNum = rs.getString("accountnum");
				int passwd = rs.getInt("passwd");
				String accountowner = rs.getString("accountowner");
				Long restmoney = rs.getLong("restmoney");
				Long borrowmoney = rs.getLong("borrowmoney");
				if (borrowmoney != 0) {
					account = new MinusAccount();
					MinusAccount ma = (MinusAccount)account;
					ma.setBorrowMoney(borrowmoney);
				} else {
					account = new Account();
				}
				account.setAccountNum(accountNum);
				account.setPasswd(passwd);
				account.setAccountOwner(accountowner);
				account.setRestMoney(restmoney);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return account;
	}

	/**
	 * 예금주명으로 검색하기
	 */
	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		List<Account> list = null;
		Account account = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ")
		  .append("    accountnum, ")
		  .append("    accountowner, ")
		  .append("    passwd, ")
		  .append("    restmoney, ")
		  .append("    borrowmoney ")
		  .append("FROM ")
		  .append("    account ")
		  .append("WHERE accountowner LIKE '%' || ? || '%' ")
		  .append("GROUP BY ")
		  .append("    accountnum, ")
		  .append("    accountowner, ")
		  .append("    passwd, ")
		  .append("    restmoney, ")
		  .append("    borrowmoney ")
		  .append("ORDER BY accountnum ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, accountOwner);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Account>();
			while (rs.next()) {
				String accountNum = rs.getString("accountnum");
				int passwd = rs.getInt("passwd");
				accountOwner = rs.getString("accountowner");
				Long restmoney = rs.getLong("restmoney");
				Long borrowmoney = rs.getLong("borrowmoney");
				if (borrowmoney != 0) {
					account = new MinusAccount();
					MinusAccount ma = (MinusAccount)account;
					ma.setBorrowMoney(borrowmoney);
				} else {
					account = new Account();
				}
				account.setAccountNum(accountNum);
				account.setPasswd(passwd);
				account.setAccountOwner(accountOwner);
				account.setRestMoney(restmoney);
				list.add(account);
				} 
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return list;
	}

	/**
	 * 계좌 삭제 기능
	 */
	@Override
	public boolean removeAccout(String accountNum) {
		boolean removeAccount = false;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM account ")
		  .append("WHERE accountnum LIKE '%'||?||'%'");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, accountNum); 
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				removeAccount = true;
			}
		}catch (Exception e) {
				throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return removeAccount;
	}
	
	public void close() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	독립적으로 돌아가는지 테스트 메인
	public static void main(String[] args) throws Exception {
		AccountRepository accountRepository = new JdbcAccountRepository();
//		accountRepository.addAccount(new Account("예재헌", 1111, 1000000));
//		accountRepository.addAccount(new MinusAccount("마재헌", 1111, 1000000, 50000000));
		
		System.out.println("--------------------- 계좌 수");
		int count = accountRepository.getCount();
		System.out.println(count);
		
		System.out.println("--------------------- 전체 계좌");
		List<Account> allList = accountRepository.getAccounts();
		for (Account account : allList) {
			System.out.println(account);
		}
		
		System.out.println("--------------------- 계좌 검색");
		Account account = accountRepository.searchAccount("1001");
		System.out.println(account);
		
		allList = accountRepository.searchAccountByOwner("예재헌");
		System.out.println("--------------------- 예금주명 검색");
		for (Account account1 : allList) {
			System.out.println(account1);
		}
		System.out.println("--------------------- 계좌 삭제 여부");
//		boolean removeAccount = accountRepository.removeAccout("1002");
//		System.out.println(removeAccount);
	}

}
