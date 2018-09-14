package com.bwf.bean;

public class User {

	private Integer id;
	private String uname;
	private String upwd;
	private Double money;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd + ", money=" + money + "]";
	}
	
}
