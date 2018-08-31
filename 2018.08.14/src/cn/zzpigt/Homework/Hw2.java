package cn.zzpigt.Homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hw2 {
	public static void main(String[] args) {
//		1. 创建HashMap的对象map，往里边添加2个键值对，分别是（name-”张三”）、(age-23)，判断height是否为map的一个key
		Map<String,String> map = new HashMap<>();
		map.put("name", "张三");
		map.put("age", "23");
		
		System.out.println("height是否为map的一个key:"+map.containsKey("heigth"));
		
//		2. 判断”张三”这个值是否在该map中
		System.out.println("”张三”这个值是否在该map中:"+map.containsValue("张三"));
		
//		3. 分别通过name和age两个key取出其值
		System.out.println("通过name:"+map.get("name"));
		System.out.println("通过age:"+map.get("age"));
//		4. 获取map中所有key组成的Set
		System.out.println("获取map中所有key组成的Set:");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.print(key+"  ");
		}
		System.out.println();
//		5. 获取map中所有映射关系组成Set
		System.out.println("获取map中所有映射关系组成Set:");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
//		6. 获取map中所有的值组成的Collection对象
		System.out.println("获取map中所有的值组成的Collection对象:");
		Collection<String> values = map.values();
		for (String value : values) {
			System.out.print(value+"  ");
		}
		System.out.println();
		
//		7. 使用name这个key通过get方法获取其名字
		System.out.println("使用name这个key通过get方法获取其名字:"+map.get("name"));
		
//		8. 移除age这个key
		System.out.println(" 移除age这个key:"+map.remove("age"));
		
//		9. 移除所有的映射关系
		map.clear();
		System.out.println(map.size());
		
	}
	public void name() {
		
	}
}
