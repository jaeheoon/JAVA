package ezen.oop.api;

public class StringBufferExample {

	public static void main(String[] args) {
//		StringBuffer: String 클래스의 단점을 보완하여 자체 편집이 가능한 문자열 처리와 관련된 기능을 제공
//		append는 뒤에 추가해주는 메소드이다. 리턴 타입은 StringBuffer이다, 
//		즉 원래 있던 문자열을 계속해서 추가하는 것이 아닌 기존에 있던 문자열을 수정하는 방식이다
		StringBuffer sb = new StringBuffer("Java");
		sb.append("!");
		sb.append("!").append(0).append(0);		//코드체이닝 방식 사용 가능, 코드를 추가하는 것이 아닌 수정하는 것이기 때문에 사용 가능하다
		System.out.println(sb);
		
//		insert(int offset, String string): 정해진 위치에 string으로 주어진 문자열 추가
//		String toString(): 스트링버퍼에 저장된 내용을 문자열로 반환
//		StringBuffer delete(int start, int end): start ~ (end-1) 인덱스의 문자열을 삭제
//		StringBuffer deleteCharAt(int index): 주어진 인덱스의 문자를 삭제
//		StringBuffer replace(int start, int end, String string): start ~ (end-1) 위치의 문자열을 삭제하고, 주어진 문자열을 대체
//		StringBuffer reverse(): 문자열의 순서를 뒤집는다
		
		sb.insert(4, '-');
		System.out.println(sb);
	}

}
