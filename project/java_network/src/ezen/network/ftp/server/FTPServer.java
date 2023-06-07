package ezen.network.ftp.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 바이트 스트림을 이용하여 파일 다운로드 서비스 제공
 * @author 김기정
 */
public class FTPServer {
	
	public static final int PORT = 2023;
	private boolean running;
	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	/** 서버 구동 */
	public void startUp() throws IOException{
		serverSocket = new ServerSocket(PORT);
		running = true;
		System.out.println("FTPServer["+PORT+"] Startup.....");
		while(running){
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			System.out.println("FTP Client[" + ia.getHostAddress() + "] Connected...");
			
			FTPHandler handler = new FTPHandler(socket);
			handler.start();
		}		
	}
	
	/** 서버 종료 */
	public void shutDown() throws IOException{
		if(serverSocket != null) serverSocket.close();
	}
	
	public static void main(String[] args) {
		FTPServer server = new FTPServer();
		try {
			server.startUp();
			System.out.println("FTPServer["+PORT+"] Startup.....");
		} catch (IOException e) {
			System.out.println("[Degug] : 아래와 같은 예외가 발생하여 서버를 구동할 수 없습니다.");
			System.out.println(e);
		}

	}
}
