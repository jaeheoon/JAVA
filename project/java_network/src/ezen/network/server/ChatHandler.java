package ezen.network.server;
/**
 * 네트워크 다중 접속을 위해 쓰레드 클래스 생성
 * 이번엔 쓰레드 상속받는 구조로 작성
 * @author 홍재헌
 *
 */

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatHandler extends Thread {
	
	private Socket socket;
	private DataInput in;
	private DataOutput out;
	
	public ChatHandler(Socket socket) throws IOException {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	public Socket getSocket() {
		return socket;
	}

	public DataInput getIn() {
		return in;
	}

	public DataOutput getOut() {
		return out;
	}
	
	public void process() throws IOException {
		while(true) {
//			입력을 위한 입력 스트림 생성
			String clientMessage = in.readUTF();
			System.out.println("- 원격 클라이언트로부터 수신한 메세지: "+ clientMessage);
			ChatServer.sendMessageAll(clientMessage); 											//ChatServer가 가지고 있는 sendMessageAll을 실행
		
//			출력을 위한 출력 스트림 생성
//			OutputStream out = socket.getOutputStream();										//변수처리 필요 없으니 그냥 변수처리 안하고 새로 생성
//			out.writeUTF(clientMessage);														//클라이언트에게 받은 메세지를 그대로 출력, 이것이 에코 서버
			if (clientMessage.equalsIgnoreCase("q")) {
				System.out.println(socket.getInetAddress().getHostAddress()+"- 원격 클라이언트가 접속을 종료하였습니다");
				break;
			}
			
		}
		socket.close();
		
	}
	
//	자기 자신에게 메세지 출력
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);
	}

	@Override
	public void run() {
		try {
			process();
		} catch (IOException e) {
			System.err.println("에코 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
