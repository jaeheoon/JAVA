package ezen.oop;

public class GenericMethodExamploe {
	
//	제너릭 메소드
	public static <T> Box<T> makeBox(T t) {
		Box<T> box = new Box<>();
		box.setItem(t);
		return box;
	}
	
	public static void main(String[] args) {
		Box<Robot> box = makeBox(new Robot());
		Robot robot = box.getItem();
		System.out.println(robot);
	}

}
