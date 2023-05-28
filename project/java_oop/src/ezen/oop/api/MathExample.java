package ezen.oop.api;

public class MathExample {

	public static void main(String[] args) {
		double d = 69.4;
		System.out.println(Math.round(d));		//반올림
		System.out.println(Math.ceil(d));		//올림
		System.out.println(Math.floor(d));		//내림
		
		// 임의값 (0.0 <= random < 1.0)
		System.out.println(Math.random());
		
		// 0 ~ 9 범위의 임의의 값
		System.out.println((int)(Math.random()*10));
		
		// 로또 번호 (1 ~ 45범위의 6개)
		int[] num = new int[6];
		for (int x = 0; x < 10; x++) {
			for (int j = 0; j < 6; j++) {
				num[j] = (int)(Math.random()*45) + 1;
				for (int i = 0; i < num.length-1; i++) {
					if(num[i]==num[i+1]) {
						num[i+1] = (int)(Math.random()*45) + 1;
					}
				}
				System.out.print(num[j]+", ");
			}
			System.out.println();
		}
	}

}
