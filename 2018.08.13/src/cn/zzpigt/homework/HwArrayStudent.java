package cn.zzpigt.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HwArrayStudent {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Student>  stuList = new ArrayList<>(); 
		stuList.add(new Student("tjw",23,100));
		
		System.out.println("=============ѧ����Ϣϵͳ==============");
		System.out.println("��ѡ���¼��ɫ��");
		System.out.println("1.��ʦ");
		System.out.println("2.ѧ��");
		
		switch(sc.nextInt()) {
		case 1:
			System.out.println("������ʦ����ݵ�¼�ģ���ʦ�Ĺ����ǣ�");
			System.out.println("1.�鿴��Ϣ");
			System.out.println("2.¼����Ϣ");
			System.out.println("��ѡ��");
			int chose = sc.nextInt();
			if(chose == 1) {
				//�鿴��Ϣ
				showStu(stuList);
				break;
			}else if(chose == 2) {
				//¼����Ϣ
				boolean isOver = false;
				do {
					System.out.println("������ѧ�����������䡢�ɼ����ÿո������");
					String name= sc.next();
					int age = sc.nextInt();
					double score = sc.nextDouble();
					stuList.add(new Student(name,age,score));
					System.out.println("�Ƿ����¼�룺1-������2-�˳�");
					int inputNum = sc.nextInt();
					if(inputNum == 1) {
						isOver = false;
					}else if(inputNum == 2) {
						isOver = true;
						System.out.println("Over!!");
					}
				}while(!isOver);
				showStu(stuList);
				
			}else {
				System.out.println("������󣡣�");
			}
			break;
		case 2: 
			System.out.println("û�������ϵͳ����");
			break;
			default: System.out.println("������󣡣���");
		}
		
		
		
	}
	
	public static void showStu(List<Student> stuList) {
		System.out.println("�����ǰ༶ѧ����Ϣ��");
		System.out.println("����\t����\t�ɼ�");
		if(stuList == null || stuList.size() == 0) {
			System.out.println("û��ѧ����Ϣ����¼�룡��");
		}
		for (Student i : stuList) {
			System.out.println(i.getName()+"\t"+i.getAge()+"\t"+i.getScore());
		}
	}
	
}

class Student{
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
	
	
	
	
}