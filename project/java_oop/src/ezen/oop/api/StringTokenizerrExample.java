package ezen.oop.api;

import java.util.StringTokenizer;

public class StringTokenizerrExample {

	public static void main(String[] args) {
		String cardNumber = "1111-2222-3333-4444";
		StringTokenizer st = new StringTokenizer(cardNumber, "-");
		System.out.println(st.countTokens());
		String[] tokens = new String[st.countTokens()];
		int index = 0;
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
			tokens[index++] = token;
		}
		System.out.println(tokens.length);
		System.out.println(tokens[0]);
	}

}
