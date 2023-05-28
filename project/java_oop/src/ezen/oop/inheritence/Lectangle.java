package ezen.oop.inheritence;
/**
 * 상속 관계 표현에 관련된 클래스 생성(자식클래스) - 사각형
 * @author 홍재헌
 *
 */
public class Lectangle extends Shape {
	private double width;
	private double height;

	public Lectangle() {
		super();
	}

	public Lectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("시작 좌표가 " + x + ", " + y + "이고 폭은: " + width + " 높이는: "+  height + " 인 사각형 입니다.");
	}
	
	@Override
	public double getLength() {
		return (width + height) * 2;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Lectangle [width=" + width + ", height=" + height + ", x=" + x + ", y=" + y
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
