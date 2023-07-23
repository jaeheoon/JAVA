package ezen.shoppingmall.web.work.member.controller;

import java.util.List;
import java.util.Map;

import ezen.shoppingmall.domain.common.factory.DaoFactory;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.member.dao.MemberDao;
import ezen.shoppingmall.domain.member.dto.Member;
import ezen.shoppingmall.domain.member.service.MemberService;
import ezen.shoppingmall.web.mvc.controller.WebController;

/**
 * 회원 목록 요청 처리 세부 컨트롤러
 * /member
 */
public class MemberListController implements WebController{
	
	private MemberService memberService = ServiceFactory.getInstance().getMemberService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/members";
		
		List<Member> members = memberService.getMembers();
		model.put("members", members);
		return viewName;
	}

}













