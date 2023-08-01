package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 구구단 동적 생성 서블릿
 */
@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 웹 브라우저의 GET 요청에 따른 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dan = request.getParameter("dan");
		if(dan == null) {
			dan = "9";
		}
		
		int numberDan = Integer.parseInt(dan);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>동적 구구단</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<table border='1' width='80%'>");
		for (int i = 2; i <= numberDan ; i++) {
			out.println("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.println("<td>"+i+" * "+j+" = "+(i*j)+"</td>");
			}
			out.println("</tr>");
		}
		
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	
	
	
	

}







