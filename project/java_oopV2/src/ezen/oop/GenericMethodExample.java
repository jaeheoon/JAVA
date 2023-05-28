package ezen.oop;
/**
 * 제네릭 메소드 정의
 * @author 홍재헌
 * 230518 수업
 */
public class GenericMethodExample {
	public static <T> Box<T> makeBox(T t) {
		Box<T> box = new Box<>();
		box.setValue(t);
		return box;
	}
	
	public static void main(String[] args) {
		Box<Robot> box = makeBox(new Robot());
		Robot robot = box.getValue();
		System.out.println(robot);
	}
}
