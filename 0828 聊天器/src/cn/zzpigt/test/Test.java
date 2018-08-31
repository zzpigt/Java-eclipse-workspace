package cn.zzpigt.test;

import cn.zzpigt.bean.MyRequest;
import cn.zzpigt.server.fileutil.DoThings;

public class Test {
	
	public static void main(String[] args) {
		MyRequest r = new MyRequest(MyRequest.TYPE_LOGIN);
		r.getUmap().put(MyRequest.MEG_CHAT_TO_USERNAME,"asdfasdfasd");
		r.getUmap().put(MyRequest.MEG_CHATCONTENT,"234234234");
		r.getUmap().put(MyRequest.MEG_USERNAME,"dddd");
		
		new DoThings() {}.getResponse(r);
		
	}

}
