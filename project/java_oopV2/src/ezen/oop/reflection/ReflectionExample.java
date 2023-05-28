package ezen.oop.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * reflection(반사) 예시
 * @author 홍재헌
 * 230522 수업
 */
public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException {
//		String이 아닌 모르는 객체인지 모를때 사용하는 것, 지금은 예시로 String으로 적용
		String message = "리플렉션이 뭐지";
//		Integer message = new Integer(10);
		
//		Class 인스턴스를 취득하는 방법
//		Class cls = message.getClass();						// getClass로 사용
//		Class cls = Class.forName("java.lang.String");		// forName으로 사용, 대신 예외처리 해줘야함
		Class cls = String.class;							// .class로 사용, 간편하고 주로 쓰임
		
//		클래스 정보(메타) 분석
		Package pack = cls.getPackage();
		
		System.out.println(pack.getName());
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		
		Class sc = cls.getSuperclass();						// 현재 클래스의 부모 클래스 취득
		System.out.println(sc.getName());
		
		Constructor[] cons = cls.getConstructors();			//클래스의 생성자를 취득
		for (Constructor constructor : cons) {
			System.out.println(cons);
		}
		
		Field[] fields = cls.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());			//이름만 보여주는 것
			System.out.println(method);						//선언부까지 보여주는 것
		}
	}

}
