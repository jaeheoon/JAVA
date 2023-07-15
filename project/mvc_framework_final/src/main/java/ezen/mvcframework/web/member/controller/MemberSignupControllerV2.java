package ezen.mvcframework.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.controller.ControllerV1;
import ezen.mvcframework.core.web.controller.ControllerV2;
import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.domain.common.database.DaoFactory;
import ezen.mvcframework.domain.member.dao.MemberDao;
import ezen.mvcframework.domain.member.dto.Member;

/**
 * 회원 가입 화면 요청 처리 세부 컨트롤러
 */
public class MemberSignupControllerV2 implements ControllerV2 {
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/member/signup.jsp";
		return new MyView(viewPath);
	}

}
