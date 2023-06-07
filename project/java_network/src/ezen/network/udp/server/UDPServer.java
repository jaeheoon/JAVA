package ezen.network.udp.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * DatagramSocket과 DatagramPacket을 이용한 UDP 기반 서버
 * 편의상 스레드를 이용한 멀티 스레드 생략
 */
public class UDPServer {
	public static final int PORT = 2023;
	
	boolean running;
	DatagramSocket dataSocket;
	DatagramPacket receivePacket;
	
	public void serverStart() throws SocketException {
		
		// DatagramPacket 수신/송신을 위한 DatagramSocket 생성
		dataSocket = new DatagramSocket(PORT);
		running = true;
		System.out.println("### UDP Server Start!! ###");
		while (running) {
			// 클라이언트 데이터 수신을 위한 DatagramPacket 생성(빈우편물)
			byte[] buffer = new byte[1024];
			receivePacket = new DatagramPacket(buffer, buffer.length);

			try {
				// 클라이언트 데이터 수신
				dataSocket.receive(receivePacket); // 데이터 수신시까지 블럭
				
				InetAddress clientIP = receivePacket.getAddress();
				// 수신된 데이터 읽기
				byte[] clientData = receivePacket.getData();
				// 클라이언트에서 테스트로 메시지가 문자열이기 때문에 문자 디코딩처리..
				String clientMessage = new String(clientData, 0, clientData.length);
				System.out.println("클라이언트("+clientIP + ")로부터  수신 메시지 : " + clientMessage);

				// 클라이언트 테스트 파일 전송
				// 클라이언트로 데이터송신을 위한 DatagramPacket 생성
				File file = new File("google.png");
				FileInputStream fin = null;
				byte[] fileBuffer = new byte[1024];
				try{
					fin = new FileInputStream(file);
					int count = 0;
					while((count=fin.read(fileBuffer)) != -1){
						DatagramPacket dataSendPacket = new DatagramPacket(fileBuffer, count, clientIP,	receivePacket.getPort());
						dataSocket.send(dataSendPacket);
					}
				}finally{
					if(fin != null) fin.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}

	public static void main(String[] args) {
		UDPServer server = new UDPServer();
		try {
			server.serverStart();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			server.stopServer();
		}

	}

}
