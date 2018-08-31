package cn.zzpigt.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test7 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 6);
		
		//只要K
//		Set<String> keyset = map.keySet();
//		for (String key : keyset) {
//			System.out.println(key));
//		}
//		
//		
//		//只要V
//		Collection<Integer> values = map.values();
//		for (Integer value : values) {
//			System.out.println(value);
//		}
		
		//迭代遍历
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
		
//		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Entry<String, Integer> next = iterator.next();
//			System.out.println(next.getKey()+"---"+next.getValue());
//		}
	}
}
