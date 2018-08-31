package cn.zzpigt.teacher.obj;

public class Demo2 {

	// equals 
	public static void main(String[] args) {
		
		Dog d1 = new Dog("����", 2);
		Dog d2 = new Dog("����", 2);
		
		System.out.println(d1 == d2);		// false
		System.out.println(d1.equals(d1));	// true
	}
	
}

// ��дequals������Ҫ�����ֺ����䶼��ͬʱ������true����Ȼfalse

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
		// �Է���
		if(this == obj)
			return true;
		// �ǿ���
		if(obj == null)
			return false;
		
		// ����֤����
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