package ezen.jdbc;

import java.sql.Connection;			//인터페이스
import java.sql.DriverManager;
import java.sql.PreparedStatement;	//인터페이스
import java.sql.ResultSet;			//인터페이스
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	호출한쪽에 Employee 정보를 ArrayList에 담아서 Employee 타입으로 리턴해줌
	public static List<Employee> findAll2() throws ClassNotFoundException, SQLException{
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
	
//	employee_id(사원번호)를 이용하여 사원 정보를 반환하는 메소드 구현
//	사원정보는 하나이기 때문에 List가 아닌 Employee타입으로 반환
	public static Employee findById(int employeeId) throws ClassNotFoundException, SQLException{
		Employee employee = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT employee_id, first_name, last_name, salary, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")
		  .append("FROM employees ")
		  .append("WHERE employee_id = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Double salary = rs.getDouble("salary");
				String hireDate = rs.getString("hire_date");
				employee = new Employee();
				employee.setEmployeeId(empId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
			}
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return employee;
	}
	
//	이름(first_name, last_name)으로 사원 검색
	public static List<Employee> findByName(String name) throws ClassNotFoundException, SQLException{
		List<Employee> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT first_name, last_name, employee_id, salary, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")
		  .append("FROM employees ")
		  .append("WHERE first_name LIKE '%' || ? || '%' OR last_name LIKE '%' || ? || '%' ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Employee>();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Double salary = rs.getDouble("salary");
				String hireDate = rs.getString("hire_date");
				Employee employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
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
	
//	Join으로 사원 번호, 사원 이름, 부서명, 도시명 조회
//	컬럼은 키와 행으로 구분되어있기때문에 동적으로 Array를 담으려면 Map을 사용하여 저장한다
//	키는 고정되어서 String으로 받고 값은 String인지 Int인지 모르기 때문에 Object타입으로 받는다
	public static List<Map<String, Object>> findEmployeeDetail() throws ClassNotFoundException, SQLException{
		List<Map<String, Object>> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ")
	  	  .append("    e.employee_id, ")
	  	  .append("    e.last_name, ")
	  	  .append("    d.department_name, ")
	  	  .append("    l.city ")
	  	  .append("FROM ")
	  	  .append("         employees e ")
	  	  .append("    JOIN departments d ON e.department_id = d.department_id ")
		  .append("    JOIN locations   l ON d.location_id = l.location_id ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 				//결과집합, 커서역할이라고 보면 됨 SELECT문에 들어있는 모든 결과가 ResultSet에 들어있음
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				String departmentName = rs.getString("department_name");
				String city = rs.getString("city");
				
//				Map은 행을 의미/ 정렬이 필요 없고 가볍게 사용하기 위해 HashMap 사용
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("employee_id", employeeId);
				row.put("last_name", lastName);
				row.put("department_name", departmentName);
				row.put("city", city);
				list.add(row);
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
//		부서 추가
//		int count = createDepartment("기획실", 103, 1000);
		
//		부서 삭제
//		int count = removeDepartment("기");
//		System.out.println(count);
		
//		전체 검색
//		findAll();
		
//		전체 검색2
//		List<Employee> allList = findAll2();
//		for (Employee employee : allList) {
//			System.out.println(employee);
//		}
		
//		사원 번호로 검색
//		Employee findEmp = findById(107);
//		if (findEmp != null) {
//			System.out.println(findEmp);
//		} else {
//			System.out.println("해당 사원이 존재하지 않습니다");
//		}
		
//		사원 이름으로 검색
//		List<Employee> findList = findByName("ab");
//		if (findList.isEmpty()) {
//			System.out.println("검색된 사원이 존재하지 않습니다");
//		}else {
//			for (Employee employee : findList) {
//				System.out.println(employee);
//				}
//			}
		
//		join으로 여러 테이블 합쳐서 사용
		List<Map<String, Object>> list = findEmployeeDetail();
		for (Map<String, Object> row : list) {
//			System.out.println(row);
			int id = (Integer)row.get("employee_id");
			String ename = (String)row.get("last_name");
			String dname = (String)row.get("department_name");
			String city = (String)row.get("city");
			
			System.out.println(id + ", " + ename +", "+dname+", "+ city );
		}
	}
}

