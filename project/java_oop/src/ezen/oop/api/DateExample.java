package ezen.oop.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String fomattedDate = simpleDateFormat.format(now);
		System.out.println(fomattedDate);
		
		System.out.println(now);
		System.out.println(now.toLocaleString());
		System.out.println(now.getHours());
		
//		특정 날짜 설정할때 Date 클래스 사용
		Date hireDate = new Date(2020, 11, 1);			//입사날짜
		System.out.println(hireDate.toLocaleString());
	}

}
