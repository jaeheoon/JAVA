package ezen.oop.array;
/*
 * 성적 관리 어플
 */

public class ScroreApp {

	public static void main(String[] args) {
//		Student student = new Student(1, 90, "홍재헌");
//		student.pringInfo();
		
//		참조타입 배열 선언, 생성, 초기화
		Student[] students;				//선언
		students = new Student[27];		//생성
		students[0] = new Student(1, 90, "홍재헌");
		// ...
		students[26] = new Student(27, 57, "김기정");
		
		for (int i = 0; i < students.length; i++) {
			if(students[i]!=null) {			//이것이 없을 경우 null Exception 오류가 생성된다 ? 중간 값들은 비어있기 때문에 값을 출력할 수 없기 때문에 오류가 나옴
			students[i].pringInfo();
			}
		}
		
		
		
	}

}
