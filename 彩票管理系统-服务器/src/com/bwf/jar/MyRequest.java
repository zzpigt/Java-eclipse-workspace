package com.bwf.jar;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MyRequest implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1837937764657754236L;
	
	private int type;
	private Map<String,String> umap = new HashMap<>();
	
	
	//常量
	public static final int TYPE_REGIST = 1;
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
	//管理员
	public static final int TYPE_ADMIN_ISSUE = 10;
	public static final int TYPE_ADMIN_FINDBUYER = 11;
	public static final int TYPE_ADMIN_SORTBUYER_BYID = 12;
	public static final int TYPE_ADMIN_SORTBUYER_BYMONEY = 13;
	public static final int TYPE_ADMIN_GETHISTORY = 19;
	//公证员
	public static final int TYPE_GREFFIER_DRAWLOTTERY = 14;
	public static final int TYPE_GREFFIER_SHOWLOTTERYMEG = 15;
	//登入者的信息
	public static final String MEG_USERNAME = "uName";
	public static final String MEG_USERPWD = "uPwd";
	public static final String MEG_LEVEL = "level";	//登入者的身份
	public static final String MEG_NEWPWD = "newPwd";//修改密码的时候需要设置
	public static final String MEG_ADDMONEY = "addMoney";//修改余额
	//彩票信息
	public static final String LOTTERY_SELECTNUM = "selectNum";//彩票号码
	public static final String LOTTERY_BUYCOUNT = "buyCount";//彩票注数
	public static final String LOTTERY_TIME = "time";//彩票期号
	public static final String LOTTERY_NEWPRICE = "newPrice";//新的单价
	public static final String LOTTERY_WINNUM = "winNum";//开奖号码
	
	public static final String ADMIN_BUYERID = "buyerId";//被查询的彩民ID
	
	public static final String MEG = "meg";
	
	public MyRequest(int type) {
		super();
		this.type = type;
	}
	
	

	public int getType() {
		return type;
	}
	public Map<String, String> getUmap() {
		return umap;
	}

	@Override
	public String toString() {
		return "MyRequest [type=" + type + ", umap=" + umap + "]";
	}
	
	
	

}
