package com.bwf.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import com.bwf.jar.MyRequest;
import com.bwf.jar.MyResponse;

public class SecondMenu {

	private ObjectOutputStream oos;
	private MyResponse lastResponse;
	private BuyerMenu bm;
	private AdminMenu am;
	private GreffierMenu gm;

	public SecondMenu(ObjectOutputStream oos, MyResponse lastResponse) {
		super();
		this.oos = oos;
		this.lastResponse = lastResponse;
		this.bm = new BuyerMenu(oos, lastResponse);
		this.am = new AdminMenu(oos, lastResponse);
		this.gm = new GreffierMenu(oos, lastResponse);
	}

	public void operateMenu(String level, String uName) {
		// 后面再写（switch 3个身份的界面）
		System.out.println(level + "登入成功后的界面！！这个地方就需要判断是哪个身份登入了");
		switch (level) {
		case "彩民":
			try {
				bm.buyerMenu(uName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "管理员":
			try {
				am.amdinMenu(uName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "公证员":
			try {
				gm.greffierMenu(uName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("sb");
			break;
		}

	}

	

}
