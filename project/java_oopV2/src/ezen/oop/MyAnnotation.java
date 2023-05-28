package ezen.oop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 사용자 정의 애노테이션
 * @author 홍재헌
 * 230519 수업
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})	//타겟을 이용해서 애노테이션을 타입, 필드, 메소드에서 사용할 수 있다(추가나 삭제 가능)
@Retention(value = RetentionPolicy.RUNTIME)									//value 쓰는 것은 생략할 수 있지만 쓰는 것이 좋다
@Documented																	//@Documented는 마킹 애노테이션이다, Javadoc으로 생성된 HTML에 포함시키기 위해 사용된다, 잘 사용안함
public @interface MyAnnotation {
	String value();
	int num() default 1;		//디폴트값 1을 준 것, 나머진 안줌
	String[] tools();
	Direction direction();
}
