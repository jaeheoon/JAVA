package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * PreparedStatement 활용
 * @author 홍재헌
 * 230612 수업
 */
public class JDBCExample2 {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password	= "hr";
	
//	메소드 단위로 DB처리
	public static int createDepartment(String departmentName, int managerId, int locationId) throws ClassNotFoundException, SQLException{
		int count = 0;
//		String sql = "INSERT INTO departments(department_id, department_name, manager_id, location_id)"+
//					 "VALUES(departments_seq.NEXTVAL, ?, ?, ?)";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO departments(department_id, department_name, manager_id, location_id)")
		  .append("VALUES(departments_seq.NEXTVAL, ?, ?, ?)");
//		?는 바인딩 파라메터라고 한다 - 동적으로 변경될 수 있다는 것을 알려줌
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName); 		//sql의 첫번째 ?인 department_name을 변경해줌
			pstmt.setInt(2, managerId); 				//sql의 두번째 ?인 manager_id을 변경해줌
			pstmt.setInt(3, locationId);				//sql의 세번째 ?인 location_id을 변경해줌
			
			count = pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return count;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int count = createDepartment("기획실", 101, 1300);
		System.out.println(count + "개의 부서가 등록되었습니다");
	}

}
