package ezen.mvcframework.web.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezen.mvcframework.core.web.controller.ControllerV2;
import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

/**
 * 회원 가입 요청 처리 세부 컨트롤러
 */
public class MemberSignupActionControllerV2 implements ControllerV2 {
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/member/signup-result.jsp";
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		
		Member member = new Member(id, passwd, name, email, null);
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		memberDao.create(member);
		
		// 모델에 회원정보 저장
		request.setAttribute("member", member);
		
		return new MyView(viewPath);
	}
	

}
