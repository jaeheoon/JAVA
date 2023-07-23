package ezen.shoppingmall.domain.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.article.dto.Memo;
import ezen.shoppingmall.domain.common.factory.DaoFactory;

/**
 * RDB를 통해 게시글 저장 및 목록 구현체
 * @author 김기정
 */
public class JdbcArticleDao  implements ArticleDao {
	
	/**
	 * 신규글 등록
	 */
	public boolean create(Connection connection,  Memo memo){
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO memo (")
		  .append("    m_id,")
		  .append("    content,")
		  .append("    member_id")
		  .append(" ) VALUES (")
		  .append("   memo_id_seq.NEXTVAL,")
		  .append("   ?,")
		  .append("   ?")
		  .append(")");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setString(1, memo.getContent());
			pstmt.setString(2, memo.getMemberId());
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
	
	
	
	@Override
	public int getCountAll(Connection connection) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(*) cnt")
		  .append(" FROM memo");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {}
		}
		return count;
		
		
	}
	
	@Override
	public List<Memo> findByAll(Connection connection, int requestPage, int elementSize) {
		List<Memo>  list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT  page, id, write_date,    content,    member_name")
		  .append(" FROM (  SELECT  ceil(ROWNUM / ?) page, id,  write_date,   content,   member_name")
		  .append("         FROM (  SELECT m1.m_id id,  to_char(m1.write_date, 'yyyy-MM-DD HH24:MI') write_date, m1.content content,  m2.name member_name")
		  .append("                 FROM memo m1")
		  .append("                     JOIN member m2 ON m1.member_id = m2.id")
		  .append("                 ORDER BY m_id DESC) )")
		  .append(" WHERE  page = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sb.toString());
			pstmt.setInt(1, elementSize);
			pstmt.setInt(2, requestPage);
			rs = pstmt.executeQuery();
			list = new ArrayList<Memo>();
			while (rs.next()) {			
				int id = rs.getInt("id");
				String writeDate = rs.getString("write_date");
				String content = rs.getString("content");
				// 웹 페이지 줄바꿈 처리
				content = content.replaceAll("\r", "<br>");
				String memberName = rs.getString("member_name");
				Memo memo = new Memo();
				memo.setId(id);
				memo.setWriteDate(writeDate);
				memo.setContent(content);
				memo.setMemberName(memberName);
				list.add(memo);
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
}


















