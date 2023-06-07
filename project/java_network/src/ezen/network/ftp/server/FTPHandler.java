package ezen.network.ftp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 원격 FTP 클라이언트 파일 서비스
 * @author 김기정
 */
public class FTPHandler extends Thread {
	
	private String fileDirectory;
	
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;
	
	public FTPHandler(Socket socket) throws IOException{
		fileDirectory = System.getProperty("user.home") + "/Downloads";
		
		this.socket = socket;
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
	}
	
	private void process() throws IOException{
		// #1. 파일디렉토리의 파일 목록 전송
		//"파일명1,파일명2" CSV 텍스트로 전송
		File directory = new File(fileDirectory);
		// 파일디렉토리가 존재하지 않을 경우 디렉토리 생성
		if(!directory.exists()){
			directory.mkdir();
		}
		
		File[] list = directory.listFiles();
		StringBuilder sb = new StringBuilder();
		for (File file : list) {
			String fileName = file.getName();
			long fileSize = file.length()/1024;
			sb.append(fileName + " (" + fileSize + "KB),");
		}
		out.writeUTF(sb.toString());
		
		//--------------------------------------------------------------
		
		//#2. 사용자가 다운로드 받고자 하는 파일명 수신
		String downFileName = in.readUTF();
		
		//#3. 파일 전송
		sendFile(downFileName);
	}
	
	public void sendFile(String fileName) throws IOException{
		File file = new File(fileDirectory, fileName);
		long fileSize = file.length();
		
		// 파일 사이즈 출력(클라이언트 다운로드 상태 출력 시 사용)
		out.writeLong(fileSize);
		
		// 파일 전송
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int count = 0;
			while((count=fin.read(buffer)) != -1){
				out.write(buffer, 0, count);
			}
		}finally{
			if(fin != null) fin.close();
		}
	}
	
	
	public void run(){
		try {
			process();		
		} catch (IOException e) {
			System.out.println("네트워크 장애로 파일을 전송할 수 없습니다.");
		} finally{
			try{
				if(socket != null) socket.close();
			}catch(IOException e){}	
		}
	}
}
