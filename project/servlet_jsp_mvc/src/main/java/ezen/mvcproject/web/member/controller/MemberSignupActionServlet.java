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
@WebServlet("/member/signup-action")
public class MemberSignupActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 회원가입 요청 처리 - POST 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

}
