package ezen.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigServlet
 */
@WebServlet(
		urlPatterns = { "/config" }, 
		initParams = { 
				@WebInitParam(name = "message1", value = "김기정 바보"),
				@WebInitParam(name = "message2", value = "김기정 최고")				
		})
public class ServletConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message1, message2;
	
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
		message1 = config.getInitParameter("message1");
		message2 = config.getInitParameter("message2");
	}
	*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(getInitParameter("message1"));
		System.out.println(getInitParameter("message2"));
		
//		System.out.println("message1 : " + message1);
//		System.out.println("message2 : " + message2);
	}

}
