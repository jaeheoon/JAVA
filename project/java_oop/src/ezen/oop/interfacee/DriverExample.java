package ezen.oop.interfacee;

public class DriverExample {

	public static void main(String[] args) {
		
		Car car = new K3("K3", false, 0);
		Driver driver = new Driver(car);
		driver.drive();
		
		driver.setCar(new Avante("아반테", false, 0));
		driver.drive();
	
	}

}
