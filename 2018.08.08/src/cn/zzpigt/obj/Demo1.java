package cn.zzpigt.obj;


//重写equals

public class Demo1 {
	public static void main(String[] args) {
		Dog d1 = new Dog("jake",1);
		Dog d2 = d1;
		Dog d3 = d2;
		System.out.println(d1.equals(d1));
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(d3));
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
	
	/*@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		
		//验证类型
		if(obj instanceof Dog) {
			Dog dog = (Dog)obj;
			if(this.getName().equals(dog.getName()) && this.getAge()==dog.getAge()) {
				return true;
			}
			return false;
		}else {
			return false;
		}
	}*/
	
	
	
	
}