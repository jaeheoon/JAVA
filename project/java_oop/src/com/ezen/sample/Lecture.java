package com.ezen.sample;

public class Lecture {
	String name;
	
	public Lecture(){}
	
	public Lecture(String name){
		this.name = name;
	}
	
	public void printName() {
		System.out.println("과목명: " + name);
	}
	
}
