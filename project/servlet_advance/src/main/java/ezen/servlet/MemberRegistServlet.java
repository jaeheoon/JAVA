package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/register")
public class MemberRegistServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		/*
		String uname = request.getParameter("name");
		String pwHint = request.getParameter("pwhint");
		String[] interests = request.getParameterValues("interest");
		
//		수신한 데이터 DB 처리
		
		System.out.println(uname);
		if(uname.trim().equals("")) {
			System.out.println("이름을 입력하지 않음");
		}
		
		System.out.println(pwHint);
		
		if(interests != null) {
			for (String interest : interests) {
				System.out.println(interest);
			}
		}else {
			System.out.println("관심사항을 선택하지 않았다..");
		}
		*/
		
//		파라메터 이름을 알지 못할 때
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName + "=" + paramValue);			
		}
		
		

	}

}
