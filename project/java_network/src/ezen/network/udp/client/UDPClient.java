package ezen.network.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP기반 클라이언트
 */
public class UDPClient {
	String serverIP;
	DatagramSocket dataSocket;	
	DatagramPacket sendPacket;
	
	public UDPClient(){
		this("localhost");
	}
	public UDPClient(String serverIP){
		this.serverIP = serverIP;
	}
	
	
	public void clientStart() throws Exception{
		// DatagramPacket 송수신을 위한 DatagramSocket 생성
		dataSocket  = new DatagramSocket(8282);// 수신을 위한 포트

		String message = "안녕하세요";
		byte[] buffer = message.getBytes();
		
		// 서버에 전송할 우편물 생성
		sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverIP), 2023);
		
		// 서버에 데이터(우편물) 전송
		dataSocket.send(sendPacket);
		
		
		// 데이터 수신을 위한 DatagramPacket(빈우편물) 생성
		byte[] fileBuffer = new byte[1024*10];
		DatagramPacket dataReceivePacket = new DatagramPacket(fileBuffer, fileBuffer.length);
		dataSocket.receive(dataReceivePacket);
		System.out.println("서버로부터 수신한 파일: " + fileBuffer);
		for (byte b : fileBuffer) {
			System.out.print(b);
		}
		
	}
	
	public void close() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}
	
	
	public static void main(String[] args) {
		UDPClient client = new UDPClient();
		try {
			client.clientStart();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
		}
	}

}
