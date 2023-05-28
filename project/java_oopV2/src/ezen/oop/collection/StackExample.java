package ezen.oop.collection;

import java.util.Stack;

/**
 * 스택
 * @author 홍재헌
 * 230522 수업
 */
public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("AAA");
		stack.push("BBB");
		stack.push("CCC");
		stack.push("DDD");
//		for (String string : stack) {
//			System.out.println(string);
//		}
		while (!stack.isEmpty()) {			//stack에 !isEmpty(비어있지 않다면) 가져온다
			String str = stack.pop();		//pop()은 맨 위에 있던 것을 제거하면서 가져온다, 후입선출
//			String str = stack.peek();		//peek()는 제거하지 않고 가져온다, 잘 안씀
			System.out.println(str);
		}
		System.out.println(stack.size());
	}

}
