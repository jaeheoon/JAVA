package ezen.common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * RDB를 통해 회원  저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 홍재헌
 */
public class JdbcMemberDao  implements MemberDao {

	private DataSource dataSource;
	
	public JdbcMemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * 신규회원 등록
	 */
	public boolean create(Member member){
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO member (")
		  .append("     id,")
		  .append("     passwd,")
		  .append("     name,")
		  .append("     email)")
		  .append(" VALUES (?, ?, ?, ?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
			success = true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				// 커넥션 반납
				con.close();
			} catch (Exception e) {}
		}
		return success;
	}
	
	public Member findByUser(String id, String passwd) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM member")
		  .append(" WHERE id = ? AND passwd = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {			
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String regdate = rs.getString("regdate");
				member = new Member();
				member.setId(uid);
				member.setName(uname);
				member.setRegdate(regdate);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				con.close();
			} catch (Exception e) {}
		}
		return member;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		Member member = new Member("heeyoung2", "1111", "이희영", "heeyoung2@gmail.com", null);
		
		MemberDao dao = DaoFactory.getInstance().getMemberDao();
		dao.create(member);
		System.out.println("등록 완료");
		
		Member loginMember = dao.findByUser("bangry", "1111");
		System.out.println(loginMember);
		
		
		
	}
}


















