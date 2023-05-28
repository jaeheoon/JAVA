package Test;

class T1{
	void t1() {
		System.out.println("T1 클래스의 t1 메소드 호출");
	}
}

public class Test extends T1{
	
	void t1() {
		System.out.println("t2메소드 호출");
	}
	
	public static void main(String[] args) {
		T1 t = new Test();
		t.t1();
		
	}

}
