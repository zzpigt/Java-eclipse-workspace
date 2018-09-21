package com.bwf.jar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398585438697246697L;

	private int type;
	private boolean isSuccess;
	private boolean isIssue;//是否发行
	private boolean isState;//是否开奖
	private Map<String, String> rMeg = new HashMap<>();

	// 需要给操作记录准备一个单独的map
	private List<String> historyList = new ArrayList<>();

	public static final int TYPE_REGISE = 1;
	public static final int TYPE_LOGIN = 2;
	public static final int TYPE_USER_LOGOUT = 16;
	public static final int TYPE_ADMIN_LOGOUT = 17;
	//彩民
	public static final int TYPE_CHANGEPWD = 4;
	public static final int TYPE_RECHARGE = 5;
	public static final int TYPE_BET = 6;
	public static final int TYPE_SHOWMESSAGE = 7;
	public static final int TYPE_DELETEME = 8;
	public static final int TYPE_BET_FLUSH = 9;
	// 管理员
	public static final int TYPE_ADMIN_ISSUE = 10;
	public static final int TYPE_ADMIN_FINDBUYER = 11;
	public static final int TYPE_ADMIN_SORTBUYER_BYID = 12;
	public static final int TYPE_ADMIN_SORTBUYER_BYMONEY = 13;
	public static final int TYPE_ADMIN_GETHISTORY = 19;
	//公证员
	public static final int TYPE_GREFFIER_DRAWLOTTERY = 14;
	public static final int TYPE_GREFFIER_SHOWLOTTERYMEG = 15;

	public static final String MEG_CONTENT = "meg";
	// 这里需要返回给客户端，登入者的信息（id），彩民还有money余额
	public static final String MEG_ID = "id";
	public static final String MEG_MONEY = "money";

	// 需要实时更新彩票信息
	public static final String LETTERY_TIME = "time";
	public static final String LETTERY_PRICE = "price";
	public static final String LETTERY_SELLNUM = "sellNum";
	public static final String LETTERY_POOLMONEY = "poolMoney";
	public static final String LETTERY_CONTENT = "lottery_content";
	
	public boolean isState() {
		return isState;
	}

	public void setState(boolean isState) {
		this.isState = isState;
	}

	public List<String> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<String> historyList) {
		this.historyList = historyList;
	}

	public boolean isIssue() {
		return isIssue;
	}

	public void setIssue(boolean isIssue) {
		this.isIssue = isIssue;
	}

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
