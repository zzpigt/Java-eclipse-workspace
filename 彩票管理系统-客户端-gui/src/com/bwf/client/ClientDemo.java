package com.bwf.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.bwf.jar.MyResponse;
import com.bwf.view.LoginFrame;


public class ClientDemo {
	public static Scanner sc = new Scanner(System.in);
	
	public static MyResponse lastResponse = null;
	//存放ip地址,由properties文件传入
	private static int port;
	private static String ip;
	
	private static final int POOLSIZE = 10;
	
	static{
		
		Properties pp=new Properties();
		InputStream is = ClientDemo.class.getClassLoader().getResourceAsStream("socketconfig.properties");
		try {
			pp.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		port =Integer.parseInt(pp.getProperty("port"));
		ip=pp.getProperty("ip");
	}
	
	
	public static void main(String[] args) {
		
		try {
			//开个客户端,连接到服务器
			Socket socket = new Socket(ip,port);
			
			//开一个线程池(2)
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(POOLSIZE);
			executor.execute(new ClientThread(socket));
			executor.shutdown();
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			//主线程来写交互页面
//			ClientMenu menu = new ClientMenu(socket);
//			menu.startMenu();
			/*
			 * 界
			 * 面
			 * 入
			 * 口
			 */
			
			LoginFrame menu = new LoginFrame(oos);
			menu.run();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static class ClientThread implements Runnable{
		
		private Socket socket;

		public ClientThread(Socket socket) {
			super();
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				
				MyResponse response = null;
				while((response = (MyResponse) ois.readObject()) != null) {
					System.out.println(response);
					switch (response.getType()) {
					case MyResponse.TYPE_REGISE:
						//提醒
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_LOGIN:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_CHANGEPWD:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_RECHARGE:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_BET:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_SHOWMESSAGE:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_DELETEME:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_BET_FLUSH:
						notifyMainThread(response);
						break;
					//管理员部分
					case MyResponse.TYPE_ADMIN_ISSUE:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_ADMIN_FINDBUYER:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_ADMIN_SORTBUYER_BYID:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_ADMIN_SORTBUYER_BYMONEY:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_ADMIN_GETHISTORY:
						notifyMainThread(response);
						break;
					//公证员 
					case MyResponse.TYPE_GREFFIER_DRAWLOTTERY:
						notifyMainThread(response);
						break;
					case MyResponse.TYPE_GREFFIER_SHOWLOTTERYMEG:
						notifyMainThread(response);
						break;

					default:
						break;
					}
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}

		private void notifyMainThread(MyResponse response) {
			
			synchronized (ClientDemo.class) {
				if(ClientDemo.lastResponse != null) {
					try {
						ClientDemo.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				ClientDemo.lastResponse = response;
				ClientDemo.class.notify();
				
			}
			
		}
	}
}
