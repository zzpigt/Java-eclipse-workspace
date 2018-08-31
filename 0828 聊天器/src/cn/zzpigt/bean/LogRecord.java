package cn.zzpigt.bean;

import java.util.Date;

public class LogRecord {

	private Date date;
	private String IP;
	private MyRequest request;
	private MyResponse response;
	
	public LogRecord(Date date, String iP, MyRequest request, MyResponse response) {
		super();
		this.date = date;
		IP = iP;
		this.request = request;
		this.response = response;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public MyRequest getRequest() {
		return request;
	}
	public void setRequest(MyRequest request) {
		this.request = request;
	}
	public MyResponse getResponse() {
		return response;
	}
	public void setResponse(MyResponse response) {
		this.response = response;
	}
	
	
	
	
}
