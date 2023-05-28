package ezen.oop.api;

import java.util.Calendar;

public class FooExample {

	public static void main(String[] args) {
//		Foo foo = new Foo();
		Foo foo = Foo.getInstance();
		Foo foo2 = Foo.getInstance();
		System.out.println(foo == foo2);
		foo.getName();
//		Calendar calendar = new Calendar();
	}

}
