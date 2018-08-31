package cn.zzpigt.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map.Entry;
public class ServerDemo {
	
	public static void main(String[] args) {
		
		try {
			//开一个服务器
			ServerSocket ss = new ServerSocket(8080);
			while(true) {
				Socket socket = ss.accept();
				
				System.out.println("有一个客户端接入！");
				//开一个读线程
				new ServerThread(socket).start();
				
				//客户端强制退出
				if(socket.isClosed()) {
					
					
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
