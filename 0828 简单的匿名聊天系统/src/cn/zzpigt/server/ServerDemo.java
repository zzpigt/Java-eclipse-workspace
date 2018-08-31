package cn.zzpigt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerDemo {
	static List<Socket> list = new ArrayList<>();

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10086);
//			用个List接收所有的客户端，然后群发
			while(true) {
				//一个客户端进来
				Socket socket = ss.accept();
				list.add(socket);
				//给客户端匿名并创建线程
				new ServerThread(socket).start();//当前的客户端
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
