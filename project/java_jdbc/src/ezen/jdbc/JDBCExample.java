package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * @author 홍재헌
 * 230612 수업
 */
public class JDBCExample {

	public static void main(String[] args) {
//		Socket socket = new Socket("localhost", 1521);
//		System.out.println("오라클 서버와 연결되었습니다");
//		오라클 서버가 사용하는 응용 프로토콜에 따라 프로그래밍, 네트워크 개념 이해하기 위해 생성
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
// 		String url = ＂jdbc:mysql://localhost:3306/데이터베이스명"; //MariaDB
		String userid = "hr";
		String password	= "hr";
		
//		SQL문을 넣을땐 자바에서 직접 치지 말고 SQL 디벨로퍼에서 해보고 오류가 없으면 복사/붙여넣기 하기
		String sql = "INSERT INTO departments(department_id, department_name, manager_id, location_id)"+
					 "VALUES(departments_seq.NEXTVAL, '재헌', 100, 1000)";
		
//		JDBC API를 이용한 RDB 연동
//		생성자를 이용한 정적 객체 생성
//    	OracleDriver driver = new OracleDriver(); - 이렇게 생성하면 나중에 DBMS가 바뀌었을때 사용이 불가능함
//		리플렉션 API를 이용한 객체 동적 생성
		try {
//			드라이버만 Class.forName(driver 이름)을 전달해주면 DriverManager에서 스태틱 초기화블럭을 이용해서 자동으로 객체를 생성해준다
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없습니다");
			e.printStackTrace();
		}
		System.out.println("오라클 드라이버 생성됨");
		Connection con = null;
		Statement stmt = null;
		try {
//			Connection - 소켓 역할, Statment - 스트림 역할
			con =  DriverManager.getConnection(url, userid, password);  //제대로 생성되면 소켓을 포장하고있는 Connection이 반환됨
			System.out.println("오라클 서버 연결 성공!!!");
//			직접 연결하는 것이 아닌 커넥션 객체한테 전달해주면 됨 - Statement도 인터페이스
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);		//executeUpdate() 메서드가 INSERT, UPDATE, DELETE 다 가능하다, executeUpdate() 메서드는 추가된 행의 수 리턴해줌, DML처리 메소드
			System.out.println(count + "행이 추가되었습니다");
		} catch (SQLException e) {
			System.out.println("오라클 서버 연결 실패!!!");
			e.printStackTrace();
		} finally {
				try {
//					Connection, Statment을 닫아주기 위해 작성
					if (stmt != null) stmt.close();
					if (con != null) con.close();
				} catch (SQLException e) {}
		}
	}

}
