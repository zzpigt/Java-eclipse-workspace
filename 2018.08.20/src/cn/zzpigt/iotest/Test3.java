package cn.zzpigt.iotest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		Map<String,Integer> m1 = new HashMap<>();
		
		m1.put("a", 1);
		m1.put("b", 2);
		m1.put("c", 3);
		m1.put("d", 4);
		
		Set<Entry<String, Integer>> entrySet = m1.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
		
		
		Set<String> keySet = m1.keySet();
		for (String key : keySet) {
			System.out.println(key+"--"+m1.get(key));
		}
		
		for(int i=0;i<m1.size();i++) {
//			System.out.println(m1.);
		}
		
		
	}
}
