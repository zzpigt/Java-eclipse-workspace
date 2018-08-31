package cn.zzpigt.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Test {

	public static void main(String[] args) {

		 
//		new GetTime() {
//			
//			@Override
//			public void code() {
//				for (int i = 0; i < 10000; i++) {
//					System.out.println(i);
//				}
//			}
//		}.calTime();
		
		new GetTime() {
			@Override
			public void code() {
				Reader r = null;
				Writer w = null;
				try {
					w = new FileWriter("a.mp4");
					r = new FileReader("E:\\视频\\04002_多线程的实现（Thread类实现）.mp4");
					char[] c = new char[50];
					int len = 0;
					while((len = r.read(c)) != -1) {
						w.write(new String(c,0,len));
					}
					w.flush();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(r != null) {
						try {
							r.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(w != null) {
						try {
							w.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		}.calTime();;

	}
}
