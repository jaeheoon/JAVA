package ezen.mvcframework.web.member.controller;

import java.util.List;
import java.util.Map;

import ezen.mvcframework.core.web.controller.ControllerV4;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

public class MemberListControllerV4 implements ControllerV4{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/members";
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		List<Member> members = memberDao.findByAll();
		model.put("members", members);
		return viewName;
	}

}













