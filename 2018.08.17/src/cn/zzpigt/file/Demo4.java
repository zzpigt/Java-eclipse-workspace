package cn.zzpigt.file;

import java.io.File;

public class Demo4 {
	
	public static void main(String[] args) {
		File file = new File("D:\\a");
		rmAllFile(file);
	}
	
	public static void rmAllFile(File dir) {
		File[] files = dir.listFiles();
		
		for (File f : files) {
			rmAllFile(f);
		}
		dir.delete();
	}

}
