package cn.zzpigt.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		File file = new File("D:\\a\\1.txt");
		
		if(file.isFile()) {
			if(file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(file));
				bw.write("hello world!!");
				bw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
	}
}
