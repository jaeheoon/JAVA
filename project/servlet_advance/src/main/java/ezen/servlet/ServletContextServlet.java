package ezen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 실행환경 정보 및 서블릿들간의 데이터 공유를 위해 제공되는 객체
 */
@WebServlet({ "/context" })
public class ServletContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context);
//		환경 정보 얻기
		String applicationPath = context.getContextPath();
		System.out.println(applicationPath);
		
//		서블릿간의 데이터 공유
		context.setAttribute("title", "- 홈페이지 방문을 환영합니다.-");
//		RequestDispatcher rd = context.getRequestDispatcher("b");
		RequestDispatcher rd = request.getRequestDispatcher("b");
		
//		rd.forward(request, response);
		System.out.println("타이틀 저장 완료...");
	}

}
