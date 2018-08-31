package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;

public class ServerThread extends Thread {
	private Socket socket;

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		OutputStream os;
		try {
			os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			LinkedList<Integer> list = new LinkedList<>();
			Integer max = 0;
			Integer min = 0;
			Integer sum = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (!isNumber(line)) {
					os.write("请重新输入数字：\r\n".getBytes());
					continue;
				}

				list.add(Integer.parseInt(line));
				sum += Integer.parseInt(line);
				Collections.sort(list);
				min = list.getFirst();
				max = list.getLast();
				StringBuilder sb1 = new StringBuilder("max = ").append(max.toString()).append("\r\n");
				StringBuilder sb2 = new StringBuilder("min = ").append(min.toString()).append("\r\n");
				StringBuilder sb3 = new StringBuilder("sum = ").append(sum.toString()).append("\r\n");

				os.write(sb1.toString().getBytes());
				os.write(sb2.toString().getBytes());
				os.write(sb3.toString().getBytes());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean isNumber(String str) {

		char[] cArr = str.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] < '0' || cArr[i] > '9') {
				return false;
			}
		}

		return true;
	}

}
