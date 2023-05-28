package ezen.oop.inheritence;

public class SomeClass {
	public void showShape(Shape shape) {
		if (shape instanceof Circle) {
//			((Circle) shape).getRadian();
			Circle circle = (Circle)shape;
			System.out.println(circle.getRadian());
			shape.draw();
		}
	}
}
