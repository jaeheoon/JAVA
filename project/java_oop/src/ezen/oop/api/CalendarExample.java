package ezen.oop.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR);
		int hh1 = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hh);
		System.out.println(hh1);
		System.out.println(mm);
		System.out.println(ss);
		
		calendar.set(Calendar.YEAR, 2020);
		calendar.set(Calendar.MONTH, 11-1);
		calendar.set(Calendar.DAY_OF_MONTH, 01);
		
		String ymd = calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH)+1) + "월 " + calendar.get(Calendar.DAY_OF_MONTH)+"일";
		System.out.println(ymd);
		
		StringBuilder sb = new StringBuilder();
		sb.append(calendar.get(Calendar.YEAR)).append("년 ").append(calendar.get(Calendar.MONTH)+1).append("월 ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("일 ");
		System.out.println(sb.toString());
		
		long millis = calendar.getTimeInMillis();
		System.out.println(millis);
		Date date = new Date(millis);
//		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 a");
		System.out.println(simpleDateFormat.format(date));
		
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		switch (w) {
		case Calendar.SUNDAY : System.out.println("일"); break;
		case Calendar.MONDAY : System.out.println("월"); break;
		case Calendar.TUESDAY : System.out.println("화"); break;
		case Calendar.WEDNESDAY : System.out.println("수"); break;
		case Calendar.THURSDAY : System.out.println("목"); break;
		case Calendar.FRIDAY : System.out.println("금"); break;
		case Calendar.SATURDAY : System.out.println("토"); break;
		}
		
		
		int result = getWorkDay("19870313", "20230517");
		System.out.println(result + "일 근무하셨습니다");
			
	}

//		특정 날짜 사이에 일수가 필요, 근무 일수
		public static int getWorkDay(String startDate, String endDate) {
			Calendar calendar = Calendar.getInstance();
			
			String sty = startDate.substring(0, 4);
			String stm = startDate.substring(4, 6);
			String std = startDate.substring(6, 8);
			
			int numsty = Integer.valueOf(sty);
			int numstm = Integer.valueOf(stm);
			int numstd = Integer.valueOf(std);
			
			calendar.set(Calendar.YEAR, numsty);
			calendar.set(Calendar.MONTH, numstm);
			calendar.set(Calendar.DAY_OF_MONTH, numstd);
			
			long millis1 = calendar.getTimeInMillis();
			
			sty = endDate.substring(0, 4);
			stm = endDate.substring(4, 6);
			std = endDate.substring(6, 8);
			
			numsty = Integer.valueOf(sty);
			numstm = Integer.valueOf(stm);
			numstd = Integer.valueOf(std);
			
			calendar.set(Calendar.YEAR, numsty);
			calendar.set(Calendar.MONTH, numstm);
			calendar.set(Calendar.DAY_OF_MONTH, numstd);
			
			long millis2 = calendar.getTimeInMillis();
			
			int startEndTime = (int)((((millis2 - millis1)/1000)/60)/60)/24;
			
			return startEndTime+1;
		}
}
