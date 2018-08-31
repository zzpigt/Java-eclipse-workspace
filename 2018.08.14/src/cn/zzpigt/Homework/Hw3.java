package cn.zzpigt.Homework;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Hw3 {
	public static void main(String[] args) {
//		1. ����һ��TreeSet����ts����ts�ֱ����3,5,1,2,4����Ԫ�أ�Ȼ��ͨ��������ʽ���Ԫ�أ�
//		�鿴�����˳������˳���Ƿ���ͬ���ж������Ƿ��д���3������СԪ�أ��Ƿ��д��ڵ���1����СԪ�أ�
//		����о����Ƕ���
		TreeSet ts = new TreeSet();
		
		ts.add(3);
		ts.add(5);
		ts.add(1);
		ts.add(2);
		ts.add(4);
		
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
		System.out.println("�Ƿ��д���3������СԪ��:"+ts.higher(3));
		System.out.println("�Ƿ��д��ڵ���1����СԪ��:"+ts.ceiling(1));
		
		
//		2. ��ȡts��С��4���ⲿ��Ԫ����Set���󣬲���ȡ�������������
		System.out.println("��ȡts��С��4���ⲿ��Ԫ����Set����"+ts.headSet(4));
		for (Object object : ts.headSet(4)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		3. ��ȡts�д��ڵ���2���ⲿ��Ԫ��Set��ɵ�Set�Ӽ���ʹ�õ������������
		System.out.println("��ȡts�д��ڵ���2���ⲿ��Ԫ��Set��ɵ�Set�Ӽ���ʹ�õ������������:");
		for (Object object : ts.tailSet(2)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
		
//		4. ��ȡts��Ԫ�ش��ڵ���1С��4���ⲿ��Set�Ӽ�ʹ�õ������������
		System.out.println("��ȡts��Ԫ�ش��ڵ���1С��4���ⲿ��Set�Ӽ�ʹ�õ������������:");
		for (Object object : ts.tailSet(1).headSet(4)) {
			System.out.print(object+"  ");
		}
		System.out.println();
		
		
//		5. ��ts��գ������зֱ���ӡ�c��,��d��,��z��,��a��,��f������Ԫ�أ�Ȼ��ͨ��������ʽ���Ԫ�أ�
		System.out.println("��ӡ�c��,��d��,��z��,��a��,��f������Ԫ�أ�Ȼ��ͨ��������ʽ���Ԫ��:");
		ts.clear();
		ts.add('c');
		ts.add('d');
		ts.add('z');
		ts.add('a');
		ts.add('f');

		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		�鿴�����˳������˳���Ƿ���ͬ�����˳����ʲô����
		//��ͬ�����˳���ǰ���ĸ���˳�������������Ϊcharactor����String���Ͷ����Լ����������
		//comparable
		
//		6. �ٽ�ts��գ������зֱ���ӡ�Hello��,����á�,���Һá�,�����á�,����Һá���Ȼ��ͨ��������ʽ
//		���Ԫ�أ��鿴�����˳������˳���Ƿ���ͬ�����˳����ʲô����
		System.out.println("��ӡ�Hello��,����á�,���Һá�,�����á�,����Һá���Ȼ��ͨ��������ʽ:");
		ts.clear();
		ts.add("Hello");
		ts.add("���");
		ts.add("�Һ�");
		ts.add("����");
		ts.add("��Һ�");
		
		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		7. ��ts��գ���1,��a��,��Haha������ӵ�ts�����У���������ʲô����
		System.out.println("��1,��a��,��Haha������ӵ�ts������:");
		ts.clear();
//		ts.add(1);
//		ts.add('a');
//		ts.add("Haha");
		//���Ͳ�ͬ�����ܽ�������
//		for (Iterator iterator = ts.iterator(); iterator.hasNext();) {
//			Object object = (Object) iterator.next();
//			System.out.print(object+"  ");
//		}
//		System.out.println();
		
		
//		8. ��ȡһ�������������ʹ�ø�������������е������
		ts.clear();
		ts.add('c');
		ts.add('d');
		ts.add('z');
		ts.add('a');
		ts.add('f');
		
		System.out.println("��ȡһ�������������ʹ�ø�������������е������:");
		for (Iterator iterator = ts.descendingIterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();
		
//		9. ��ȡһ�������set���󣬲���ȡ������������е������
		System.out.println("��ȡһ�������set���󣬲���ȡ������������е������:");
		NavigableSet descendingSet = ts.descendingSet();
		for (Iterator iterator = descendingSet.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.print(object+"  ");
		}
		System.out.println();

//		10. ����һ����Student
//		a)	���ԣ�ѧ�š����䡢�������ɼ�
//		b)	��Ϊ��showInfoչʾѧ����Ϣ
//		c)	���췽������ʼ����������
//		Studentʵ��Comparable�ӿڣ���дcompareTo������ͨ��ѧ�Ž�����������
//		����һ��TreeSet����treeSet ��������5��Student����ֱ���ӵ�treeSet�У�
//		ʹ�õ�����������Ԫ��������鿴�������
		
		System.out.println("��������5��Student����ֱ���ӵ�treeSet:");
		
		Set<Student> treeSet = new TreeSet<>();
		
		treeSet.add(new Student(3, 23, "tong", 78.8));
		treeSet.add(new Student(2, 25, "jin", 58.8));
		treeSet.add(new Student(5, 24, "wen", 78.3));
		treeSet.add(new Student(7, 26, "zui", 66.3));
		treeSet.add(new Student(13, 27, "shuai", 98.3));
		
		for (Iterator iterator = treeSet.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
		

	}
}


class Student implements Comparable<Student >{
	private int stuNum;
	private int age;
	private String name;
	private double score;
	public Student(int stuNum, int age, String name, double score) {
		super();
		this.stuNum = stuNum;
		this.age = age;
		this.name = name;
		this.score = score;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public void showInfo() {
		System.out.println("ѧ��\t����\t����\t�ɼ�");
		System.out.println(this.getStuNum()+"\t"+this.getAge()+"\t"+this.getName()+"\t"+this.getScore());
	}
	
	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", age=" + age + ", name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.getStuNum()-o.getStuNum();
	}
	
	
	
	
}