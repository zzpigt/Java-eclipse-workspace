package cn.zzpigt.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HwArrayStudent {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Student>  stuList = new ArrayList<>(); 
		stuList.add(new Student("tjw",23,100));
		
		System.out.println("=============学生信息系统==============");
		System.out.println("请选择登录角色：");
		System.out.println("1.老师");
		System.out.println("2.学生");
		
		switch(sc.nextInt()) {
		case 1:
			System.out.println("您以老师的身份登录的，老师的功能是：");
			System.out.println("1.查看信息");
			System.out.println("2.录入信息");
			System.out.println("请选择：");
			int chose = sc.nextInt();
			if(chose == 1) {
				//查看信息
				showStu(stuList);
				break;
			}else if(chose == 2) {
				//录入信息
				boolean isOver = false;
				do {
					System.out.println("请输入学生姓名、年龄、成绩，用空格隔开：");
					String name= sc.next();
					int age = sc.nextInt();
					double score = sc.nextDouble();
					stuList.add(new Student(name,age,score));
					System.out.println("是否继续录入：1-继续，2-退出");
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
				System.out.println("输入错误！！");
			}
			break;
		case 2: 
			System.out.println("没有做这个系统！！");
			break;
			default: System.out.println("输入错误！！！");
		}
		
		
		
	}
	
	public static void showStu(List<Student> stuList) {
		System.out.println("以下是班级学生信息：");
		System.out.println("姓名\t年龄\t成绩");
		if(stuList == null || stuList.size() == 0) {
			System.out.println("没有学生信息，请录入！！");
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