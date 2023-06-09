package baekjoon.Code.basic;

import java.util.Scanner;
/**
 * N찍기 반대로
 * @author 홍재헌
 *
 */
public class Q2742 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for (int i = 0; i < a; i++) {
			System.out.println(a-i);
		}
		in.close();
	}
}
