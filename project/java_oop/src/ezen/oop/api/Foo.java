package ezen.oop.api;
/**
 * 싱글톤(Singleton) 패턴 적용 클래스
 * @author 홍재헌
 *
 */
public class Foo {
	private String name = "김기정";
	private static Foo instance = new Foo();
	private Foo() {}
	
	public static Foo getInstance() {
		return instance;
	}
	public String getName() {
		return name;
	}
}
