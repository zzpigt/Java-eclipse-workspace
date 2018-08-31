package cn.zzpigt.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;

import cn.zzpigt.bean.User;

public class ServerThread extends Thread {
	private static List<User> list;
	private Socket socket;

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				User user = new Gson().fromJson(line.substring(1), User.class);
				System.out.println(user);
				Character c = line.charAt(0);
				
				switch (Integer.parseInt(c.toString())) {
				case 1:
					// 注册
					if(list == null) {
						list = new ArrayList<>();
						list.add(user);
						//返回注册成功
						System.out.println("1");
						bw.write("1\r\n");
						bw.flush();
					}else {
						for (User u : list) {
							System.out.println(u);
							if(user.getuName().equals(u.getuName())) {
								//用户已经存在
								System.out.println("0");
								bw.write("0\r\n");
								bw.flush();
							}else {
								list.add(user);
								//返回注册成功
								System.out.println("1");
								bw.write("1\r\n");
								bw.flush();
							}
						}
					}
					
					break;
				case 2:
					//登入
					if(list == null) {
						System.out.println("2,请先创建用户！！");
						bw.write("2\r\n");
						bw.flush();
					}else {
						for (User u : list) {
							if(user.equals(u)) {
								bw.write("3\r\n");
								bw.flush();
							}else {
								bw.write("4\r\n");
								bw.flush();
							}
						}
					}

				default:
					break;
				}
				
			}
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
	}

//	private String getDate() {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
//		return sdf.format(date);
//		
//	}

}
