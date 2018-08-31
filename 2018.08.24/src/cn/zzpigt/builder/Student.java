package cn.zzpigt.builder;

public class Student {
	private int ID;
	private String name;
	private int age;
	private boolean married;
	private String hobby;
	

	public Student(StudentBuilder sb) {
		
		this.ID = sb.ID;
		this.name = sb.name;
		this.age = sb.age;
		this.married = sb.married;
		this.hobby = sb.hobby;
		
		
	}

	
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", age=" + age + ", married=" + married + ", hobby=" + hobby
				+ "]";
	}
	

	public static class StudentBuilder{
		
		private int ID;
		private String name;
		private int age;
		private boolean married;
		private String hobby;
		
		
		public StudentBuilder(int iD, String name) {
			super();
			ID = iD;
			this.name = name;
		}
		
		public StudentBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public StudentBuilder married(boolean married) {
			this.married = married;
			return this;
		}
		
		public StudentBuilder hobby(String hobby) {
			this.hobby = hobby;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
		
	}
	
	
}
