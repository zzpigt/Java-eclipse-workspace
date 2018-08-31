package cn.zzpigt.Demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		set.add(1);
		set.add(false);
		set.add(false);
		set.add(false);
		set.add("adf");
		set.add(Integer.valueOf(4));
		set.add(4);
//		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//			System.out.println(object);
//		}
		
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
