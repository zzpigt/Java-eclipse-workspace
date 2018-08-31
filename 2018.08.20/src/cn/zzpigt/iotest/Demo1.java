package cn.zzpigt.iotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo1 {
	public static void main(String[] args) {
		
		String str = "jljljljlj";
		
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("1.txt",true);
			os.write(str.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
