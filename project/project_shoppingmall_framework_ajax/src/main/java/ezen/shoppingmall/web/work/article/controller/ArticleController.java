package ezen.shoppingmall.web.work.article.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezen.shoppingmall.domain.article.dao.ArticleDao;
import ezen.shoppingmall.domain.article.dto.Memo;
import ezen.shoppingmall.domain.article.service.ArticleService;
import ezen.shoppingmall.domain.common.factory.DaoFactory;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.member.dto.Member;
import ezen.shoppingmall.web.common.page.PageParams;
import ezen.shoppingmall.web.common.page.Pagination;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 방명록 쓰기 및 목록 처리 세부 컨트롤러 
 * /article
 */
public class ArticleController implements HttpController {

	// 한 페이지에 보여지는 목록 갯수 설정
	private static final int ELEMENT_SIZE = 10;
	// 한페이지에 보여지는 페이지 갯수 설정
	private static final int PAGE_SIZE = 10;
	
	private ArticleService articleService = ServiceFactory.getInstance().getArticleService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		String viewName = null;

		// 방명록 목록 요청 (GET)
		if (request.getMethod().equalsIgnoreCase("get")) {
			// 사용자 선택페이지
			String requestPage = paramMap.get("page");
			if (requestPage == null || requestPage.equals("")) {
				requestPage = "1";
			}
			int selectPage = Integer.parseInt(requestPage);

			// 페이징 계산을 위한 게시글 전체 갯수 조회
			int rowCount = articleService.getAticleCount();

			// 전체 페이지수 계산
			PageParams params = new PageParams(ELEMENT_SIZE, PAGE_SIZE, selectPage, rowCount);
			Pagination pagination = new Pagination(params);
			List<Memo> list = articleService.getArticles(params);

			// 모델에 게시글 목록 설정
			model.put("list", list);
			// 모델에 페이징 정보 설정
			model.put("pagination", pagination);
			viewName = "article/articles";

		} else {
			String content = paramMap.get("content");

			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			String memberId = member.getId();
			String memberName = member.getName();

			Memo memo = new Memo();
			memo.setMemberId(memberId);
			memo.setMemberName(memberName);
			memo.setContent(content);
			
			articleService.writeArticle(memo);

//			forward가 아닌 redirect 처리
			viewName = "redirect:article";
		}
		
		return viewName;
	}

}
