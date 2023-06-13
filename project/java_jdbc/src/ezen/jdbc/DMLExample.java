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
public class DMLExample {
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
//			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, departmentName); 		//sql의 첫번째 ?인 department_name을 변경해줌
			pstmt.setInt(2, managerId); 				//sql의 두번째 ?인 manager_id을 변경해줌
			pstmt.setInt(3, locationId);				//sql의 세번째 ?인 location_id을 변경해줌
			
			count = pstmt.executeUpdate();
//			con.commit();
		} catch (Exception e) {
//			con.rollback();
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
		  .append("WHERE department_name LIKE ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+departmentName+"%"); 		//sql의 첫번째 ?인 department_name을 변경해줌
			
			count = pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return count;
	}
	
//	사원 등록하는 예제
//	Employee에 매개변수가 많이때문에 Employee 객체를 받아서 한번에 관리해줌
	public static int createEmployee(Employee employee) throws ClassNotFoundException, SQLException{
		int count = 0;
//		String sql = "INSERT INTO departments(department_id, department_name, manager_id, location_id)"+
//					 "VALUES(departments_seq.NEXTVAL, ?, ?, ?)";
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, department_id) ")
		  .append("VALUES(employees_seq.NEXTVAL, ?, ?, ?, ?, sysdate, ?, ?, ?) ");
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("UPDATE employees ")
		   .append("SET salary = salary + 500 ")
		   .append("WHERE department_id = ? ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			
			con =  DriverManager.getConnection(url, userid, password);
			con.setAutoCommit(false);
			
//			사원 등록
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhoneNumber());
			pstmt.setString(5, employee.getJobId());
			pstmt.setDouble(6, employee.getSalary());
			pstmt.setInt(7, employee.getDepartmentId());
			count = pstmt.executeUpdate();
			
//			같은 부서의 모든 사원 급여 + 500;
			pstmt = con.prepareStatement(sb2.toString());
			pstmt.setInt(1, employee.getDepartmentId());
			count = pstmt.executeUpdate();
			
//			다 성공하면 커밋
			con.commit();
		} catch (Exception e) {
//			하나라도 실패하면 롤백
			con.rollback();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {	}
		}
		return count;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		int count = createDepartment("기획실", 103, 1000);
//		int count = removeDepartment("획");
//		System.out.println(count + "개의 부서가 삭제되었습니다");
		
//		신입사원 정보
		Employee emp = new Employee();
		emp.setFirstName("길동");
		emp.setLastName("홍");
		emp.setEmail("hong@gamil.com");
		emp.setPhoneNumber("000.0000.0000");
		emp.setJobId("IT_PROG");
		emp.setSalary(10000);
		emp.setDepartmentId(100);
		
		createEmployee(emp);
		System.out.println("신입사원 등록 완료");
	}

}
