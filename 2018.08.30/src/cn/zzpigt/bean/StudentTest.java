package cn.zzpigt.bean;

public class StudentTest {

	private String name;
	public int age;
	public Dog dog;
	
	public StudentTest(String name, int age, Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.dog = dog;
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
	
	
	
	
}


