import java.util.Scanner;

/**
 * 알파벳을 찾아서 치환하는 프로그램
 * @author 홍재헌
 *
 */
public class StringRep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		String nowStr = "";
		String chaStr = "";
		int count = 0;
		System.out.print("문자열 입력 : ");
		str = sc.next();
		System.out.print("현재 문자열 입력 : ");
		nowStr = sc.next();
		System.out.print("바꿀 문자열 입력 : ");
		chaStr = sc.next();
		
		if (nowStr.length() == chaStr.length() && str.length() > chaStr.length()) {
			for (int i = 0; i < str.length()/chaStr.length(); i+=chaStr.length()) {
				str = str.toLowerCase().replace(nowStr, chaStr);
				count++;
			}
			System.out.println(str);
			System.out.println(count+"번 치환");
		} else {
			System.out.println("입력한 문자열의 크기가 작습니다.");
			System.out.println("치환 할 수 없습니다.");
		}
		sc.close();
	}

}

/*
[문제] 치환하는 프로그램을 작성하시오 - indexOf(?, ?), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다
*/