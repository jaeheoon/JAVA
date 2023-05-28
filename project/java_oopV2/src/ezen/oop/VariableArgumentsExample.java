package ezen.oop;
/**
 * java 5버전에 추가된 Variable arguments, 메소드 인자의 개수가 일정하지 않은 가변길이 인자
 * @author 홍재헌
 * 230518 수업
 */
public class VariableArgumentsExample {

	public static int sum(int x, int y) {
		return x + y;
	}
	
	public static int sum(int x, int y, int z) {			// 메소드 오버로딩, 3, 4, ... 이런식으로 추가될때마다 메소드도 추가해야하지만 Variable arguments을 사용하면 다 처리된다
		return x + y + z;
	}
	
	public static int sum(int[] nums) {						// Java 5버전 이전 방식, 배열을 통해 값을 더해준다
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return sum;
	}
	
	public static int sum2(int... nums) {					// Java 5버전 이후 방식, 가변인자를 통해 값을 더해준다
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		int result = sum(15, 30);
		System.out.println(result);
		
		result = sum(15, 30, 10);
		System.out.println(result);
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		result = sum(nums);
		System.out.println(result);
		
		
		result = sum2(2, 3, 4);								// 가변인자는 배열을 굳이 생성하지 않고 인자를 전달하듯이 안에 넣어주면 된다
		System.out.println(result);
		
//		표준API에 적용된 가변인자, printf/Formatter
		int x = 50, y = 30;
		System.out.printf("%1$-10d, %2$5d", x, y);
	}

}
