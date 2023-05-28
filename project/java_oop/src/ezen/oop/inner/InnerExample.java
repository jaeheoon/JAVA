package ezen.oop.inner;

public class InnerExample {

	public static void main(String[] args) {
//		바깥에 있는 클래스를 생성하였더니 내부에 있는 메소드가 호출된 모습
		Outer outer = new Outer(5, "내부클래스");
		outer.doSome();
		System.out.println(outer.x);
		
//		인스턴스 내부클래스를 사용하는 방법 - 바깥에서도 사용할 순 있지만 복잡하고 잘 사용하지 않음
		Outer.Inner inner = new Outer().new Inner();
		inner.doTask();
		
//		static 멤버 내부클래스 생성방법, static으로 생성돼서 바로 클래스 이름으로 접근함, 위에는 static으로 생성되지 않아서 Outer도 생성하고 Inner도 생성한 모습
		Outer.Inner2 inner2 = new Outer.Inner2();
		inner2.method1();
		
	}

}
