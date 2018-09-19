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
			//��һ��������
			ServerSocket ss = new ServerSocket(port);
			
			//�����̳߳�
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
			while(true) {
				Socket socket = ss.accept();
				
				System.out.println("��һ���ͻ��˽��룡");
				
				//��һ�����߳�
				executor.execute(new ServerThread(socket));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
