package cn.zzpigt.parseFormat;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1178486616745283468L;
	
	private int ID;
	private String Name;
	private int age;
	private double height;
	
	public Student(int iD,String name, int age, double height) {
		super();
		ID = iD;
		Name = name;
		this.age = age;
		this.height = height;
	}
	public Student() {
		super();
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", age=" + age + ", height=" + height + ", ID=" + ID + "]";
	}
	
	
	
}
