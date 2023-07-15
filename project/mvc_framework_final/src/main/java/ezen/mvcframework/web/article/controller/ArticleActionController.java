package ezen.mvcframework.web.article.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezen.mvcframework.core.web.controller.ControllerV5;
import ezen.mvcframework.domain.article.dao.MemoDao;
import ezen.mvcframework.domain.article.dto.Memo;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dto.Member;

public class ArticleActionController implements ControllerV5{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		String viewName = "/mvc/articles";
		
		String content = paramMap.get("content");
		
		HttpSession session =  request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		// 로그인 관리가 없는 관계로 글쓴이 아이디: bangry, 이름 : 김기정 으로 임시 설정
//		String memberId = member.getId();
//		String memberName = member.getName();
		String memberId = "bangry";
		String memberName = "김기정";
		
		Memo memo = new Memo();
		memo.setMemberId(memberId);
		memo.setMemberName(memberName);
		memo.setContent(content);
		
		MemoDao memoDao =  DaoFactory.getInstance().getMemoDao();
		memoDao.create(memo);
//		forward가 아닌 redirect 처리
		return "redirect:" + viewName;
	}

}













