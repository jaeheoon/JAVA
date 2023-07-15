package ezen.mvcframework.core.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV1;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV1;

/**
 * 프론트 컨트롤러 구현
 * 웹 클라이언트의 요청 단일 진입점
 */
//@WebServlet(name="/frontController", urlPatterns = {"/mvc/*"})
public class FrontControllerServletV1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, ControllerV1> controllerMap = new HashMap<String, ControllerV1>();
	
	@Override
	public void init() throws ServletException {
		String contextPath = getServletContext().getContextPath();
		controllerMap.put(contextPath + "/mvc/member/signup", new MemberSignupControllerV1());
		controllerMap.put(contextPath + "/mvc/member/signup-action", new MemberSignupActionControllerV1());
	}

	/**
	 * 웹 브라우저 모든 요청 처리
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// 웹 브라우저 요청 URI 분석
		String requestURI = request.getRequestURI();
		System.out.println("[디버깅] : 요청 URI - " + requestURI);
		
		// 세부 컨트롤러 선택
		ControllerV1 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 세부 컨트롤러 실행
		controller.process(request, response);
	}
}
