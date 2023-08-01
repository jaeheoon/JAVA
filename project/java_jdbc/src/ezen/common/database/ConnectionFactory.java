package ezen.common.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 싱글톤 패턴 적용
 * @author 홍재헌
 */
public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	private String driver;
	private String url;
	private String username;
	private String password;

	private ConnectionFactory() {
		loadProperties();
		try {
			Class.forName(driver);
		} catch (Exception e) {}
	}

	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	// 테스트를 위한 main
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection con = connectionFactory.getConnection();
		System.out.println("얻어온 커넥션: " + con);
		con.close();
	}

}















