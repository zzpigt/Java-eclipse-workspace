package cn.zzpigt.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 1. 写一个学生类，有姓名(String)，年龄(int)，考试分数(double)
  把10个学生保存在集合中
  删除所有考试分数不及格的学生
  然后遍历输出
 * @author admin
 *
 */
class Test {
	public static void main(String[] args) {
		
		LinkedList<Student> list = new LinkedList<>();
		
		list.add(new Student("stu1",12,56));
		list.add(new Student("stu2",13,56));
		list.add(new Student("stu3",12,56));
		list.add(new Student("stu4",13,76));
		list.add(new Student("stu5",12,86));
		list.add(new Student("stu6",13,56));
		list.add(new Student("stu7",12,66));
		list.add(new Student("stu8",13,76));
		list.add(new Student("stu9",12,86));
		list.add(new Student("stu10",13,36));
		
//		for(Student i:list) {
//			if(i.getScore() < 60) {
//				list.remove(i);
//			}
//		}
		
		//这种方法不行,依靠下标删除，当连续两个数都要被删除，那么前一个数根据下标被删了，下一个数的下标变为前一个的
		//下标，逃过了被删除的命运。
		/*for(int i=0;i<list.size();i++) {
			if(list.get(i).getScore()<60) {
				list.remove(i);
			}
		}*/
		
		//用迭代遍历删除
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if(student.getScore()<60) {
				iterator.remove();
			}else {
				System.out.println(student);
			}
		}
		
//		for(Student i:list) {
//			System.out.println(i);
//		}
		
		
		
	}
}


public class Student{
	private String name;
	private int age;
	private double score;
	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public double getScore() {
		return this.score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
	
	
}