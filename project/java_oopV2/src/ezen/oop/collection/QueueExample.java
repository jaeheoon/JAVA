package ezen.oop.collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐
 * @author 홍재헌
 * 230522 수업
 */
public class QueueExample {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("AAA");
		queue.offer("BBB");
		queue.offer("CCC");
		queue.offer("DDD");
		
		while (!queue.isEmpty()) {			//stack에 !isEmpty(비어있지 않다면) 가져온다
			String str = queue.poll();		//poll()은 맨 위에 있던 것을 제거하면서 가져온다, 선입선출
//			String str = queue.peek();		//peek()는 제거하지 않고 가져온다, 잘 안씀
			System.out.println(str);
		}
		System.out.println(queue.size());
	}

}
