package ezen.shoppingmall.domain.common.factory;

import ezen.shoppingmall.domain.article.dao.ArticleDao;
import ezen.shoppingmall.domain.article.dao.JdbcArticleDao;
import ezen.shoppingmall.domain.member.dao.JdbcMemberDao;
import ezen.shoppingmall.domain.member.dao.MemberDao;

/**
 * Simple Factory 적용
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();

	private DaoFactory() {}

	public static DaoFactory getInstance() {
		return instance;
	}

	// MemberDao 구현체 반환
	public MemberDao getMemberDao() {
		return new JdbcMemberDao();
	}
	
	// ArticleDao 구현체 반환
	public ArticleDao getArticleDao() {
		return new JdbcArticleDao();
	}

}
