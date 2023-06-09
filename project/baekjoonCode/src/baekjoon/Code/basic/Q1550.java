package baekjoon.Code.basic;

import java.util.Scanner;
/**
 * 16진수를 10진수로 출력
 * @author 홍재헌
 *
 */
public class Q1550 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String data = in.next();
		int num = Integer.parseInt(data,16);
		System.out.println(num);
		in.close();
	}
}
