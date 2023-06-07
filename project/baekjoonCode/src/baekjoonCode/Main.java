package baekjoonCode;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			int a = in.nextInt();
			int b = in.nextInt();
			if (a != 0 && b != 0) {
				System.out.println(a+b);
			}
		}
		
		
	}
}
