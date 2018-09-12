package cn.zzpigt.view;

import java.util.List;
import java.util.Scanner;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.context.ApplicationContext;
import cn.zzpigt.service.RecordService;
import cn.zzpigt.service.UserService;
import cn.zzpigt.service.impl.RecordServiceImpl;
import cn.zzpigt.service.impl.UserServiceImpl;

public class Demo {

	static Scanner sc = new Scanner(System.in);
	private static UserService us;
	private static Users me;

	public static void main(String[] args) {
		//初始化
		ApplicationContext.init();
		//
		us = (UserService) ApplicationContext.getBean("UserService");
		
		startMeun();

		// 4. 存钱 , 取钱 , 转账功能

	}

	private static void startMeun() {
		// 完成注册, 登录功能
		while (true) {
			System.out.println("系统界面：1-注册，2-登入，3-退出");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				reg();
				break;
			case 2:
				login();
				break;
			case 3:
				sc.close();
				System.exit(0);
				break;

			default:
				break;
			}

		}
	}

	/**
	 * 登入功能
	 */
	private static void login() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		
		System.out.println("登入界面：");
		System.out.println("请输入用户名：");
		System.out.println("请输入密码：");
		String name = sc.next();
		String pwd = sc.next();
		
		try {
			me = us.loginer(name, pwd);
			userMeun();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void userMeun() {
		// 操作界面
		System.out.println("操作界面：");
		boolean isOver = false;
		do {
			System.out.println("1-存钱，2-取钱，3-转账，4-查看记录，5-查看余额，6-退出");
			int chose = sc.nextInt();
			switch (chose) {
			case 1:
				saveMoney();
				break;
			case 2:
				drawMoney();
				break;
			case 3:
				transfer();
				break;
			case 4:
				readMyLog();
				break;
			case 5:
				showMyMoney();
				break;
			case 6:
				isOver = true;
				break;

			default:
				break;
			}
			
		}while(!isOver);
	}

	private static void showMyMoney() {
		System.out.println("您的余额是");
		double money;
		try {
			Users u = us.getMyMoney(me);
			System.out.println(u.getMoney());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void transfer() {
		System.out.println("请输入需要转账的对象用户名：");
		String name = sc.next();
		System.out.println("请输入转账的金额：");
		double money = sc.nextDouble();
		
		try {
			us.transfer(me,name,money);
			System.out.println("转账成功！！");
		} catch (Exception e) {
			System.out.println("转账失败！！");
			System.out.println(e.getMessage());
		}
		
	}

	private static void readMyLog() {
		System.out.println("以下是我的操作记录：");
		try {
			RecordService rs = new RecordServiceImpl();
			List<Record> myLog = rs.getMyLog(me, ConnectionFactory.getConnection());
			for (Record record : myLog) {
				System.out.println(record);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void drawMoney() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		System.out.println("请输入要取的金额：");
		double money = sc.nextDouble();
		try {
			us.drawMoney(me,money);
			System.out.println("取钱成功！！");
		} catch (Exception e) {
			System.out.println("取钱失败！！");
			System.out.println(e.getMessage());
		}
	}

	private static void saveMoney() {
//		if(sc.hasNext()) {
//			sc.nextLine();
//		}
		System.out.println("请输入要存的金额：");
		double money = sc.nextDouble();
		try {
			us.saveMoney(me,money);
			System.out.println("存钱成功！！");
		} catch (Exception e) {
			System.out.println("存钱失败！！");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 注册功能
	 */
	private static void reg() {
		// 业务逻辑：用户注册输入用户名和密码，数据库中比对用户名是否存在
		System.out.println("注册界面：");
		System.out.println("请输入用户名：");
		System.out.println("请输入密码：");
		String name = sc.next();// 用户名应该是唯一的，自己取的名字
		String pwd = sc.next();
		
		try {
			us.register(name, pwd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


}
