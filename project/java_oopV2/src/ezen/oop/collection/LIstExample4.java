package ezen.oop.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LIstExample4 {

	public static void main(String[] args) {
//		String[] list;
		List<String> list = new Vector<>();
		list.add("희영");
		list.add("소영");
		list.add("영호");
		list.add("승욱");
		System.out.println(list.size());
		
		list.add("기정");
		list.add("승욱");
		System.out.println(list.size());
		
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1));
		
		for (int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for (String name : list) {
			System.out.println(name);
		}
		
		Iterator<String> iter = list.iterator();
//		System.out.println(iter);
		while(iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		
		boolean exist = list.contains("영호");
		System.out.println(exist);
		
		boolean deleted = list.remove("기정");
		System.out.println(deleted);
		
		System.out.println(list.isEmpty());
		
		list.clear();
		System.out.println(list.size());
	}
}















