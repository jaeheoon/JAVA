package ezen.mvcframework.core.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV2;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV2;

/**
 * 프론트 컨트롤러 구현
 */
//@WebServlet(name="/frontController", urlPatterns = {"/mvc/*"})
public class FrontControllerServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, ControllerV2> controllerMap = new HashMap<String, ControllerV2>();
	
	@Override
	public void init() throws ServletException {
		String contextPath = getServletContext().getContextPath();
		controllerMap.put(contextPath + "/mvc/member/signup", new MemberSignupControllerV2());
		controllerMap.put(contextPath + "/mvc/member/signup-action", new MemberSignupActionControllerV2());
	}

	/**
	 * 웹 브라우저 모든 요청 처리
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// 웹 브라우저 요청 URI 분석
		String requestURI = request.getRequestURI();
		System.out.println("[디버깅] : 요청 URI - " + requestURI);
		
		// 세부 컨트롤러 선택
		ControllerV2 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 세부 컨트롤러 실행 및 뷰 실행
		MyView view = controller.process(request, response);
		view.render(request, response);
	}
}







