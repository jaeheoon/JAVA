package baekjoon.Code.forLoop;
/**
 * N찍기
 */
import java.util.Scanner;

public class Q2741 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		for (int i = 1; i <= a; i++) {
			System.out.println(i);
		}
		in.close();
	}
}
