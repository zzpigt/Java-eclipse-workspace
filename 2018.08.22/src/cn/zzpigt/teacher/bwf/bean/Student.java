package com.bwf.bean;

import java.io.Serializable;

public class Student implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9083319054037768175L;
	
	
	private int id;
	private String name;
	private int age;
	private double height;
	
	public Student() {
		super();
	}
	public Student(int id, String name, int age, double height) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}
	
	
	
}
