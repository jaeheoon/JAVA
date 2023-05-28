package ezen.io.bytee;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 데이터 스트림 처리
 * @author 홍재헌
 * 230526 수업
 */
public class DataStreamExample {
	
	static String file = "example5.dat";
	
//	예제이기때문에 throws로 처리
	public static void writeData() throws IOException {
//		파일 데이터들이 이렇게 있다고 가정
		boolean flag = true;
		char lastName = '김';
		String firstName = "기정";
		int age = 50;
		double weight = 70.5;
		
//		DataOutput out = new DataOutputStream(new FileOutputStream(file));					//인터페이스로 구현도 가능
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
		out.writeBoolean(flag);
		out.writeChar(lastName);
		out.writeUTF(firstName);
		out.writeInt(age);
		out.writeDouble(weight);
		out.close();
		System.out.println("정보 파일 출력 완료");
	}
	
	public static void readeData() throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		
//		파일 데이터들을 읽어오기 위해 초기값 지정
		boolean flag = false;
		char lastName = 0;
		String firstName = null;
		int age = 0;
		double weight = 0.0;
		
		flag = in.readBoolean();
		lastName = in.readChar();
		firstName = in.readUTF();
		age = in.readInt();
		weight = in.readDouble();
		System.out.println(flag);
		System.out.println(lastName);
		System.out.println(firstName);
		System.out.println(age);
		System.out.println(weight);
		in.close();
	}
	
	public static void main(String[] args) throws IOException {
		writeData();
		readeData();
	}	

}
