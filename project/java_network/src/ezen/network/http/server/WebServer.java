package ezen.network.http.server;


import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HTTP 표준 응용프로토콜에 따라 클라이언트(웹 브라우저)의 HTTP 요청을 수신하여 분석하고,
 * HTTP 응답메시지를 생성하여 웹 브라우저에 응답(전송)하는 Web(Http) Server 기본 기능 구현
 * @author 김기정
 */
public class WebServer {
	
	/** HTTP 응용프로토콜에서 사용하는 잘 알려진 포트 */
	public static final int PORT = 80; 
	
	/** 모든 웹 브라우저에게 서비스(공유)하고자 하는 리소스 파일(예: html, css, javascript 등...)들이 저장된  웹(Public) 디렉토리 */
//	public static String WEB_DIRECTORY = "C:/some/WebContents";
	public static String WEB_DIRECTORY = "WebContents";
	
	
	public static void main(String[] args) {
		
		boolean running = true;
		
		File webDirectory = new File(WEB_DIRECTORY);
		if(!webDirectory.exists()) {
			webDirectory.mkdir();
		}
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("☆☆☆ Web(Http) Server["+PORT+"] Start ☆☆☆");
			while(running){
				Socket socket = serverSocket.accept();
				System.out.println("Web Client(Browser) Connected...");
				
				// 웹클라이언트 http 요청 메시지 처리 스레드 생성 및 실행
				HttpRequestHandler requestHandler = new HttpRequestHandler(socket);
				requestHandler.start();
			}
			System.out.println("★★★ Http(Web) Server("+PORT+") Stop ★★★");
			
		} catch (IOException e) {
			System.out.println("포트("+PORT+") 충돌로 Http(Web) Server를 구동할 수 없습니다..");
		} finally{
			try {
				if(serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
