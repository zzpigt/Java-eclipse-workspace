package cn.zzpigt.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Demo4 {
	public static void main(String[] args) {
		//
		InputStream is = null;
		Reader r = null;
		
		try {
			is = new FileInputStream("1.txt");
			InputStreamReader isr = new InputStreamReader(is);
			char[] b = new char[2];
			int len = 0;
			while((len = isr.read(b)) != -1) {
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
