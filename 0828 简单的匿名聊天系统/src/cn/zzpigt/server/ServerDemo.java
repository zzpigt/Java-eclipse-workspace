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
//			�ø�List�������еĿͻ��ˣ�Ȼ��Ⱥ��
			while(true) {
				//һ���ͻ��˽���
				Socket socket = ss.accept();
				list.add(socket);
				//���ͻ��������������߳�
				new ServerThread(socket).start();//��ǰ�Ŀͻ���
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
