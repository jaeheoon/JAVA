package ezen.mvcframework.core.web.controller;

import java.util.Map;

/**
 * 세부 컨트롤러 명세(역할)
 * @author 김기정
 */
public interface ControllerV3 {
	public ModelAndView process(Map<String, String> paramMap);
}


