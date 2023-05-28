package ezen.oop.api;

import java.util.Calendar;
import java.util.Formatter;

public class FormatterExample {

	public static void main(String[] args) {
		int number = 1234567;
		Formatter formatter = new Formatter();
		// Formatter format(String format,Object... args) {}
		// format : "%[출력인자순서$][출력옵션(-, +, (,,..)][출력자리수][.소수점이하자리수]출력데이터유형"
		// args : 포맷팅 하고자 하는 가변인자
		String formatedString = formatter.format("%d", number).toString();
		
		System.out.println(formatedString);
		
		// 우측정렬 후 정수로 출력
		System.out.println(formatter.format("%3$d", number, 1000, 2000));							// 3$라는 뜻은 세번째에 있는 2000을 포멧팅 하라는 뜻이다
		
		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 정수로 포맷
		System.out.println(formatter.format("%,+-20d", number));
		
		double height = 23454.34343434356;
		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 소수점 이하 2자리 실수로 포맷
		System.out.println(formatter.format("%,+-20.2f", height));
		
		String name = "김기정";
		formatter = new Formatter();
		// 10자리확보하고 우측정렬 후 문자열 포맷
		System.out.println(formatter.format("%10s", name));
		
		formatter = new Formatter();
		System.out.println(formatter.format("%o", 150)); //8진수 포맷
		System.out.println(formatter.format("%x", 458)); //16진수 포맷
		
		// 콘솔 전용
		System.out.printf("결과 : %,+-10d\n", 198745);
		System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);
		
		// String 클래스의 정적(static)메소드
		String fs = String.format("%,20.2f\n", 198745.678);
		System.out.println(fs);
		
		System.out.println(String.format("%tY", Calendar.getInstance())); 		// 4자리년도
		System.out.println(String.format("%ty", Calendar.getInstance())); 		// 2자리년도
		System.out.println(String.format("%tm", Calendar.getInstance()));		// 숫자월
		System.out.println(String.format("%tB", Calendar.getInstance())); 		// 문자열월
		System.out.println(String.format("%td", Calendar.getInstance()));		// 일
		System.out.println(String.format("%tA", Calendar.getInstance()));		// 요일
		System.out.println(String.format("%tH", Calendar.getInstance())); 		// 24시간
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); // 오전/오후 12시간
		System.out.println(String.format("%tM", Calendar.getInstance()));		// 분
		System.out.println(String.format("%tS", Calendar.getInstance())); 		// 초
		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", 
		Calendar.getInstance())); 
		// 날짜/시간 합성문자 사용
		System.out.println(String.format("%1$tF %1$tT %tA", Calendar.getInstance()));	
		//tF - 년 월 일 합성단어
		//tT - 시 분 초 합성단어
		
		Calendar hireDate = Calendar.getInstance();
		hireDate.set(Calendar.YEAR, 1987);
		hireDate.set(Calendar.MONTH, 02);
		hireDate.set(Calendar.DAY_OF_MONTH, 13);
		
		System.out.printf("%1$tF %1$tT %tA \n", hireDate);
	}

}
