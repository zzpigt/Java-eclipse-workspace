package com.bwf.bean;

import java.util.Date;

public class Record {

	private Integer id;
	private String content;
	private Date time;
	private Integer uid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", content=" + content + ", time=" + time + ", uid=" + uid + "]";
	}
}
