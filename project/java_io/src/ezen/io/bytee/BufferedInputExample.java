package ezen.io.bytee;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 버퍼 스트림 이용
 * @author 홍재헌
 * 230526 수업
 */
public class BufferedInputExample {
	public static void main(String[] args) {
		String file = BufferedInputExample.class.getResource("/assets/cosmo.jpg").getFile();		//동적으로 경로 알아오기
		
		InputStream in = null;							//이렇게도 생성 가능 ? 부모, 자식 간 클래스이기 때문에
//		BufferedInputStream in = null;
		
		try {
//			FileInputExample이랑 내용 똑같다 - Buffered Stream 이용함
			in = new BufferedInputStream(new FileInputStream(file));
//			int byteData = in.read();
//			System.out.println(byteData); 				//물통(buffered Stream)에 있는 1byte 데이터 읽어오기
//			
//			byte[] array = new byte[512];				//물통(buffered Stream)에 있는 데이터 전부 읽어오기
//			int count = in.read(array);
//			for (byte b : array) {
//				System.out.println(b);
			
//			표준입력 - Scanner를 사용하기 이전
			//in = System.in;								// 키보드로 읽은 것은 버퍼스트림으로 들어간다 System.in = BufferedInputStream에 생성된 것에 넣어진다
			//System.out.println(in);						확인차원에서 생성해봄
			System.out.print("이름: ");
//			byte[] array = new byte[512];
//			int count = System.in.read(array);				// 문자로 받으려면 디코딩을 해야함
//			디코딩 작업을 해주는 것은 String 클래스이다
//			String name = new String(array, 0, count);
//			System.out.println(name);
//			}
			
//			스캐너는 꼭 키보드로만 받는게 아니라 파일도 받을 수 있고 다양한 것을 받을 수 있다
//			Scanner scanner = new Scanner(System.in);		// System.in의 의미는 디코딩작업을 해주는 것이다
//			String name = scanner.nextLine();
//			System.out.println(name);
			
//			BufferedInputStream 추가 기능
			in.mark(0);										//mark메소드 : 읽어들이고 싶은 데이터에 마킹을 해서 데이터를 읽다가 마킹한 곳으로 돌아갈 수도 있다
			int data = in.read();
			System.out.println(data);
			in.read();
			in.read();
			in.read();
			in.read();
			in.skip(5);										//skip()메소드 : 5바이트 스킵해서 데이터 읽기 가능
			in.read();
			in.reset();										//reset()메소드 : 마킹한 곳으로 돌아가는 메소드
			data = in.read();
			System.out.println(data);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
