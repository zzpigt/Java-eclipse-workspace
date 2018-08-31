package cn.zzpigt.iotest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.xml.sax.InputSource;

public class Demo3 {
	public static void main(String[] args) {
		//带缓冲的输出流
//		OutputStream os = null;
//		BufferedOutputStream bos = null;
//		try {
//			os = new FileOutputStream("1.txt");
//			bos = new BufferedOutputStream(os);
//			bos.write("hello, bos!!!!!!".getBytes());
//			bos.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(bos != null) {
//				try {
//					bos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			if(os != null) {
//				try {
//					os.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		System.out.println("写入完毕！！");
		
		
		
		//带缓冲的输入流
		InputStream is = null;
		BufferedInputStream bis = null;
		
		try {
			is = new FileInputStream("1.txt");
			bis = new BufferedInputStream(is);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = bis.read(b)) != -1) {
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
