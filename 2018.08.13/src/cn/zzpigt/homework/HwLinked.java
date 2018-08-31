package cn.zzpigt.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class HwLinked {
	public static void main(String[] args) {
		// 1. 创建一个LinkedList对象lList，分别将“JavaSE”、“JavaME”、“JavaEE”添加到lList中
		LinkedList<Object> lList = new LinkedList<>();
		lList.add("JavaSE");
		lList.add("JavaME");
		lList.add("JavaEE");
		
		// 2. 遍历lList分别取出其元素将其输出
		for (Object o : lList) {
			System.out.println(o);
		}
		
		// 3. 直接取出该lList的首个和最后一个元素并输出
		System.out.println("第一个："+lList.getFirst());
		System.out.println("最后一个："+lList.getLast());
		
		// 4. 将“JDK”添加到lList的开头
		lList.addFirst("JDK");
		
		// 5. 创建一个LinkedList对象lList_2，分别将“HTML”、“XML”、“JSON”添加到lList_2中
		LinkedList<String> lList_2 = new LinkedList<>();
		lList_2.add("HTML");
		lList_2.add("XML");
		lList_2.add("JSON");
		
		
		// 6. 将lList_2添加到lList中索引为2的位置
		lList.add(2, lList_2);
		
		for (Object object : lList) {
			System.out.println(object);
		}
		
		// 7. 分别判断lList和lList_2是否含有“JavaSE”这个元素
		System.out.println("lList是否含有“JavaSE”这个元素:"+lList.contains("JavaSE"));
		System.out.println("lList_2是否含有“JavaSE”这个元素:"+lList_2.contains("JavaSE"));
		
		// 8. 获取lList的逆向迭代器，并通过该迭代器分别取出lList中的元素进行输出
		Collections.reverse(lList);
		System.out.println(" 获取lList的逆向迭代器======================");
		for (Iterator iterator = lList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
		
		// 9. 获取lList的顺序迭代器，并通过该迭代器分别取出lList中的元素输出
		Collections.sort(lList_2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}else if(o1.length() < o2.length()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		for (String string : lList_2) {
			System.out.println("获取lList的顺序迭代器，并通过该迭代器分别取出lList中的元素输出"+string);
		}
		
		// 10. 取出但不移除列表第一个和最后一个元素，并将所有元素输出
		System.out.println("取出但不移除列表第一个和最后一个元素，并将所有元素输出:");
		
		System.out.println(lList.getFirst());
		System.out.println(lList.getLast());
		
		
		
		for (Object o : lList) {
			System.out.println(o);
		}
		
		// 11. 取出并移除第一个和最后一个元素，并将所有元素输出
		System.out.println(lList.removeFirst());
		System.out.println(lList.removeLast());
		// 12. 从列表中弹出一个元素，并输出该元素
		Collections.shuffle(lList_2);
		System.out.println("随机弹出一个元素："+lList_2.getFirst());
		
		// 13. 把“Android”推入此列表
		lList_2.addFirst("Android");
	}
}
