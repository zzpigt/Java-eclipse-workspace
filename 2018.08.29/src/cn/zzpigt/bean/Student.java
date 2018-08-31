package cn.zzpigt.bean;

public class Student {
	private String name;
	private Integer age;
	private Double height;
	private Boolean marriage;
	
	
	public Student(String name) {
		super();
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public Integer getAge() {
		return age;
	}


	public Double getHeight() {
		return height;
	}

	public Boolean isMarriage() {
		return marriage;
	}

	public Student(StudentBuilder sb) {
		this.name = sb.getName();
		this.age = sb.getAge();
		this.height = sb.getHeight();
		this.marriage = sb.isMarriage();
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", height=" + height + ", marriage=" + marriage + "]";
	}
	
	public static class StudentBuilder {
		private String name;
		private Integer age;
		private Double height;
		private Boolean marriage;
		
		
		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}

		public Double getHeight() {
			return height;
		}

		public Boolean isMarriage() {
			return marriage;
		}

		public StudentBuilder(String name) {
			super();
			this.name = name;
		}
		
		public StudentBuilder age(Integer age) {
			this.age = age;
			return this;
		}
		
		public StudentBuilder height(Double height) {
			this.height = height;
			return this;
		}
		
		public StudentBuilder marriage(Boolean marriage) {
			this.marriage = marriage;
			return this;
		}
		
		public Student builder() {
			return new Student(this);
		}
		
	}
	
}
