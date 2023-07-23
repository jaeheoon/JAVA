package ezen.shoppingmall.domain.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.common.factory.DaoFactory;
import ezen.shoppingmall.domain.member.dto.Member;
import oracle.net.aso.e;

/**
 * RDB를 통해 회원  저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 김기정
 */
public class JdbcMemberDao  implements MemberDao {
	
	/**
	 * 신규회원 등록
	 */
	public boolean create(Connection connection,  Member member){
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO member (")
		  .append("     id,")
		  .append("     passwd,")
		  .append("     name,")
		  .append("     email)")
		  .append(" VALUES (?, ?, ?, ?)");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
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
			} catch (Exception e) {}
		}
		return success;
	}
	
	public Member findByUser(Connection connection, String id, String passwd) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM member")
		  .append(" WHERE id = ? AND passwd = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
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
			} catch (Exception e) {}
		}
		return member;
	}
	
	@Override
	public List<Member> findByAll(Connection connection) {
		List<Member>  list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, name, email, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate FROM member");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
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
			} catch (Exception e) {}
		}
		return list;
	}
	
	@Override
	public Member findById(Connection connection, String id) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'yyyy-MM-DD DAY') regdate")
		  .append(" FROM member")
		  .append(" WHERE id = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				String uid = rs.getString("id");
				String uname = rs.getString("name");
				String email = rs.getString("email");
				String regdate = rs.getString("regdate");
				member.setId(uid);
				member.setName(uname);
				member.setEmail(email);
				member.setRegdate(regdate);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return member;
	}
	
	
	public static void main(String[] args) throws Exception {
		
//		Member member = new Member("heeyoung", "1111", "이희영", "heeyoung@gmail.com", null);
//		MemberDao dao = DaoFactory.getInstance().getMemberDao();
//		dao.create(member);
//		System.out.println("등록 완료");
		
//		Member loginMember = dao.findByUser("bangry313", "1111");
//		System.out.println(loginMember);
//		System.out.println(dao.findById("angry"));
		
	}

	

	
}


















