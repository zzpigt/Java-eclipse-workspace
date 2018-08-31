package cn.zzpigt.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import cn.zzpigt.bean.MyResponse;

public class ClientDemo {
	public static Scanner sc = new Scanner(System.in);
	
	public static MyResponse lastResponse = null;
	
	public static void main(String[] args) {
		
		try {
			//开个客户端,连接到服务器
			Socket socket = new Socket("127.0.0.1",8080);
			
			//开个读线程
			new ClientThread(socket).start();
			
			//主线程来写交互页面
			ClientMenu menu = new ClientMenu(socket);
			menu.startMenu();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static class ClientThread extends Thread{
		
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
					case MyResponse.TYPE_MORECHAT:
						readMeg(response);
						break;
					case MyResponse.TYPE_SINGLECHAT:
						readMeg(response);
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

		private void readMeg(MyResponse response) {
			System.out.println(response.getrMeg().get(MyResponse.MEG_CONTENT));
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
