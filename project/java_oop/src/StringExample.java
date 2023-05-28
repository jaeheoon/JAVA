/*
 * String 메소드의 다양한 종류 예제
 */
public class StringExample {

	public static void main(String[] args) {
		String messege1 = new String("Java King~");
		String messege2 = new String("Java King~");
		System.out.println(messege1 == messege2);
		System.out.println(messege1.equals(messege2));
		
		String messege3 = "Java King~";
		String messege4 = "java King~";
		System.out.println(messege3.equals(messege4));
		System.out.println(messege3.equalsIgnoreCase(messege4));
		System.out.println(messege3.equals(messege1));
		
		char[] chars = {'j', 'a', 'v', 'a'};
		String str = new String(chars);
		System.out.println(str);
	}

}
