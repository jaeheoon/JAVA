package ezen.oop;

public class HomeAgency implements Rentable<Robot> {

	@Override
	public Robot rent() {
		Robot robot = new Robot();
		return robot;
	}

}
