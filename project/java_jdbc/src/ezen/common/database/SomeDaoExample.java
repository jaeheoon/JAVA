package ezen.common.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Apache DBCP API는 DataSource를 구현한 구현체 Apache DBCP API는 내부적으로 커넥션 풀링을 구현하고 있다.
 * 
 * @author 홍재헌
 *
 */
public class SomeDaoExample {
	
	private DataSource dataSource;
	
	public SomeDaoExample() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		dataSource.setInitialSize(10); // 풀의 초기 커넥션 개수
		dataSource.setMaxTotal(100); // 최대 커넥션 개수
		dataSource.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		dataSource.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		this.dataSource = dataSource;
	}

	public void select() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			System.out.println("DataSource를 통해 얻어온 커넥션 : " + con);
			//---
			//---
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			커넥션 반납
			try {
				con.close();
				System.out.println("사용한 커넥션 반납 완료...");
			} catch (SQLException e) {}
		}

	}

	public static void main(String[] args) {
		SomeDaoExample dao = new SomeDaoExample();
		dao.select();

	}

}
