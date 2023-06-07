package ezen.io.bytee;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;

/**
 * File 클래스 관련 수업
 * @author 홍재헌
 * 230525 수업
 */
public class FileExample {

	public static void FileInfo() {
//		String path = "C:\\Users\\user\\Downloads\\온라인에듀 인강 발급확인서(학생용).pdf";
		String path = "scr/assets/cosmo.jpg";
		File file = new File(path);
		System.out.println(file.getName());				// 파일 명만 알아오는 것
		System.out.println(file.getParent());			// 파일 명 빼고 경로 알아오는 것
		System.out.println(file.length());				// 파일의 크기 알아오는 것
		System.out.println(file.exists()); 				// 파일이 실제 존재하는지 여부
		System.out.println(file.lastModified()); 		// 파일이 마지막 변경된 날짜, return은 밀리초로 반환
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(file.lastModified());
		System.out.printf("%1$tF %1$tT \n", date);
		if (file.isDirectory()) {						// 경로명이 디렉토리인지 여부
			System.out.println("디렉토리");
		} else if(file.isFile()) {						// 경로명이 파일인지 여부
			System.out.println("파일");
		}
		System.out.println(file.isAbsolute());			// 파일의 경로가 절대경로인지 여부
		System.out.println(file.getAbsolutePath());		// 파일의 절대 경로를 반환, 
		System.out.println(file.getAbsoluteFile());		// 위에 코드와 비슷하지만 Path는 String을 반환하고 File은 파일 클래스를 반환하여 파일 클래스의 메소드를 사용 가능하다
										
	}
	
	public static void dir() {
//		사용자 홈 디렉토리에 파일 목록 출력
//		System.out.println(System.getProperty("os.name"));					// 현재 설정된 정보를 가져온다, 운영체제를 동적으로 얻어올 수 있다
//		System.out.println(System.getProperty("os.version"));				// 운영체제 버전를 동적으로 얻어올 수 있다
//		System.out.println(System.getProperty("user.name"));				// 컴퓨터 계정이름를 동적으로 얻어올 수 있다
//		System.out.println(System.getProperty("user.home"));				// 사용자 홈 디렉토리를 동적으로 얻어올 수 있다
//		System.out.println(System.getProperty("user.dir"));					// 현재 프로그램이 동작하고 있는 경로를 동적으로 얻어올 수 있다, 리플렉션이랑 비슷한 기능을 한다
//		
//		Properties prop = System.getProperties();							// 현재 운영체제에 있는 모든 정보를 동적으로 얻어올 수 있다
//		Enumeration<Object> keys = prop.keys();								// 키 안에 들어있는 키 목록을 이너멀레이션으로 반납한다
//		while (keys.hasMoreElements()) {									// hasMoreElements = 가져올게있으면 true
//			String key = (String) keys.nextElement();
//			System.out.println(key + " = " + prop.getProperty(key));							// key(키)와 prop(값)을 동적으로 다 얻어올 수 있다
//			
//		}
		
		String homeDirectory = System.getProperty("user.home");				// 사용자 홈 디렉토리를 동적으로 얻어올 수 있다
		File directory = new File(homeDirectory);
		File[] FileList = directory.listFiles();							// 파일 리스트 반환
		for (File file : FileList) {
			if (file.isDirectory()) {
				System.out.println("<DIR>    " + file.getName());				//디렉토리일 경우
			}else if (file.isFile()) {
				System.out.println("<FILE>    " + file.length() + "   " + file.getName());				//파일일 경우
			}
		}
	}
	
	public static void main(String[] args) {
		FileInfo();
		dir();
	}
	
	// 사용자 홈디렉토리/Downloads/myApplication 디렉토리를 생성하고,
	// mytest.txt 파일을 생성하시요...
		public  static void createDirectory() {
			String downloadDirectory = System.getProperty("user.home") + "/Downloads";
			File directory = new File(downloadDirectory + "/myApplication");
			if(directory.mkdir()) {
				File newFile = new File(directory.getAbsolutePath() + "/mytest.txt");
				try {
					boolean isCreated = newFile.createNewFile();
					if(isCreated) {
						System.out.println("파일 생성 완료");
					} 
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

}
