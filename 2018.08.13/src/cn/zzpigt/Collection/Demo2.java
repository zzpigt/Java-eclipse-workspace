package cn.zzpigt.Collection;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(7);
		list.add(8);
		list.add(9);

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				// Integer temp = list.get(j);
				// list.set(j, list.get(j+1));
				// list.set(j+1, list.set(j, list.get(j+1)));
				if(list.get(j)>list.get(j+1)) {
					Collections.swap(list, j, j+1);
				}
			}
		}
//		Collections.sort(list);
		Collections.reverse(list);
		
		//Ëæ»ú´òÂÒ
		Collections.shuffle(list);
		
		System.out.println(list);
		
		
		/*for (Integer integer : list) {
			System.out.println(integer);
		}*/

		
	}
}
