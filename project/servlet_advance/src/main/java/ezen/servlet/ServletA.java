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

@WebServlet("/a")
public class ServletA extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletA 요청됨...");
//		ServletB로 내부 이동(forward)
//		RequestDispatcher를 이용한 forward
		RequestDispatcher rd = request.getRequestDispatcher("b");
		rd.forward(request, response);
		
		
				
	}

}





