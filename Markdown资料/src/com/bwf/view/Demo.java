package com.bwf.view;

import java.util.List;
import java.util.Scanner;

import com.bwf.bean.Record;
import com.bwf.bean.User;
import com.bwf.context.ApplicationContext;
import com.bwf.service.UserService;
import com.bwf.service.impl.UserServiceImpl;

public class Demo {

	public static Scanner sc = new Scanner(System.in);
	
	private static UserService us;
	
	private static User me = null;
	
	public static void main(String[] args) {
		// 先初始化应用程序上下文
		ApplicationContext.init();
		// 再获取service的实例
		us = (UserService) ApplicationContext.getBean("UserService");
		
		System.out.println(us);
		
		startMenu();
	}

	
	/**
	 * 登录后菜单
	 */
	private static void secondMenu() {
		boolean isOver = false;
		do {
			System.out.println("1-存钱 2-取钱 3-转账 4-查看记录  5-退出登录");
			int chose = sc.nextInt();
			switch (chose) {
			case 1:
				saveMoney();
				break;
			case 2:
				drawMoney();
				break;
			case 3:
				tranMoney();
				break;
			case 4:
				showRecord();
				break;
			case 5:
				isOver = true;
				break;

			default:
				break;
			}
			
			
			
		}while(!isOver);
		
		
	}
	
	/**
	 * 转账
	 */
	private static void tranMoney() {
		System.out.println("输入要转的用户的id:");
		int target = sc.nextInt();
		System.out.println("要转账的金额:");
		double money = sc.nextDouble();
		
		try {
			us.tranMoney(me, target, money);
			System.out.println("操作成功！");
		} catch (Exception e) {
			System.out.println("操作失败！");
			System.out.println(e.getMessage());
		}
		
	}


	/**
	 * 取钱
	 */
	private static void drawMoney() {
		System.out.println("输入你要取的金额");
		
		double money = sc.nextDouble();
		
		try {
			us.drawMoney(me, money);
			System.out.println("操作成功!");
		} catch (Exception e) {
			System.out.println("操作失败!");
			System.out.println(e.getMessage());
		}
		
	}


	/**
	 * 查看记录
	 */
	private static void showRecord() {
		
		System.out.println("以下是您的操作记录:");
		List<Record> list;
		try {
			list = us.getRecordList(me);
			for (Record record : list) {
				System.out.println(record);
			}
		} catch (Exception e) {
			
		}
		
		
	}


	private static void saveMoney() {
		System.out.println("输入要存的金额:");
		double money = sc.nextDouble();
		
		try {
			us.saveMoney(me, money);
			System.out.println("操作成功!");
		} catch (Exception e) {
			System.out.println("操作失败!");
			System.out.println(e.getMessage());
		}
		
	}


	public static void startMenu() {
		boolean isOver = false;
		do {
			
			System.out.println("1-注册 2-登录 3-退出");
			int chose = sc.nextInt();
			
			switch (chose) {
			case 1:
				regist();
				break;
				
			case 2:
				login();
				break;
				
			case 3:
				isOver = true;
				break;
				
			default:
				break;
			}
		}while(!isOver);
		
		
	}
	
	
	

	/**
	 * 登录菜单
	 */
	private static void login() {
		// 先清空一下缓存
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
		System.out.println("请输入用户名:");
		String uname = sc.nextLine();
		System.out.println("请输入密码");
		String upwd = sc.nextLine();
		// 调用service的登录方法
		try {
			me = us.login(uname, upwd);
			System.out.println("登录成功!");
			secondMenu();
		} catch (Exception e) {
			System.out.println("登录失败!");
			System.out.println(e.getMessage());
		}
	}



	/**
	 * 注册菜单
	 */
	private static void regist() {
		System.out.println("请输入用户名:");
		String uname = sc.next();
		System.out.println("请输入密码");
		String upwd = sc.next();
		// 调用serice的判断
		try {
			us.regist(uname, upwd);
			System.out.println("注册成功!");
		} catch (Exception e) {
			System.out.println("注册失败！");
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
