package ezen.oop.inheritence;
/**
 * 상속 관계 표현에 관련된 클래스 생성(부모클래스)
 * +추상클래스
 * @author 홍재헌
 *
 */
//추상클래스
public abstract class Shape {
	protected double x;
	protected double y;
	
//	추상메소드
	public abstract void draw();
	public abstract double getLength();
	public abstract double getArea();
	
//	toString을 재정의하지 않으면 주소값으로 출력되지만 밑에 toString을 재정의하면 의미있는 값으로 바뀐다
//	재정의하지 않으면 ezen.oop.inheritence.Lectangle@53bd815b이러한 값이 나오는데 재정의를 하고 실행하면
//	Shape [x=10.0, y=10.0] 이러한 값으로 나온다, 따라서 상속을 사용하면 toString을 재정의 해줘야함
//	왜냐하면 toString을 사용하면 의미없는(버츄얼머신이 사용하는 주소값을 출력하기 때문) 값이 나오기 때문에
//	따라서 필드에 있는 toString 값을 오버라이딩 해줘야함
	
	
}
