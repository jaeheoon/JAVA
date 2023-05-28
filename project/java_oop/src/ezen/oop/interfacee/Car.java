package ezen.oop.interfacee;

/**
 * 자동차 명세
 * @author 김기정
 *
 */
public interface Car {
	public void turnOn();
	public void turnOff();
	public void run();
	public void speedUp(int speed);
	public void speedDown(int speed);
	public void stop();
}
