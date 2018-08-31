package cn.zzpigt.Homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Hw {
	public static void main(String[] args) {
		
//		1. 创建一个HashSet对象hs，将”Hello”,5,2,”World”,”Java”,”Hello”分别添加到hs中，并使用迭代方式将所有元素输出，看看有无重复元素
		Set hs = new HashSet();
		
		hs.add("Hello");
		hs.add(5);
		hs.add(2);
		hs.add("World");
		hs.add("Java");
		hs.add("Hello");
		
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
		}
//		4. 将”Java”移除，查看hs的长度
		hs.remove("Java");
		System.out.println("将”Java”移除，查看hs的长度:"+hs.size());
		
//		2. 清空hs中的元素，查看元素是否为空，随机产生20个1到100之间的整数，分别添加到hs中，查看hs的长度为多少，并使用迭代的方式把所有元素输出
		hs.clear();
		System.out.println("清空hs中的元素，查看元素是否为空:"+hs.isEmpty());
		
		for(int i=0;i<20;i++) {
			int num = new Random().nextInt(100)+1;
			hs.add(num);
		}
		System.out.println("随机产生20个1到100之间的整数，分别添加到hs中，查看hs的长度为多少");
		System.out.println(hs.size());
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
//		3. 查看hs中是否有元素”JavaSE”
		System.out.println("查看hs中是否有元素”JavaSE");
		System.out.println(hs.contains("JavaSE"));
		
		

		
		
	}
}
