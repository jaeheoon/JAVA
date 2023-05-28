package ezen.oop.inheritence;
/**
 * 상속 관계 표현에 관련된 클래스 생성(자식클래스) - 원
 * @author 홍재헌
 *
 */
public class Circle extends Shape {
	private double radian;

	public Circle() {
		super();
	}

	public Circle(double x, double y, double radian) {
		this.x = x;
		this.y = y;
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}
	
	@Override
	public void draw() {
		System.out.println("중심 좌표가 " + x + ", " + y + "이고 반지름이 " + radian + "인 원 입니다.");
	}
	
	@Override
	public double getLength() {
		return 2 * Math.PI * radian;
	}
	
	@Override
	public double getArea() {
//		return Math.PI * radian * radian;
		return Math.PI * Math.pow(radian, 2);		//Math.pow 메소드는 제곱을 할 수 있는 메소드, Math.pow(곱할 변수, 제곱(2를 쓰면 제곱, 3을 쓰면 세제곱)
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", x=" + x + ", y=" + y + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj);
	}
	
	
	
}
