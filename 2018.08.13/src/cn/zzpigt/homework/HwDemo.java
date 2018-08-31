package cn.zzpigt.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HwDemo {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();//栈，先进后出
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.search("a"));
		System.out.println("=============================");
		for (Iterator iterator = stack.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		
		//队列
		Queue<String> list = new LinkedList<>();
		
		list.add("asd");
		list.add("fgh");
		list.add("jk");
		
		list.offer("cv");
		System.out.println(list.poll());
		System.out.println(list.element());
		System.out.println("=============================");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
