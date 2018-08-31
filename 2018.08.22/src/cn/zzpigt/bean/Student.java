package cn.zzpigt.bean;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3153360218711943054L;
	
	
	private int ID;
	private String name;
	private int age;
	private double height;
	
	
	
	public Student() {
		super();
	}
	public Student(int iD, String name, int age, double height) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
}
