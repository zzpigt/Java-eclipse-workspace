package cn.zzpigt.obj;

public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student stu = new Student("tongjinwen",18);
		Student stuC = (Student)stu.clone();
		System.out.println(stuC.getName());
	}
}


class Student implements Cloneable{
	
	private String name;
	private int age;
	
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
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
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
}