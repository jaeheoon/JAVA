package ezen.oop;
/**
 * 열거형을 사용해 Robot 움직임 구현
 * @author 홍재헌
 * 230518 수업
 */
public class Robot {
	public void move(Direction direction) {
		switch (direction) {
		case EAST: System.out.println("동쪽으로 이동"); break;
		case WEST: System.out.println("서쪽으로 이동"); break;
		case SOUTH: System.out.println("남쪽으로 이동"); break;
		case NORTH: System.out.println("북쪽으로 이동"); break;
		}
		
		
	}
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.move(Direction.EAST);
		robot.move(Direction.WEST);
		robot.move(Direction.SOUTH);
		robot.move(Direction.NORTH);
		
//		열거형 목록
		Direction[] directions =  Direction.values();
		for (Direction direction : directions) {
			System.out.println(direction);
			System.out.println(direction.getValue());		//한글로 추가
		}
		
//		해당 열거형 객체 검색
		Direction direction = Direction.valueOf("SOUTH");
		System.out.println(direction);
		
//		열거형의 순서 나타내고, 이름 나타내는 함수
		System.out.println(direction.ordinal());
		System.out.println(direction.name());
		
//		enum은 생성자 호출로 생성할 수 없다. ? enum 내부에서 private으로 생성되어있기 때문에
//		Direction d = new Direction();
		
	}
}
