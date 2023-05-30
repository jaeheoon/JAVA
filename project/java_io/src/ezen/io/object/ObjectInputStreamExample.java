package ezen.io.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
/**
 * 역직렬화 예제
 * @author 홍재헌
 * 230530 수업
 */
public class ObjectInputStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Student student = null;
		String message = null;
		int age = 0;
		List<Student> List = null;
		
		String fileName = "students.ser";
		
		ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));
		// 파일의 연속적인 바이트 흐름 -> 메모리상의 Obejct 변환 (역직렬화)
		student = (Student) in.readObject();
		message = (String) in.readObject();
		age = (int) in.readObject(); // UnBoxing 적용
		List = (List<Student>)in.readObject();
		System.out.println(student.toString());
		System.out.println(student.passwd);
		System.out.println(message);
		System.out.println(age);
		
		for (Student stu : List) {
			System.out.println(stu);
		}
		in.close();
	}

}



