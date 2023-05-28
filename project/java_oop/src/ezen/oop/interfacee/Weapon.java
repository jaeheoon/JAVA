package ezen.oop.interfacee;
/**
 * 유닛이 사용하는 모든 무기들에 대한 역할(명세/스펙)을 정의
 * 인터페이스도 하나의 데이터 타입이다
 * 인터페이스는 100% 추상메소드를로만 구성된다. 즉, 구현되어있는 것이 없다
 * @author 홍재헌
 *
 */
/*public*/ interface Weapon {
//	interface는 앞에 생성제한자를 빼면 자동으로 public으로 생성된다
	
//	모든 무기는 1키로고 공격을 한다라는 것을 코드로 구현
	/*public static final*/ int WEIGHT = 1;					//앞에 public static final을 생략하더라도 자동으로 생성된다.
	/*public abstract*/ void attack();						//앞에 생성제한자를 생략하더라도 컴파일 시 자동 생성된다
//	하지만 보통 명시적으로 다 붙여줌, 생략 가능하다는 것을 보여준 것
}
