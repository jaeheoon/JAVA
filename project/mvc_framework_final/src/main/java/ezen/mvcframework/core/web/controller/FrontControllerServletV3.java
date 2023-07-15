package ezen.mvcframework.core.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.web.member.controller.MemberListControllerV3;
import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV3;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV3;

/**
 * 프론트 컨트롤러 구현
 */
//@WebServlet(name = "/frontController", urlPatterns = { "/mvc/*" })
public class FrontControllerServletV3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, ControllerV3> controllerMap = new HashMap<String, ControllerV3>();

	@Override
	public void init() throws ServletException {
		String contextPath = getServletContext().getContextPath();
		controllerMap.put(contextPath + "/mvc/member/signup", new MemberSignupControllerV3());
		controllerMap.put(contextPath + "/mvc/member/signup-action", new MemberSignupActionControllerV3());
		controllerMap.put(contextPath + "/mvc/members", new MemberListControllerV3());
	}

	/**
	 * 웹 브라우저 모든 요청 처리
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 웹 브라우저 요청 URI 분석
		String requestURI = request.getRequestURI();
		System.out.println("[디버깅] : 요청 URI - " + requestURI);

		// 세부 컨트롤러 선택
		ControllerV3 controller = controllerMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// 요청파라메터 정보를 맵에 저장
		Map<String, String> paramMap = createParamMap(request);
		
		ModelAndView mav = controller.process(paramMap);
		// 논리적 뷰 이름 반환
		String viewName = mav.getViewName();
		// 뷰 선택
		MyView view = viewResolve(viewName);
		
		view.render(mav.getModel(), request, response);
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> e = request.getParameterNames();
		Iterator<String> iter = e.asIterator();
		while(iter.hasNext()) {
			String paramName = iter.next();
			String paramValue = request.getParameter(paramName);
			paramMap.put(paramName, paramValue);
		}
		return paramMap;
	}

	private MyView viewResolve(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
