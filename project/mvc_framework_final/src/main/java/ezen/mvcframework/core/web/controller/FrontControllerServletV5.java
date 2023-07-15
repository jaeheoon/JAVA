package ezen.mvcframework.core.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.adapter.ControllerV3HandlerAdapter;
import ezen.mvcframework.core.web.adapter.ControllerV4HandlerAdapter;
import ezen.mvcframework.core.web.adapter.MyHandlerAdapter;
import ezen.mvcframework.core.web.view.MyView;
import ezen.mvcframework.web.member.controller.HelloHandler;
import ezen.mvcframework.web.member.controller.MemberListControllerV3;
import ezen.mvcframework.web.member.controller.MemberListControllerV4;
import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV3;
import ezen.mvcframework.web.member.controller.MemberSignupActionControllerV4;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV3;
import ezen.mvcframework.web.member.controller.MemberSignupControllerV4;

/**
 * 프론트 컨트롤러 구현
 */
//@WebServlet(name = "/frontController", urlPatterns = { "/mvc/*" })
public class FrontControllerServletV5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Map<String, Object> handlerMappingMap = new HashMap<String, Object>();
	private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<MyHandlerAdapter>();

	@Override
	public void init() throws ServletException {
		initHandlerMappingMap();
		initHandlerAdapters();
	}

	private void initHandlerMappingMap() {
		String contextPath = getServletContext().getContextPath();
		handlerMappingMap.put(contextPath + "/mvc/member/signup3", new MemberSignupControllerV3());
		handlerMappingMap.put(contextPath + "/mvc/member/signup-action3", new MemberSignupActionControllerV3());
		handlerMappingMap.put(contextPath + "/mvc/members3", new MemberListControllerV3());
		handlerMappingMap.put(contextPath + "/mvc/hello", new HelloHandler());
		
		handlerMappingMap.put(contextPath + "/mvc/member/signup4", new MemberSignupControllerV4());
		handlerMappingMap.put(contextPath + "/mvc/member/signup-action4", new MemberSignupActionControllerV4());
		handlerMappingMap.put(contextPath + "/mvc/members4", new MemberListControllerV4());
	}

	private void initHandlerAdapters() {
		handlerAdapters.add(new ControllerV3HandlerAdapter());
		handlerAdapters.add(new ControllerV4HandlerAdapter());
	}

	/**
	 * 웹 브라우저 모든 요청 처리
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 핸들러 선택
		Object handler = getHandler(request);

		if (handler == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// 어댑터 선택
		MyHandlerAdapter adapter = getHandlerAdapter(handler);
		ModelAndView mav = adapter.handle(request, response, handler);
		
		// 뷰 선택
		MyView view = viewResolve(mav.getViewName());
		view.render(mav.getModel(), request, response);
	}

	private Object getHandler(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return handlerMappingMap.get(requestURI);
	}

	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if (adapter.supports(handler)) {
				return adapter;
			}
		}
		throw new IllegalArgumentException("HandlerAdapter를 찾을 수 없습니다. Handler = " + handler);
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
		}

		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> e = request.getParameterNames();
		Iterator<String> iter = e.asIterator();
		while (iter.hasNext()) {
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
