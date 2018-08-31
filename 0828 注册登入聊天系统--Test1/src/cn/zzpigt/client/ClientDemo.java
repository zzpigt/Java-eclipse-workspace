package cn.zzpigt.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

import cn.zzpigt.bean.User;

public class ClientDemo {
//	private static Map<Integer,User> userMap = new HashMap<>();
	private static Scanner sc = new Scanner(System.in);
	private static boolean isLogin = false;
	
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 10086);
			OutputStream os = socket.getOutputStream();
			
			
			new ClientReadThread(socket).start();
			
			while(true) {
				System.out.println("聊天系统：");
				System.out.println("1.注册");
				System.out.println("2.登入");
				System.out.println("3.待作");
				int choseNum = sc.nextInt();
				switch (choseNum) {
				case 1:
					signIn(choseNum,os);
					break;
				case 2:
					signIn(choseNum,os);
					break;
				default:
					break;
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	private static void signIn(int choseNum, OutputStream os) {
		//这里将传入的信息包装成Map<User,int>,再序列化成json发送给服务器
		//包装成map的话，user类就不好写成json，所y
		System.out.println("请输入用户名：");
		String uName = sc.next();
		System.out.println("请输入密码：");
		String uPwd = sc.next();
		//包装信息
//		userMap.put(choseNum, new User(uName, uPwd));
		//序列化
		Gson gson = new Gson();
		String json = gson.toJson(new User(uName,uPwd));
		System.out.println(json);
		//发给服务器
		try {
			os.write((choseNum+json+"\r\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	static class ClientReadThread extends Thread{
		private Socket socket;
		
		
		public ClientReadThread(Socket socket) {
			super();
			this.socket = socket;
		}



		@Override
		public void run() {
			try {
				while(true) {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = null;
					while((line = br.readLine()) != null) {
						switch (line) {
						case "0":
							System.out.println("用户名已经存在！！");
							break;
						case "1":
							System.out.println("注册成功！！可以登入了！！");
							break;
						case "2":
							System.out.println("请先创建用户！！");
							break;
						case "3":
							System.out.println("登入成功！！写操作界面");
							break;
						case "4":
							System.out.println("用户名或密码错误！！");
							break;

						default:
							break;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
