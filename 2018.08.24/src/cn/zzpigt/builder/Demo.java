package cn.zzpigt.builder;

public class Demo {
	public static void main(String[] args) {
		Student s = new Student.StudentBuilder(1, "tjw").age(25).married(true).hobby("√¿≈Æ").build();
		System.out.println(s.toString());
	}
}
