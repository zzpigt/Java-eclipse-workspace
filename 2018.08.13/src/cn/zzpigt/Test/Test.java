package cn.zzpigt.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 1. дһ��ѧ���࣬������(String)������(int)�����Է���(double)
  ��10��ѧ�������ڼ�����
  ɾ�����п��Է����������ѧ��
  Ȼ��������
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
		
		//���ַ�������,�����±�ɾ������������������Ҫ��ɾ������ôǰһ���������±걻ɾ�ˣ���һ�������±��Ϊǰһ����
		//�±꣬�ӹ��˱�ɾ�������ˡ�
		/*for(int i=0;i<list.size();i++) {
			if(list.get(i).getScore()<60) {
				list.remove(i);
			}
		}*/
		
		//�õ�������ɾ��
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