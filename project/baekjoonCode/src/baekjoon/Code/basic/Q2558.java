package baekjoon.Code.basic;

import java.util.Scanner;
/**
 * 간단한 A+B 출력
 * @author 홍재헌
 *
 */
public class Q2558 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int sum = a+b;
		System.out.println(sum);
		in.close();
	}
}
