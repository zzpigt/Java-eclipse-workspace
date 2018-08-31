package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Demo2 {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10086);
			while(true) {
				Socket socket = ss.accept();
				System.out.println("客户端连接上了服务器！！");
				new ServerThread(socket).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
