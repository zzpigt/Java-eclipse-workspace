package cn.zzpigt.file;

import java.io.File;

public class Demo2 {
	
	public static void main(String[] args) {
		File file = new File("E:\\java-workspace\\Practice");
		printAllFile(file,0);
	}
	
	public static void printAllFile(File f,int level) {
		File[] files = f.listFiles();
		for (File fs : files) {
			for(int i = 0 ; i < level;i++) {
				System.out.print("--|");
			}
			System.out.println(fs.getName());
			if(fs.isDirectory()) {
				printAllFile(fs,level+1);
			}
		}
//		count++;
	}
}
