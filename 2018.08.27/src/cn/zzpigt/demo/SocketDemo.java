package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(10086);
			
			Socket socket = ss.accept();
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
				os.write("ÔÙ¼û£¡£¡".getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
