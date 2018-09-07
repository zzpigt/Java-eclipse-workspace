package cn.zzpigt.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cn.zzpigt.bean.Record;
import cn.zzpigt.bean.Users;
import cn.zzpigt.dao.impl.RecordDaoImpl;
import cn.zzpigt.dao.impl.UsersDaoImpl;

public class Demo {

	static Scanner  sc = new Scanner(System.in);
	public static void main(String[] args) {
		// 完成注册, 登录功能
		while(true) {
			System.out.println("系统界面：1-注册，2-登入，3-退出");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				register();
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
		
		
		
		
		//4. 存钱 , 取钱 , 转账功能

	}
	
	/**
	 * 登入功能
	 */
	private static void login() {
		System.out.println("登入界面：");
		System.out.println("请输入用户名：");
		System.out.println("请输入密码：");
		String name = sc.next();
		String pwd = sc.next();
		UsersDaoImpl ud = new UsersDaoImpl();
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			boolean sl = ud.isSuccessLogin(name, pwd, conn);
			if(sl) {
				//登入成功,进入操作界面
				userMeun();
				//记录日志
				writeLog(conn);
			}else {
				//登入失败
				boolean sameName = ud.isSameName(name, conn);
				if(sameName) {
					//密码错误
					System.out.println("密码错误，请重写登入！！");
				}else {
					//用户不存在
					System.out.println("用户不存在，请先去注册！！");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void userMeun() {
		//操作界面
		System.out.println("操作界面！！");
	}

	/**
	 * 注册功能
	 */
	private static void register() {
		//业务逻辑：用户注册输入用户名和密码，数据库中比对用户名是否存在
		System.out.println("注册界面：");
		System.out.println("请输入用户名：");
		System.out.println("请输入密码：");
		String name = sc.next();//用户名应该是唯一的，自己取的名字
		String pwd = sc.next();
		UsersDaoImpl ud = new UsersDaoImpl();
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			boolean issameName = ud.isSameName(name, conn);
			if(issameName) {
				//用户名已经存在
				System.out.println("用户名已经存在！！！");
			}else {
				//用户可以注册
				ud.insert(new Users(null, name, pwd, 0.0), conn);
				//这条记录就可以放日志了
				writeLog(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	private static void writeLog(Connection conn) throws SQLException {
		String connect = UsersDaoImpl.lastSql;
		System.out.println(connect);
		String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ").format(new Date());
		new RecordDaoImpl().insert(new Record(null,connect,date), conn);
	}

}
