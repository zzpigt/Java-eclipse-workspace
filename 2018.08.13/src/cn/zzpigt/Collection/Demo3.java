package cn.zzpigt.Collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Demo3 {
	public static void main(String[] args) {
		//排序
		
		List<Student> list = new LinkedList<>();
		
		list.add(new Student("astu1",14,56.2));
		list.add(new Student("gstu2",23,56.9));
		list.add(new Student("sstu3",12,56.7));
		list.add(new Student("cstu4",33,76));
		list.add(new Student("bstu5",16,86));
		list.add(new Student("jstu6",53,56));
		list.add(new Student("dstu7",23,66));
		list.add(new Student("ustu8",63,76));
		list.add(new Student("estu9",22,86));
		list.add(new Student("vstu10",53,36));
		
		
		//
//		Collections.sort(list);
//		
//		for (Student student : list) {
//			System.out.println(student);
//		}
//		
		//用匿名内部类，写比较器
		System.out.println("按照年龄排序");
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		System.out.println("按照成绩排序：");
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore()>o2.getScore()) {
					return 1;
				}else if(o1.getScore()<o2.getScore()) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		//
		System.out.println("按照名字排序：");
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getName().charAt(0) > o2.getName().charAt(0)) {
					return 1;
				}else if(o1.getName().charAt(0) < o2.getName().charAt(0)) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
}


class Student implements Comparable<Student>{
	private String name;
	private int age;
	private double score;
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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



	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if((this.getScore()-o.getScore()) > 0) {
			return 1;
		}else if((this.getScore()-o.getScore())==0) {
			return 0;
		}else {
			
			return -1;
		}
//		return (int)(this.getScore()-o.getScore());
	}
	
	
	
}