package ezen.shoppingmall.domain.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.article.dao.ArticleDao;
import ezen.shoppingmall.domain.article.dto.Memo;
import ezen.shoppingmall.domain.common.factory.DaoFactory;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.member.dao.MemberDao;
import ezen.shoppingmall.domain.member.dto.Member;
import ezen.shoppingmall.web.common.page.PageParams;
import ezen.shoppingmall.web.common.page.Pagination;
import oracle.net.aso.p;

/**
 * 방명록 관련 비즈니스 로직 처리 및 트랜잭션 처리 구현체
 */
public class ArticleServiceImpl implements ArticleService {

	private DataSource dataSource;
	private ArticleDao memoDao;

	public ArticleServiceImpl(DataSource dataSource, ArticleDao memoDao) {
		this.dataSource = dataSource;
		this.memoDao = memoDao;
	}

	@Override
	public void writeArticle(Memo memo) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			memoDao.create(connection, memo);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)	connection.close();
			} catch (SQLException e1) {	}
		}
	}
	
	@Override
	public int getAticleCount() {
		int count = 0;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			count = memoDao.getCountAll(connection);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)	connection.close();
			} catch (SQLException e1) {	}
		}
		return count;
	}
	

	@Override
	public List<Memo> getArticles(PageParams params) {
		List<Memo> list = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			list = memoDao.findByAll(connection, params.getRequestPage(), params.getElementSize());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)	connection.close();
			} catch (SQLException e1) {	}
		}
		return list;
	}

	

	// 테스트 메인
	public static void main(String[] args) {
//		ServiceFactory serviceFactory = ServiceFactory.getInstance();
//		ArticleService memberService = serviceFactory.getMemberService();

//		Member member = new Member("james", "1111", "제임스", "james1@gmail.com", null);
//		member = memberService.registerMember(member);
//		System.out.println("등록 후 상세정보 : " + member);

//		Member loginMember = memberService.isMember("james", "1111");
//		System.out.println(loginMember);

//		List<Member> members = memberService.getMembers();
//		System.out.println(members);
//
//		Member detailMember = memberService.readMember("bangry");
//		System.out.println(detailMember);

	}

	

}
