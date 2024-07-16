package abstract_;

import java.util.Scanner;

/**
 * 날짜 format 이용하여 만년달력 만들기
 * @author 홍재헌
 *
 */
public class CalendarMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		CalendarEx ce = new CalendarEx(year, month);
		for (int i = 0; i < ce.dayName.length; i++) {
			System.out.print(ce.dayName[i] + "\t");
		}
		ce.calc();
		sc.close();
	}

}

/*
[문제] 만년달력

[클래스]
CalendarEx
[필드]
필드는 원하는 것으로 직접 잡기 
[메소드]
생성자 : 년도, 월을 입력
- 기본생성자 : 입력
- 메소드 : calc() -> 매달 1일의 요일이 무엇인지? (Calendar에 메소드를 찾아서 수행)
                  -> 매달 마지막이 28, 29, 30, 31 무엇인지? (Calendar에 메소드를 찾아서 수행)
        display() -> 출력
         
[클래스]
CalendarMain         

[실행결과]
년도 입력 : 2024                  		년도 입력 : 2000
월 입력 : 1                     		월 입력 : 2

일   월   화   수   목   금   토         일   월   화   수   목   금   토
   	  1    2    3    4    5    6               		1    2    3    4    5
 7    8    9   10   11   12   13          6    7    8    9   10   11   12
14   15   16   17   18   19   20         13   14   15   16   17   18   19
21   22   23   24   25   26   27         20   21   22   23   24   25   26
28   29   30   31                 		 27   28   29
*/