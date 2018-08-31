package cn.zzpigt.exception;

public class Demo4 {
	public static void main(String[] args) {
		Student stu = new Student("tongjinwen",23);
		
		stu.setAge(-23);
		System.out.println(stu);
	}
}

class Student{
	
	private String name;
	private int age;
	
	
	
	
	public Student(String name, int age) {
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
		
		if(age<0) {
			throw new AgeNotRightException();
		}
		
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}

class AgeNotRightException extends RuntimeException{
	public AgeNotRightException() {
		super("年龄不正确！！！");
	}
}