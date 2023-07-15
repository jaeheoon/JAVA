package ezen.mvcframework.core.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.mvcframework.core.web.view.MyView;

/**
 * 세부 컨트롤러 명세(역할)
 * @author 김기정
 */
public interface ControllerV2 {
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}


