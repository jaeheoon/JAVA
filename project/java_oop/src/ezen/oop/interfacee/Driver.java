package ezen.oop.interfacee;

public class Driver {
	
	private Car car;
	
	public Driver() {}
	
	public Driver(Car car) {
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void drive() {
		car.turnOn();
		car.run();
		car.speedUp(10);
		car.speedDown(5);
		car.stop();
		car.turnOff();
	}
}
