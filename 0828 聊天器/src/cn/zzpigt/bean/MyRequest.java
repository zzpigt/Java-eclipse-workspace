package cn.zzpigt.bean;

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
	public static final int TYPE_SINGLECHAT = 3;
	public static final int TYPE_MORECHAT = 4;
	public static final int TYPE_LOGOUT = 5;
	public static final String MEG_USERNAME = "uName";
	public static final String MEG_USERPWD = "uPwd";
	public static final String MEG_CHATCONTENT = "uChatContent";
	public static final String MEG_CHAT_TO_USERNAME = "chatToName";
	
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
