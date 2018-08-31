package cn.zzpigt.Demo;

import java.util.HashSet;
import java.util.Set;

public class Demo2 {
	public static void main(String[] args) {
		
		
		//哈希表，就是一组数组，而数组每个元素都是一个链表，每个加入的元素都要计算hash值，再通过
		//一个函数的运算得到一个值，这个值就是这个元素存放的位置
		//判断两个元素是否是同一个元素，就是先判断他们的hash值是否相等，再判断equals是否相等
		Set<Dog> dSet = new HashSet<>();
		
		dSet.add(new Dog("mike",3));
		dSet.add(new Dog("mike",3));
		dSet.add(new Dog("Keti",2));
		dSet.add(new Dog("Tom",4));
		
		
		for (Dog dog : dSet) {
			System.out.println(dog);
		}
		
		
	}
}

class Dog{
	
	private String name;
	private int age;
	
	
	public Dog(String name, int age) {
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
		return "Dog [name=" + name + ", age=" + age + "]";
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
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}