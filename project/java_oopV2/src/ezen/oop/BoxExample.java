package ezen.oop;
/**
 * 제네릭 타입 어플리케이션
 * @author 홍재헌
 * 230518 수업
 */
public class BoxExample {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.setValue("두산 베어스");
		System.out.println(box.getValue());
		
		Box<Integer> box1 = new Box<Integer>();
//		Box<Integer> box1 = new Box<>();			변수를 선언할때 생성자의 타입이 동일하면 생성자의 타입은 명시하지 않아도 된다
		box1.setValue(22);
		System.out.println(box1.getValue());
		
		Box<Robot> box2 = new Box<Robot>();
		box2.setValue(new Robot());
		Robot robot = box2.getValue();
		robot.move(Direction.EAST);
	}

}
