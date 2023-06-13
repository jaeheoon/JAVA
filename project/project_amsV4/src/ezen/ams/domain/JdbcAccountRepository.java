package ezen.ams.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * RDB를 통해 은행계좌 목록 저장 및 관리 구현체
 * @author 홍재헌
 *
 */
public class JdbcAccountRepository implements AccountRepository {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password	= "hr";
	
	private Connection con;
	
	public JdbcAccountRepository() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, password);
	}
	
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

	@Override
	public List<Account> getAccounts() {
			
			Account account = null;
			List<Account> list = null;
			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT ")
			  .append("    accountnum, ")
			  .append("    accountowner, ")
			  .append("    passwd, ")
			  .append("    restmoney, ")
			  .append("    borrowmoney, ")
			  .append("    COUNT(*) cnt ")
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
					if (borrowmoney != null) {
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

	@Override
	public boolean addAccount(Account account) {
		boolean addAccount = false;
		
		String accountowner = account.getAccountOwner();
		int passwd = account.getPasswd();
		Long restmoney = account.getRestMoney();
		Long borrowmoney = (long) 0;
		
		StringBuilder sb = new StringBuilder();
		if (account instanceof MinusAccount) {
			account = new MinusAccount();
			MinusAccount ma = (MinusAccount)account;
			borrowmoney = ma.getBorrowMoney();
			System.out.println("마계");
		} else {
			account = new Account();
			System.out.println("예계");
		}
		
		sb.append("INSERT INTO account ( ")
		  .append("    accountnum, ")
		  .append("    accountowner, ")
		  .append("    passwd, ")
		  .append("    restmoney, ")
		  .append("    borrowmoney ")
		  .append(") VALUES ( ")
		  .append("    accountnum_seq.NEXTVAL, ")
		  .append("?, ")
		  .append("?, ")
		  .append("?, ")
		  .append("?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, accountowner);
			pstmt.setInt(2, passwd);
			pstmt.setLong(3, restmoney);
			pstmt.setLong(4, borrowmoney);
			
			int count = pstmt.executeUpdate();
			if (count>0) {
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
	
	@Override
	public Account searchAccount(String accountNum) {
		return null;
	}

	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		return null;
	}

	@Override
	public boolean removeAccout(String accountNum) {
		return false;
	}
	
//	독립적으로 돌아가는지 테스트 메인
	public static void main(String[] args) throws Exception {
		AccountRepository accountRepository = new JdbcAccountRepository();
		boolean yes = false;
		yes = accountRepository.addAccount(new Account("추재헌", 1111, 1000000));
		yes = accountRepository.addAccount(new MinusAccount("미재헌", 1111, 1000000, 10000000));
		
		int count = accountRepository.getCount();
		System.out.println(count);
		
		List<Account> allList = accountRepository.getAccounts();
		for (Account account : allList) {
			System.out.println(account);
		}
		
	}

}
