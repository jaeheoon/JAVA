package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.ControllerV4;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

/**
 * 회원 가입 요청 처리 세부 컨트롤러
 */
public class MemberSignupActionControllerV4 implements ControllerV4 {
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/signup-result";
		
		String name = paramMap.get("name");
		String id = paramMap.get("id");
		String passwd = paramMap.get("passwd");
		String email = paramMap.get("email");

		Member member = new Member(id, passwd, name, email, null);
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		memberDao.create(member);
		
		// 모델에 회원정보 저장
		model.put("member", member);
		return viewName;
	}

}
