package cn.zzpigt.Demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo4 {
	public static void main(String[] args) {
		
		Map<String,Person> map = new HashMap<>();

		map.put("sb1", new Person("huang", 24));
		map.put("sb2", new Person("hui", 24));
		map.put("sb3", new Person("xiang", 24));
		
		System.out.println(map.size());
		
//		Set<Entry<String, Person>> entrySet = map.entrySet();
//		for (Entry<String, Person> entry : entrySet) {
//			System.out.println(entry.getKey()+"---"+entry.getValue());
//		}
		
//		Iterator<Entry<String, Person>> iterator = map.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Entry<String, Person> next = iterator.next();
//			System.out.println(next.getKey()+"---"+next.getValue());
//		}
		
		Collection<Person> values = map.values();
		for (Person value : values) {
			System.out.println(value+"  ");
		}
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key+"  ");
		}
//		System.out.println(map.containsKey("sb1"));
//		System.out.println(map.containsValue(new Person("hui", 24)));
//		
//		System.out.println(map);
//		System.out.println(map.get("sb1"));
	}
}

class Person{
	
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
