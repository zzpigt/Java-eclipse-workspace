package com.bwf.jar;

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
	public static final int TYPE_CHANGEPWD = 4;
	public static final int TYPE_RECHARGE = 5;
	public static final int TYPE_BET = 6;
	public static final String MEG_CONTENT = "meg";
	//这里需要返回给客户端，登入者的信息（id），彩民还有money余额
	public static final String MEG_ID = "id";
	public static final String MEG_MONEY = "money";
	
	//需要实时更新彩票信息
	public static final String LETTERY_TIME = "time";
	public static final String LETTERY_PRICE = "price";
	public static final String LETTERY_SELLNUM = "sellNum";
	public static final String LETTERY_POOLMONEY = "poolMoney";
	
	
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
