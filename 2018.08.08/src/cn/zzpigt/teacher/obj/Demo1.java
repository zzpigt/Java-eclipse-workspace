package cn.zzpigt.teacher.obj;

public class Demo1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		// clone ������ʹ��
		Student stu = new Student("����", 18);
		
		Student stu2 = (Student) stu.clone();
		
		System.out.println(stu2.getName());
		
	}
	
}

// ѧ����Ҳ��Object�������
class Student implements Cloneable{
	
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
		this.age = age;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}