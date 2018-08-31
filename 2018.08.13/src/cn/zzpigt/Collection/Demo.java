package cn.zzpigt.Collection;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		//ArrayList()中的方法
		List<Integer> list = new ArrayList<>(3);
		
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		
		//调整底层数组的长度
		if(list instanceof ArrayList) {
			((ArrayList) list).trimToSize();
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
