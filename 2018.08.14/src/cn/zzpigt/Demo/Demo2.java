package cn.zzpigt.Demo;

import java.util.HashSet;
import java.util.Set;

public class Demo2 {
	public static void main(String[] args) {
		
		
		//��ϣ������һ�����飬������ÿ��Ԫ�ض���һ������ÿ�������Ԫ�ض�Ҫ����hashֵ����ͨ��
		//һ������������õ�һ��ֵ�����ֵ�������Ԫ�ش�ŵ�λ��
		//�ж�����Ԫ���Ƿ���ͬһ��Ԫ�أ��������ж����ǵ�hashֵ�Ƿ���ȣ����ж�equals�Ƿ����
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