package cn.zzpigt.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket socket = new Socket("127.0.0.1", 10086);
			
			OutputStream os = socket.getOutputStream();
			
			new ClientReadThread(socket).start();
			
			while(true) {
				System.out.println("«Î ‰»Î£∫");
				int num = sc.nextInt();
				os.write((num+"\r\n").getBytes());
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = null;
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
