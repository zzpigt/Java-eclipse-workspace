package cn.zzpigt.bean;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5334779890705007720L;
	
	private String uName;
	private String uPwd;
	
	public User(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	@Override
	public String toString() {
		return "User [uName=" + uName + ", uPwd=" + uPwd + "]";
	}
	
	
	
	
	

}
