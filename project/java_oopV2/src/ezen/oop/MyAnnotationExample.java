package ezen.oop;
/**
 * 애노테이션 정의 사용 예제
 * @author 홍재헌
 * 230519 수업
 */
@MyAnnotation(value = "String타입", num = 100, tools = {"tools는", "배열로", "저장"}, direction = Direction.EAST)	//num은 디폴트 값이 있기 때문에 생략 가능함, 따로 값을 저장해줄때만 추가
public class MyAnnotationExample {

	public static void main(String[] args) {
//		Reflection API를 이용하여 애노테이션 정보 읽어들이기(나중에)
		
		
		
		
	}

}
