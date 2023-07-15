package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ControllerV4;
import ezen.mvcframework.core.web.controller.ModelAndView;

/**
 * 회원 가입 화면 요청 처리 세부 컨트롤러
 */
public class MemberSignupControllerV4 implements ControllerV4 {
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String viewName = "member/signup";
		return viewName;
	}
	
	

}
