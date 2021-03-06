package cn.zzpigt.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MyResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8398585438697246697L;
	
	private int type;
	private boolean isSuccess;
	private Map<String,String> rMeg = new HashMap<>();
	
	public static final int TYPE_REGISE = 1;
	public static final int TYPE_LOGIN = 2;
	public static final int TYPE_SINGLECHAT = 3;
	public static final int TYPE_MORECHAT = 4;
	public static final String MEG_CONTENT = "meg";
	
	public MyResponse(int type) {
		super();
		this.type = type;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public int getType() {
		return type;
	}

	public Map<String, String> getrMeg() {
		return rMeg;
	}

	@Override
	public String toString() {
		return "MyResponse [type=" + type + ", rMeg=" + rMeg + "]";
	}
	
	
	

}
