package cn.zzpigt.teacher.obj;

public class Demo5 {

	public static void main(String[] args) {
		
		Bird b = new Bird("mike", 3);
		
		String str = b.toString();
		
		System.out.println(str);
		// ֱ�Ӵ�ӡһ��������ʵ�����ڴ�ӡ����toString�����Ľ��
		System.out.println(b);
		
	}
	
}


class Bird{
	
	private String name;
	private int age;
	
	public Bird(String name, int age) {
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
		return "Bird [name=" + name + ", age=" + age + "]";
	}
	
	
}


