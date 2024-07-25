package school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 24.07.24(수)
 * jdbc를 활용한 학교 관리 시스템
 * @author 홍재헌
 *
 */
public class SchoolMain {
	/*
	 * oracle 접속 정보
	 */
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner sc = new Scanner(System.in);
	
	public SchoolMain() {
		try {
			Class.forName(driver);	//생성
			System.out.println("Driver Loding");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		while(true) {
			System.out.println("*************************");
			System.out.println("    관리");
			System.out.println("*************************");
			System.out.println("    1. 입력");
			System.out.println("    2. 검색");
			System.out.println("    3. 삭제");
			System.out.println("    4. 종료");
			System.out.println("*************************");
			System.out.print("    번호 선택 : ");
			int num = sc.nextInt();
			if (num == 4) break;
			if (num == 1) insertArticle();
			else if (num == 2) selectArticle();
			else if (num == 3) deleteArticle();
			else {
				System.out.println("1 ~ 4 중 입력하세요");
				continue;
			}
		}
		System.out.println("프로그램을 종료합니다");
		
	}
	
	public void insertArticle() {
		String name = "";
		String data = "";
		while(true) {
			System.out.println("*************************");
			System.out.println("    1. 학생");
			System.out.println("    2. 교수");
			System.out.println("    3. 관리자");
			System.out.println("    4. 이전메뉴");
			System.out.println("*************************");
			System.out.print("    번호 선택 : ");
			int num = sc.nextInt();
			
			this.getConnection();
			
			if (num == 4) break;
			if (num == 1) {
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.print("학번 입력 : ");
				data = sc.next();
				dataInsert(name, data, 1);
			} else if (num == 2) {
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.print("과목 입력 : ");
				data = sc.next();
				dataInsert(name, data, 2);
			} else if (num == 3) {
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.print("부서 입력 : ");
				data = sc.next();
				dataInsert(name, data, 3);
			}
			else {
				System.out.println("1 ~ 4 중 입력하세요");
				continue;
			}
		}
	}
	
	public void dataInsert(String name, String data, int code) {
		try {
			pstmt = con.prepareStatement("insert into school values(?, ?, ?)");
			
			//?에 데이터 매핑
			pstmt.setString(1, name);
			pstmt.setString(2, data);
			pstmt.setInt(3, code);
			
			//실행 - 개수 리턴
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();	//생성이 됐을때만 close()
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectArticle() {
		String name = "";
		while(true) {
			System.out.println("*************************");
			System.out.println("    1. 이름 검색");
			System.out.println("    2. 전체 검색");
			System.out.println("    3. 이전메뉴");
			System.out.println("*************************");
			System.out.print("    번호 선택 : ");
			int num = sc.nextInt();
			
			this.getConnection();
			
			if (num == 3) break;
			if (num == 1) {
				System.out.print("검색할 이름 :");
				name = sc.next();
				try {
					pstmt = con.prepareStatement("select name, value, code from school where name like ?");
					pstmt.setString(1, "%" + name + "%");
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String getName = rs.getString("name");
						String getValue = rs.getString("value");
						int getCode = rs.getInt("code");
						print(getCode, getName, getValue);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (num == 2) {
				try {
					pstmt = con.prepareStatement("select name, value, code from school");
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String getName = rs.getString("name");
						String getValue = rs.getString("value");
						int getCode = rs.getInt("code");
						print(getCode, getName, getValue);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("1 ~ 3 중 입력하세요");
				continue;
			}
			
		}
		
	}
	
	public void print(int code, String name, String value) {
		if (code == 1) {
			System.out.print("이름 : " + name + "\t");
			System.out.print("학번 : " + value);
			System.out.println();
		} else if (code == 2) {
			System.out.print("이름 : " + name + "\t");
			System.out.print("과목 : " + value);
			System.out.println();
		} else if (code == 3) {
			System.out.print("이름 : " + name + "\t");
			System.out.print("부서 : " + value);
			System.out.println();
		}
	}
	
	public void deleteArticle() {
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.next();
		
		this.getConnection();  //호출
		
		try {
			pstmt = con.prepareStatement("delete school where name = ?");
			
			//?에 데이터 매핑
			pstmt.setString(1, name);
			
			//실행 - 개수 리턴
			int su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();	//생성이 됐을때만 close()
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new SchoolMain().menu();
	}

}
