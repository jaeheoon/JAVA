package ezen.portfolio.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ezen.portfolio.article.dto.Memo;
import ezen.portfolio.member.dto.Member;

/**
 * RDB를 통해 게시글  저장 및 목록 구현체
 * @author 김기정
 */
public class JdbcMemoDao  implements MemoDao {
	
	private DataSource dataSource;
	
	public JdbcMemoDao(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	/**
	 * 신규글 등록
	 */
	public boolean create(Memo memo){
		boolean success = false;
		System.out.println("게시글 등록이요....." + memo.getContent());
		/*
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
				con.close();
			} catch (Exception e) {}
		}
		*/
		return success;
	}
	
	
	@Override
	public List<Memo> findByAll() {
		List<Member>  list = null;
		/*
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM member");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Member>();
			while (rs.next()) {			
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
				Member member = new Member();
				member.setId(uid);
				member.setName(uname);
				member.setEmail(email);
				member.setRegdate(regdate);
				list.add(member);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null)  con.close();
			} catch (Exception e) {}
		}
		*/
		return null;
	}
	
//	꼭 테스트 하고 넘어가세요...
	public static void main(String[] args) throws Exception {
		
		
	}

	
}


















