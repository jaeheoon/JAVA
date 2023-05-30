package ezen.io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile은 스트림 API와 달리 파일에 대한 임의접근이 가능하고,
 * 양방향 입출력이 가능하고,
 * 자바 8개의 데이터타입별로 읽기 및 쓰기가 가능한 입출력 유틸리티 클래스이다.
 * File + BufferedInputStream(BufferedOutputStream, 임의접근) + DataInputStream(DataoutputStream) 통합 기능 제공
 * 제약사항은 File 처리에만 사용할 수 있다. - 네트워크, 키보드같은 입출력은 안되고 파일만 가능
 * @author 김기정
 * 230530 수업
 */
public class RandomAccessFileExample {

	public static void main(String[] args) throws IOException {
		String path = "raf_example.dbf";
		
		RandomAccessFile raf = new RandomAccessFile(path, "rw");    //RandomAccessFile(주소값, read/write 가능하게끔 설정)
		
		// 파일 사이즈
		long fileSize = raf.length();
		System.out.println("파일사이즈: " + fileSize);
				
		boolean flage = true;
		char c = '김';
		int age = 30;
		long money = 345567L;
		double weight = 75.78;
		String message = "랜덤억세스파일 다루기";
				
//		현재 파일 포인터 위치 - 파일이 열리면 파일 포인터가 첫번째 줄을 가리킨다, 커서 역할을 생각하면 됨
		long pointer = raf.getFilePointer();			//쓴 것이 없으니까 현재는 0으로 나온다
		System.out.println(pointer);
						
		// 다양한 데이터 타입별 쓰기
		raf.writeBoolean(flage);
		System.out.println(raf.getFilePointer());		//이동한 포인터가 출력된다, boolean 크기가 1이니까 1
		raf.writeChar(c);
		System.out.println(raf.getFilePointer());		//char 크기가 2니까 3
		raf.writeInt(age);
		System.out.println(raf.getFilePointer());
		raf.writeLong(money);
		System.out.println(raf.getFilePointer());
		raf.writeDouble(weight);
		System.out.println(raf.getFilePointer());
		raf.writeUTF(message);
		System.out.println(raf.getFilePointer());
		
		System.out.println("파일사이즈: " + raf.length());
		
		raf.seek(0);									// 처음부터 다시 읽기 위해 포인터 위치를 처음으로 변경(reset역할을 한다)
		System.out.println(raf.readBoolean());			// 다시 포인터가 처음으로 이동하여서 크기가 1로 된다
		System.out.println(raf.readChar());
		System.out.println(raf.readInt());
		System.out.println(raf.readLong());
		System.out.println(raf.readDouble());
		System.out.println(raf.readUTF());
		raf.seek(1);
		System.out.println(raf.readChar());
		
				
		raf.close();	

	}

}
