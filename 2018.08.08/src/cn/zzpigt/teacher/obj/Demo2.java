package cn.zzpigt.teacher.obj;

public class Demo2 {

	// equals 
	public static void main(String[] args) {
		
		Dog d1 = new Dog("旺财", 2);
		Dog d2 = new Dog("旺财", 2);
		
		System.out.println(d1 == d2);		// false
		System.out.println(d1.equals(d1));	// true
	}
	
}

// 重写equals方法，要求当名字和年龄都相同时，返回true，不然false

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
	public boolean equals(Object obj) {
		// 自反性
		if(this == obj)
			return true;
		// 非空性
		if(obj == null)
			return false;
		
		// 先验证类型
		if(obj instanceof Dog) {
			Dog other = (Dog) obj;
			if(this.getName().equals(other.getName()) && this.getAge() == other.getAge()) {
				return true;
			}
		} 
		
		return super.equals(obj);
	}
	
	
	@Override
	public int hashCode() {
		return getName().hashCode() + getAge();
	}
	
}