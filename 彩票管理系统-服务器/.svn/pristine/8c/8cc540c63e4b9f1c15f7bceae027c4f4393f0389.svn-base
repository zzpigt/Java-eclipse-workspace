package com.bwf.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
public class ServerDemo {
	
	private static int port;
//	private static final int POOLSIZE = 2;
	
	static{
		
		Properties pp=new Properties();
		
		InputStream is = ServerDemo.class.getClassLoader().getResourceAsStream("socketconfig.properties");
		
		try {
			pp.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		port =Integer.parseInt(pp.getProperty("port"));
	}
	
	
	
	public static void main(String[] args) {
		
		try {
			//开一个服务器
			ServerSocket ss = new ServerSocket(port);
			
			//创建线程池
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			while(true) {
				Socket socket = ss.accept();
				
				System.out.println("有一个客户端接入！");
				
				//开一个读线程
				executor.execute(new ServerThread(socket));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
