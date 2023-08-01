package ezen.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ezen.servlet.account.domain.Account;
import ezen.servlet.account.domain.AccountRepository;
import ezen.servlet.account.domain.JdbcAccountRepository;
import ezen.servlet.account.domain.MinusAccount;
import oracle.net.aso.a;

/**
 * DB 연동을 이용한 계좌 목록 서블릿
 */
@WebServlet("/account/list")
public class AccountListServlet extends HttpServlet {
	
	int count;
	
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AccountRepository  repository = new JdbcAccountRepository();
			List<Account> list = repository.getAccounts();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>계좌목록</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>전체 계좌 목록</h2>");
			out.println("<table border='1' width='80%'>");
			out.println("<tr>");
			out.println("<th>계좌종류</th>");
			out.println("<th>계좌번호</th>");
			out.println("<th>예금주명</th>");
			out.println("<th>비밀번호</th>");
			out.println("<th>잔액</th>");
			out.println("<th>대출금액</th>");
			out.println("</tr>");
			
			for (Account account : list) {
				out.println("<tr>");
				String type = "입출금계좌";
				MinusAccount ma = null;
				if(account instanceof MinusAccount) {
					type = "마이너스계좌";
					ma = (MinusAccount)account;
				}
				out.println("<td>"+type+"</td>");
				out.println("<td>"+account.getAccountNum()+"</td>");
				out.println("<td>"+account.getAccountOwner()+"</td>");
				out.println("<td>"+account.getPasswd()+"</td>");
				out.println("<td>"+account.getRestMoney()+"</td>");
				out.println("<td>"+ma.getBorrowMoney()+"</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
			
			
			
			out.println("</body>");
			out.println("</html>");
			
			
			
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
	}

}
