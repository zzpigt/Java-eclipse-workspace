package cn.zzpigt.hw;

import java.io.File;

public class Hw {
	
	public static void main(String[] args) {
//		3. 打印出某个目录下所有文件的名称
		File file = new File("D:\\a\\b");
		
//		File[] listFiles = file.listFiles();
//		
//		for (File f : listFiles) {
//			if(f.isDirectory()) {
//				System.out.println("文件夹："+f.getName());
//			}else if(f.isFile()) {
//				System.out.println("文件："+f.getName());
//			}
//		}
		
//		#4. 多级目录的内容也打印出来
//		System.out.println(new File("D:\\a").getParentFile());
		boolean isDone = false;
		do {
			if(file== null) {
				isDone = true;
				break;
			} 
			
			File[] listFiles = file.listFiles();
			System.out.println("=======================");
			System.out.println(file.getPath()+"目录下的所有文件：");
			for (File f : listFiles) {
				if(f.isDirectory()) {
					System.out.println("文件夹："+f.getName());
				}else if(f.isFile()) {
					System.out.println("文件："+f.getName());
				}
			}
			
			file = file.getParentFile();
					
		}while(!isDone);
		
		
	}
}
