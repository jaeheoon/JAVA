package ezen.oop;
/**
 * 제너릭 타입 정의
 * @author 홍재헌
 * 230518 수업
 * @param <T>
 */
public class Box <T>{
	private T value;
	
	public Box(){};
	public Box(T value){
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
}
