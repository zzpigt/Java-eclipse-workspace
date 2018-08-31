package cn.zzpigt.file;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
//		±éÀúÎÄ¼þ¼Ð(Ä¬Ð´)
		
		
	}
	
	private static void printAll(File file) {
		File[] files = file.listFiles();
		
		if(file != null) {
			for (File f : files) {
				System.out.println(f.getName());
				if(f.isDirectory()) {
					printAll(f);
				}
			}
		}
		
	}
}
