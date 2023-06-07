package ezen.oop.lambda;

public class LambdaExample {

	public static void main(String[] args) {
		SomeDo someDo = new SomeDo();
		
		// 익명객체 전달
		someDo.action(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				System.out.println("두수의 합: " + (x + y));				
			}
		});
		
		
		
		// 어떤 람다식을 전달인자로 제공하느냐에 따라 결과값이 달라질 수 있다.
		// 람다식 전달
		someDo.action((x, y) -> {
			System.out.println("두수의 곱: " + (x * y));
		});
		
		// 람다식 전달
		someDo.action((x, y) -> {
			System.out.println("두수의 나눗셈: " + (x / y));
		});
		
		someDo.action((x, y) -> {
			System.out.println(Math.pow(x, y));
		});
		
		someDo.action2((x, y)-> { return x + y;} );		//두 실행 결과값이 똑같다
		someDo.action2((x, y)-> x + y );
		someDo.action3( x -> (int)Math.pow(x, 3) );
		
		
		

	}

}
