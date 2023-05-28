package com.ezen.sample2;

import java.lang.String;  // 굳이 안써도 됨
import java.util.Date;

//import com.ezen.sample.*; - *을 사용하면 전부 임포트 되긴 하는데 경로를 못알아보기때문에 보통 클래스 명까지 사용됨
import com.ezen.sample.Lecture;
/*
 * 컨트롤+쉬프트+o 하면 자동으로 import 경로 생성됨
 */

public class PackageExample {

	public static void main(String[] args) {
		Lecture lecture = new Lecture("풀스택");
//		com.ezen.sample.Lecture lecture = new com.ezen.sample.Lecture("풀스택");
		lecture.printName();
		
		Date today = new Date();
		System.out.println(today.toLocaleString());
		
//		자바 표준 API의 java.lang은 기본패키지이므로 import 하지 않아도 됨
		String message;
	}

}
