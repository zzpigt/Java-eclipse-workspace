package com.bwf.bean;


import java.io.Serializable;


public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8200079669335831527L;

	private Integer id;

	private String name;

	private String pwd;

	private Double money;
	
	private Integer state;

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public int getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public User() {

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", money=" + money + ", state=" + state + "]";
	}





}
