package ezen.oop.collection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * config 폴더에 만든 properties 연결 메인 클래스
 * @author 홍재헌
 * 230522 수업
 */
public class PropertiesExample {

	public static void main(String[] args) {
		
//		설정파일
		String configFile = "database.properties";
//		특정 클래스 파일 기준으로 절대경로/상대경로를 이용하여 설정 파일을 읽는 스트림 생성
//		절대경로
		InputStream in = PropertiesExample.class.getResourceAsStream("/config/" + configFile);
//		상대경로
//		PropertiesExample.class.getResourceAsStream("../../../config/" + configFile);		//..은 폴더 상위로 올라가는 것 - oop 위에 ezen 위에 src 밑에 config, 근데 이것도 복잡하니 위에 있는 코드로 사용
		
//		절대경로, 상대경로를 풀어서 설명한 것, InputStream in = PropertiesExample.class.getResourceAsStream("/config/" + configFile);
		Class cls = PropertiesExample.class;									//클래스의 정보를 cls에 저장
		URL fileUrl = cls.getResource("/config/" + configFile);				//클래스 메소드 안에 있는 리소스를 얻을 수 있는 메소드 호출, 동적으로 호출됨
//		URL fileUrl = cls.getResource("../../../config/" + configFile);			//상대경로
		System.out.println(fileUrl);
		String filePath = fileUrl.getFile();									//getFile(); 은 주소값 얻어올 수 있음
		System.out.println(filePath);
		
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		properties 파일의 내용 읽기 getProperty("키 이름", "키가 없을때 나타나는 값")
		String driver = properties.getProperty("driver", "key 값이 없습니다");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String userpassword = properties.getProperty("userpassword");
		String fontName = properties.getProperty("fontName", "굴림체");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(userpassword);
		System.out.println(fontName);
	}

}
