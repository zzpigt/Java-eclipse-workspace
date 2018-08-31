package cn.zzpigt.obj;

public class Demo3 {
	public static void main(String[] args) {
		Bird b1 = new Bird("mike",3);
		String str = b1.toString();
		
		System.out.println(b1);
		System.out.println(str);
		
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
	
	/*@Override
	public String toString() {
			return "name:"+this.name+"  age:"+this.age;
	}
	*/
	
	
	
}