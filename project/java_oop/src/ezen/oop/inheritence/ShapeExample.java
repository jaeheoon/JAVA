package ezen.oop.inheritence;
/**
 * 상속 관계 표현에 관련된 클래스 생성(어플리케이션 클래스)
 * @author 홍재헌
 *
 */
public class ShapeExample {

	public static void main(String[] args) {
		
//		Shape shape = new Shape(10, 10);  					//- 추상클래스로 만든 것이기 때문에 삭제
//		shape.draw();										//- 추상클래스로 만든 것이기 때문에 삭제
//		System.out.println(shape.getLength());
//		System.out.println(shape.getArea());
//		Object의 toString() 재사용
//		System.out.println(shape.toString());			
//		toString - 리턴을 String으로 해준다, 
		
//		추상클래스는 인스턴스 생성 안됨
//		그러나 데이터 타입으론 사용 가능하다(다형성 지원)
		Shape shape = new Circle(10, 10, 5);
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		System.out.println(shape.toString());	
		
		shape = new Lectangle(10, 10, 100, 50);
		shape.draw();
		System.out.println(shape.getLength());
		System.out.println(shape.getArea());
		System.out.println(shape.toString());	
//		참조변수를 출력하면 자동으로 Object의 toString() 메소드가 자동 호출된다.
//		주소값을 연산하지 못하게 하는 역할의 메소드
		
	}

}
