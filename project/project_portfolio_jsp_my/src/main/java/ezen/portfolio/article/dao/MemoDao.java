package ezen.portfolio.article.dao;
import java.util.List;

import ezen.portfolio.article.dto.Memo;

/**
 * 데이터 베이스 게시글 관리 명세
 *  @author 김기정
 */
public interface MemoDao {
	
	public boolean create(Memo memo);
	public List<Memo> findByAll();
	
	
}
