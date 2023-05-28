package ezen.oop.array;
/*
 * 특정 파일 이름을 전달받아 파일 내용을 콘솔창에 출력하는 예제
 * java FilePrint xxxx.txt
 * 
 * 이클립스에서는 아규먼츠(arguments)를 전달할 수 없기 때문에 기능이 있는데
 * 우클릭 후 Run As -> Run Configuration 클릭하면 창이 나오는데 이때 Arguments메뉴에서 첫번째에 전달할 인자를 써주면
 * 전달될 수 있다.
 */

public class FilePrint {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("사용법 : java FilePrint <파일명>");
			return;
		}
		String fileName = args[0];
		System.out.println("읽어들인 파일 이름: "+ fileName);
	}

}

