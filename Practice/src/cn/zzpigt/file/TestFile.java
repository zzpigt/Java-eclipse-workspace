package cn.zzpigt.file;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
//		�����ļ���(Ĭд)
		
		
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
