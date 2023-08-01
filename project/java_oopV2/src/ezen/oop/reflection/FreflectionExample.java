package ezen.oop.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FreflectionExample {

	public static void main(String[] args) throws ClassNotFoundException {
		String message = "리플렉션이 뭐야...";
//		Integer message = new Integer(10);

//		Class 인스턴스를 취득하는 방법
//		Class cls = message.getClass();
//		Class cls = Class.forName("java.lang.String");
		Class cls = String.class;
//		클래스 정보(메타) 분석
		Package pack = cls.getPackage();
		System.out.println(pack.getName());
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		
		Class sc =  cls.getSuperclass();
		System.out.println(sc.getName());
		
		Constructor[] cons = cls.getConstructors();
		for (Constructor constructor : cons) {
			System.out.println(cons);
		}
		
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
//			System.out.println(method.getName());
			System.out.println(method);
		}
		
		Field[] fieds = cls.getFields();

	}

}
