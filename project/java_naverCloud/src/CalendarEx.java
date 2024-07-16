package abstract_;

import java.util.Calendar;

public class CalendarEx {
	protected int year, month;
	protected String[] dayName = {"일", "월", "화", "수", "목", "금", "토"};
	public CalendarEx() { }
	public CalendarEx(int year, int month) {
		this.year = year;
		this.month = month;
	}
	public void calc() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
//		int firstMonth = cal.get(Calendar.MONTH);
//		int firstYear = cal.get(Calendar.YEAR);
//		System.out.println(firstDay);
//		System.out.println("요일 = " + dayName[firstDay-1]);
//		System.out.println(firstMonth+1);
//		System.out.println(firstYear);
		
//		int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
//		System.out.println("이번 달은 " + weekCount + "주로 되어 있다.");
		
		// 이번 달은 몇 일까지 있는가?
		int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//		System.out.println("이번 달은 " + dayCount + "일 까지 있다.");
		System.out.println();
		System.out.println("--------------------------------------------------------");
		if (firstDay > 0) {
			for (int i = 0; i < firstDay-1; i++) {
				System.out.print(" "+"\t");
			}
		}
		for (int i = 1; i <= dayCount; i++) {
			System.out.print(i+"\t");
			if ((i+firstDay)%7 == 1) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
