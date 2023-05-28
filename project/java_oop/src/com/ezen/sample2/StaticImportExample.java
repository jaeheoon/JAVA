package com.ezen.sample2;

import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImportExample {

	public static void main(String[] args) {
		
		System.out.println("스태틱 임포트");
		System.out.println("스태틱 임포트");
		System.out.println("스태틱 임포트");
		System.out.println("스태틱 임포트");
		System.out.println(Math.abs(-10));
		
		
		out.println("이렇게 하면 안됩니다");
		out.println(abs(-10));
	}

}
