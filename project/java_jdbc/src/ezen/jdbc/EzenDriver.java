package ezen.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
/**
 * 드라이버를 이해하기 위해 약식으로 구현하기
 * @author 홍재헌
 * 230613 수업
 */
public final class EzenDriver implements Driver{
	
	static {
		Class cls = EzenDriver.class;
		try {
			DriverManager.registerDriver((Driver) cls.newInstance());
			System.out.println("EzenDriver가 생성되었고, DriverManager에 등록 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	
	//테스트를 위한 메인메소드 생성
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("ezen.jdbc.EzenDriver");
	}

}
