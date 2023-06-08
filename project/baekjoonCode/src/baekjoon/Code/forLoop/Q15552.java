package baekjoon.Code.forLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15552 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] strs = br.readLine().split(" ");
			int a = Integer.valueOf(strs[0]);
			int b = Integer.valueOf(strs[1]);
			bw.write(a+b+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
