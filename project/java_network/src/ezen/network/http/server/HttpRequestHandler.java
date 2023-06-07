package ezen.network.http.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequestHandler extends Thread {
	
	private Socket socket;
	private BufferedReader in;
	private BufferedReader fileReader;
	private PrintWriter out;
	
	public HttpRequestHandler(Socket socket) throws IOException{
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
		out = new PrintWriter(socket.getOutputStream());
	}
	
	public void webService() {
		// 웹 브라우저 요청 메시지 구조 예
		/*
         요청방식 요청URI HTTP버전\r\n(CRLF, 라인 변경)     -> 요청라인
         요청헤더명1:요청헤더값1(CRLF)
         요청헤더명2:요청헤더값2(CRLF)       				-> 요청헤더 : 브라우저 관련 정보들(크롬, 사파리, 웨일 등등)
         요청헤더명n:요청헤더값n(CRLFCRLF)					-> 요청헤더가 끝나면 CRLF(엔터)가 두번 나온다 - 구분자 역할
         
         메시지 바디                					    -> 메시지바디 : EMPTY(GET방식)/평소 GET방식일때 아무것도 안들어감, 
         																	회원가입같은거 할때 정보같은걸 서버로 보낼때 POST방식이라고 한다/이럴때 메세지 바디가 들어감
         */
		String requestLine = null;
		try {
			requestLine = in.readLine(); //예) "GET /index.html HTTT/1.1"
			StringTokenizer requstTokenizer = new StringTokenizer(requestLine, " ");
			String method = requstTokenizer.nextToken();
			String uri = requstTokenizer.nextToken(); //예) xxx.html, xxx.jpg, xxx.gif, xxx.zip 등
			if(uri.equals("/")) {
				uri = "/index.html"; // Welcome 파일
			}
			String protocol = requstTokenizer.nextToken(); //예)HTTP/1.1
			
			System.out.println(method);
			System.out.println(uri);
			System.out.println(protocol);
			
			File file = new File(WebServer.WEB_DIRECTORY, uri);
			
			// 웹 서버 응답 메시지 구조 예
			/*
	         HTTP버전 응답코드 응답코드메시지  -> 응답라인
	         응답헤더명1:응답헤더값1
	         응답헤더명2:응답헤더값2           -> 응답헤더
	         응답헤더명n:응답헤더값n
	         
	         메시지 바디(<html>~~</html>)      -> 메시지바디
	         
	         */
			String responseMessage = null;
			// 요청파일 존재시..
			if(file.exists()){
				fileReader = new BufferedReader(new FileReader(file));
				String body = null;
				responseMessage = "HTTP/1.1 200 OK\r\n" + 
				                  "Content-Type:text/html; charset=utf-8\r\n\r\n";
				// 응답 라인과 응답헤더 출력
				out.println(responseMessage);
				// 메시지 바디 출력
				while((body = fileReader.readLine())!= null){
					System.out.println(body);
					out.println(body);
					out.flush();
				}
			}else{
				responseMessage= "HTTP/1.1 404 Not Found\r\n" +
			                     "Content-Type:text/html; charset=utf-8\r\n\r\n" +
						         "요청하신 파일 없데이 T_T..";
				out.println(responseMessage);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(socket != null) socket.close();
			} catch (IOException e) {}
		}
	}

	
	@Override
	public void run() {
		webService();
	}
}
