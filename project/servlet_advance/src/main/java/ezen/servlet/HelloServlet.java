package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DB 처리 필요..
		String  name = "김기정";
		
//		응답메시지의 헤더에 Content-Type 설정
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
//		String title = (String)getServletContext().getAttribute("title");
		String title = getServletContext().getInitParameter("page-title");
		out.println("<title>"+title+"</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>DB로부터 가져온 이름 : "+name+"</h2>");
		String message = (String)request.getAttribute("message");
		out.println("<h3>"+message+"</h3>");
		out.println("</body>");
		out.println("</html>");

	}

}
