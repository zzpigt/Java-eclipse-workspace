package cn.zzpigt.bean;

public class Student extends Person{
	
	private String name;
	public int age;
	public static int count;

	
	public String getName() {
		return name;
	}


	public Student() {
		
	}
	
	
	public Student(int i) {
		this.age = i;
	}
	
	protected Student(int i,String str) {
		this.age = i;
		this.name= str;
	}

	public void talk() {
		System.out.println("sddsadfasdf");
	}
	
	private void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public int mul(int a,int b) {
		System.out.println(a*b);
		return a*b;
	}

	public static void hw1 () {
		System.out.println("��̬�����ķ���");
	}
	
	private static void phw1(int i) {
		System.out.println("��̬˽�еķ���");
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
