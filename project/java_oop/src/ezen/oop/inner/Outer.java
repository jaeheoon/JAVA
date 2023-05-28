package ezen.oop.inner;

public class Outer {
	int x;
	String message;
	
	public Outer() {}
	public Outer(int x, String meString) {
		this.x = x;
		this.message = meString;
	}
	
	public void doSome() {
		Inner inner = new Inner();
		inner.doTask();
		
//		생성해서도 접근 가능하고
		Inner2 inner2 = new Inner2();
		inner2.method1();
//		클래스로도 접근 가능하다
		Inner2.method2();
		
//		지역 클래스 정의, 바깥에선 접근 불가능하다
		class Local{
			int x;
//			static int y;	- 지역 클래스 안에서는 static이 사용 불가
			
			Local(int x){
				this.x = x;			// 지금의 this는 Local에 있는 int x를 말하는 것이고
				Outer.this.x = x; 	//이 this는 위에 Outer에 대한 int x를 말한다
			}
			
			public void doTask() {
				System.out.println("doTask() 메소드 실행됨.");
			}
		}
//		내부 지역클래스를 사용하는 이유는 메모리 효율을 위해 사용하고 종료되면 즉시 해지되기 때문에 주로 모바일 앱같은걸 개발할때 사용한다
		Local local = new Local(10);
		local.doTask();
	}
	
//	인스턴스 멤버 내부클래스
	public class Inner{
		int y;
//		내부클래스 안에서는 static 사용이 안된다
//		static int z;
		public Inner() {}
		public Inner(int y) {
			this.y = y;
		}
		public void doTask() {
			System.out.println("외부 클래스의 x값: "+x);
		}
	}
	
//	정적(Static) 멤버 내부 클래스
	static class Inner2{
		int z;
//		정적 멤버 내부클래스 안에서는 static 사용이 가능하다
		static int a;
		public Inner2() {
			z = 10;
		}
		
		public void method1() {
			System.out.println("method1() 실행됨.");
		}
		
		public static void method2() {
			System.out.println("method2() 실행됨.");
		}
	}
}
