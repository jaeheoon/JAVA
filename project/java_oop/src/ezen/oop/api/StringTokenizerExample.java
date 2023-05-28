package ezen.oop.api;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
//		StringTokenizer: 하나의 문자열을 구분자(delimiter)를 기준으로 여러 개의 문자열로 분리하는데 사용하는 유틸리티 클래스
//		나누는 단위가 되는 문자열을 토큰(Token)이라 한다
		String cardNumber = "1111-2222-3333-4444";
		StringTokenizer st = new StringTokenizer(cardNumber, "-");
		
//		토큰의 갯수를 반환
		System.out.println(st.countTokens());
		
//		hasMoreTokens: 토큰을 가지고 있는지
//		nextToken: 토큰을 반환해주는 것
//		밑에 함수는 토큰을 가지고 있으면 계속해서 출력해주는 함수
		String[] tokens = new String[st.countTokens()];
		int index = 0;
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
			tokens[index++] = token;
		}
		System.out.println(tokens.length);
		System.out.println(tokens[0]);
	}

}
