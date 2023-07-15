package ezen.mvcframework.web.member.controller;

import java.util.Map;
import ezen.mvcframework.core.web.controller.ControllerV3;
import ezen.mvcframework.core.web.controller.ModelAndView;
import ezen.mvcframework.core.web.view.MyView;

/**
 * 회원 가입 화면 요청 처리 세부 컨트롤러
 */
public class MemberSignupControllerV3 implements ControllerV3 {
	
	@Override
	public ModelAndView process(Map<String, String> paramMap) {
		// 논리적 뷰 이름
		String viewName = "member/signup";
		
		return new ModelAndView(viewName);
	}

}
