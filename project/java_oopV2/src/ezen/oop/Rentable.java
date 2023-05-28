package ezen.oop;
/**
 * 제네릭 타입의 인터페이스
 * 애노테이션
 * @author 홍재헌
 * 230518 수업
 * 230519 애노테이션 람다식 관련 추가 수업
 */

@FunctionalInterface		//람다식 함수 컴파일 오류 예방 차원으로 사용, 추상메소드는 반드시 하나만 존재해야한다
public interface Rentable <P>{
	public P rent();
	
//	public void x();		// 추가하면 컴파일 오류가 나온다
}
