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
				System.out.println("����ϵͳ��");
				System.out.println("1.ע��");
				System.out.println("2.����");
				System.out.println("3.����");
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
		//���ｫ�������Ϣ��װ��Map<User,int>,�����л���json���͸�������
		//��װ��map�Ļ���user��Ͳ���д��json����y
		System.out.println("�������û�����");
		String uName = sc.next();
		System.out.println("���������룺");
		String uPwd = sc.next();
		//��װ��Ϣ
//		userMap.put(choseNum, new User(uName, uPwd));
		//���л�
		Gson gson = new Gson();
		String json = gson.toJson(new User(uName,uPwd));
		System.out.println(json);
		//����������
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
							System.out.println("�û����Ѿ����ڣ���");
							break;
						case "1":
							System.out.println("ע��ɹ��������Ե����ˣ���");
							break;
						case "2":
							System.out.println("���ȴ����û�����");
							break;
						case "3":
							System.out.println("����ɹ�����д��������");
							break;
						case "4":
							System.out.println("�û�����������󣡣�");
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
