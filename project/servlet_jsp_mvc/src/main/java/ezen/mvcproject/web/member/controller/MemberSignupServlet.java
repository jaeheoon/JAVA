package ezen.mvcproject.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcproject.domain.common.database.DaoFactory;
import ezen.mvcproject.domain.member.dao.MemberDao;
import ezen.mvcproject.domain.member.dto.Member;

/**
 * 회원 가입 화면 요청 처리 컨트롤러(서블릿)
 */
@WebServlet("/member/signup")
public class MemberSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPath = "/WEB-INF/views/member/signup.jsp";
		
		// forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
	
	

}
