package cn.zzpigt.iotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Demo5 {
	public static void main(String[] args) {
		
	}
	
	private static void copy(File src,File dest) {
		//用字符流复制文件
		Reader r = null;
		Writer w = null;
		try {
			r = new FileReader(src);
			w = new FileWriter(dest);
			char[] c = new char[2];
			int len = 0;
			while((len = r.read(c)) != -1) {
				w.write(new String(c,0,len));
			}
			w.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
