package cn.zzpigt.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServerThread extends Thread {
	private Socket socket;

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			String[] name = {"刘备","关羽","张飞","赵云","黄忠","大傻子"};
			while((line = br.readLine()) != null) {
				System.out.println(getName()+" : "+line);
				List<Socket> list = ServerDemo.list;
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(this.socket)) {
						continue;
					}
					
					StringBuilder sb = new StringBuilder("【"+name[i]+"】 (").append(getDate()).append(") : ").append(line).append("\r\n");
					list.get(i).getOutputStream().write(sb.toString().getBytes());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
		return sdf.format(date);
		
	}

}
