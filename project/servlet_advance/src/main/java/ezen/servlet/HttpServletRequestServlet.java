package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class HttpServletRequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		브라우저 요청 메시지 분석
		System.out.println(request);
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String protocol = request.getProtocol();
		
		System.out.println("요청방식: " + method);
		System.out.println("요청URI: " + uri);
		System.out.println("요청프로토콜: " + protocol);
		
		String userAgent = request.getHeader("user-agent");
		System.out.println("브라우저 정보: " + userAgent);
		
		System.out.println("--- 기타 헤더 정보들 ---");		
		Enumeration<String> headerNames  = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName + ":" + headerValue);
		}
		
		String clientIp = request.getRemoteAddr();
		System.out.println(clientIp);
		
		String appPath = request.getContextPath();
		System.out.println(appPath);
		
//		서블릿간 데이터 공유
		RequestDispatcher rd = request.getRequestDispatcher("hello");
		String message = "오늘 수업 끝";
		request.setAttribute("message", message);
		rd.forward(request, response);
		
			
	}

}





