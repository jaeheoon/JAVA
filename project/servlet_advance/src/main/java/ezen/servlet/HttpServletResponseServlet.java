package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class HttpServletResponseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		게시판 글쓰기 요청
//		게시판 테이블에 insert
		System.out.println("글쓰기 등록 완료...");
//		게시판 목록 보여주기 서블릿으로 자동 요청
//		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // 302
//		response.setHeader("Location", "url");
		response.sendRedirect("hello");
		
		
			
	}

}





