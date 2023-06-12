package ezen.jdbc;

import java.sql.Connection;			//인터페이스
import java.sql.DriverManager;
import java.sql.PreparedStatement;	//인터페이스
import java.sql.ResultSet;			//인터페이스
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * PreparedStatement 활용
 * @author 홍재헌
 * 230612 수업
 */
public class DQLExample {
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
	
	public static int removeDepartment(String departmentName) throws ClassNotFoundException, SQLException{
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM departments ")			//주의사항으로 앞 뒤에 하나는 공백을 넣어줘야함, 아니면 붙어서 출력되기때문에 오류남
		  .append("WHERE department_name LIKE '%'||?||'%'");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName); 		//sql의 첫번째 ?인 department_name을 변경해줌
			
			count = pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return count;
	}
	
	public static void findAll() throws ClassNotFoundException, SQLException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT employee_id, last_name, salary, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")			//주의사항으로 앞 뒤에 하나는 공백을 넣어줘야함, 아니면 붙어서 출력되기때문에 오류남
		  .append("FROM employees");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
//			컬럼 인덱스로 컬럼값 접근 - 비권장	
			/*
			while (rs.next()) {
				int employeeId = rs.getInt(1);
				String lastName = rs.getString(2);
				Double salary = rs.getDouble(3);
				String hireDate = rs.getString(4);
				System.out.println(employeeId + "\t" + lastName + "\t"  + salary + "\t" + hireDate);
			}
			*/
//			컬럼 이름으로 컬럼값 접근 - 권장
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				Double salary = rs.getDouble("salary");
				String hireDate = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t"  + salary + "\t" + hireDate);
			}
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
	}

//	List는 객체를 반환해야되기때문에 employee의 정보를 저장하는 클래스를 만들어줌 like Account
	public static List<Employee> findSeach() throws ClassNotFoundException, SQLException{
		List<Employee> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT employee_id, last_name, salary, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")			//주의사항으로 앞 뒤에 하나는 공백을 넣어줘야함, 아니면 붙어서 출력되기때문에 오류남
		.append("FROM employees");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Employee>();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				Double salary = rs.getDouble("salary");
				String hireDate = rs.getString("hire_date");
				Employee employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return list;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		int count = createDepartment("기획실", 103, 1000);
//		int count = removeDepartment("기");
//		System.out.println(count);
//		findAll();
		List<Employee> allList = findSeach();
		for (Employee employee : allList) {
			System.out.println(employee);
		}
	}

}
