package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	/**
	 * 웹 브라우저 요청이 GET 요청일 때 동적 컨텐츠 생성 및 전송
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 DB 처리 필요..
		String  name = "김기정";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>DB로부터 가져온 이름 : "+name+"</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}









