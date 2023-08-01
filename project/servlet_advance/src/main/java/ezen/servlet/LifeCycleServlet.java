package ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet({ "/cycle", "/cycle2" })
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
    	System.out.println("서블릿 컨테이너에 의해 생성자 호출됨..");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 컨테이너에 의해 init() 메소드 호출됨");
//		new BufferedReader()
		count = 0;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 컨테이너에 의해 service(req, res) 호출됨...");
		count++;
		super.service(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨...");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>당신은 "+count+"번째 방문자입니다..</h2>");
		out.println("</body>");
		out.println("</html>");	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출됨...");
	}
	
	@Override
	public void destroy() {
//		new PrintWriter(;)
	}

}
