package ezen.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 마임타입 변경해서 미디어 데이터 동적 전송 서블릿
 * @author 김기정
 *
 */
@WebServlet("/media")
public class MIMEServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestFile = "????";
//		String media = MIMEServlet.class.getResource("../../../media/Servlet.pdf").getFile();
		InputStream in = MIMEServlet.class.getResourceAsStream("../../../media/Servlet.pdf");
		
//		response.setContentType("application/pdf");
		response.setContentType("application/octet-stream");
//		response.setContentType("audio/mpeg");
		
		OutputStream out = response.getOutputStream();
		
//		InputStream in = null;
		try {
//			File file = new File(media);
//			in = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=in.read(buffer)) != -1) {
				out.write(buffer, 0, count);			
			}
		}finally {
			in.close();
			out.close();
		}
		
		
		
			
	}

}





