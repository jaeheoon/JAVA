
public class DataTypeExample {

	public static void main(String[] args) {
		char ch1 = '가';
		char ch2 = 0xAC00;
		char ch3 = '\uAC00';
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		
//		이스케이프 문자처리 할때는 특수문자 앞에 \ 사용하면 가능하다
		String message = "\"자바\"는 웹애플리케이션 개발 최강 언어입니다.";
		System.out.println(message);
		String path = "C:\\a\\b\\c\\some.txt";
		System.out.println(path);
		
//		제어문자
		message = "안녕하세요. 김기정입니다. \n나이는 30살 입니다.";
		System.out.println(message);
		String header = "번호\t이름\t나이";
		System.out.println(header);
		
//		boolean
		boolean isMan = false;
//		boolean flag = 0; 컴파일 에러
		System.out.println(isMan);
		
	}

}
