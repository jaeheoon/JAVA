package ezen.mvcproject.web.member.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/members")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 회원 목록 요청 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/member/members.jsp";
		
		MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
		List<Member> members = memberDao.findByAll();
		
		// 모델에 회원정보 저장
		request.setAttribute("members", members);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

}
