package cn.zzpigt.Demo;

import java.util.Set;
import java.util.TreeSet;

public class Demo3 {
	public static void main(String[] args) {
		Set tset = new TreeSet();
		
//		tset.add(5);
//		tset.add(3);
//		tset.add(4);
//		tset.add(1);
//		tset.add(2);
//		tset.add(2);
//		tset.add(2);
		
		//Tree�ṹ���ǽ���һ��������һ������������Ƚϣ���Ļ�����������ұߣ�С�Ļ�������������
		//������������Ļ���������һ�������Ƚϵ���comparaTo()
		
		tset.add(new Cat("Kite",3));
		tset.add(new Cat("Tom",3));
		tset.add(new Cat("Mike",3));
		
		
		for (Object object : tset) {
			System.out.println(object);
		}
	}
}


class Cat implements Comparable<Cat>{
	
	private String name;
	private int age;
	
	
	
	public Cat(String name, int age) {
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
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}



	@Override
	public int compareTo(Cat o) {
		return this.getName().compareTo(o.getName());
	}
	
	
}
