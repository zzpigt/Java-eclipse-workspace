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
			//��һ��������
			ServerSocket ss = new ServerSocket(8080);
			while(true) {
				Socket socket = ss.accept();
				
				System.out.println("��һ���ͻ��˽��룡");
				//��һ�����߳�
				new ServerThread(socket).start();
				
				//�ͻ���ǿ���˳�
				if(socket.isClosed()) {
					
					
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
