package cn.zzpigt.demo;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File file = new File("D:/");
		getAllFile(file);
	}
	
	private static void getAllFile(File src) {
				
		File[] files = src.listFiles();
		if(files == null) {
			return;
		}

		for (File f : files) {
			System.out.println(f.getAbsolutePath());
			if(!f.isFile()) {
				getAllFile(f);
			}
		}
		
	}
}
