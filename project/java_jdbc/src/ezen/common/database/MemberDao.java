package ezen.common.database;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 홍재헌
 *
 */
public interface MemberDao {
	
	public boolean create(Member member);
	public Member findByUser(String id, String passwd);
	
}
