package ezen.mvcframework.web.article.controller;

import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.ControllerV4;
import ezen.mvcframework.domain.article.dao.MemoDao;
import ezen.mvcframework.domain.article.dto.Memo;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dto.Member;
import ezen.mvcframework.web.common.page.PageParams;
import ezen.mvcframework.web.common.page.Pagination;

public class ArticleListController implements ControllerV4{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "article/articles";
		
		//한 페이지에 보여지는 목록 갯수 설정
		int elementSize = 20;
		//한페이지에 보여지는 페이지 갯수 설정
		int pageSize = 5;
		//사용자 선택페이지
		String requestPage = paramMap.get("page");
		if(requestPage == null || requestPage.equals("")){
			requestPage = "1";
		}
		int selectPage = Integer.parseInt(requestPage);
		
		// 페이징 계산을 위한 게시글 전체 갯수 조회
		MemoDao memoDao =  DaoFactory.getInstance().getMemoDao();
		int rowCount = memoDao.getCountAll();

		// 전체 페이지수 계산
		PageParams params = new PageParams(elementSize, pageSize, selectPage, rowCount);
		Pagination pagination = new Pagination(params);		
		
		List<Memo> list = memoDao.findByAll(selectPage, elementSize);
		
		// 모델에 게시글 목록 설정
		model.put("list", list);
		// 모델에 페이징 정보 설정
		model.put("pagination", pagination);
		return viewName;
	}

}













