package cn.zzpigt.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Demo2 {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("1.txt");
			int b = -1;
			while((b = is.read()) != -1) {
				System.out.print((char)b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
}
