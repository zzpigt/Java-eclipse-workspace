package cn.zzpigt.file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
		
		
		File file = new File("b.txt");
//		try {
//			if(file.createNewFile()) {
//				System.out.println("创建成功！");
//			}else {
//				System.out.println("创建失败！文件已经存在！");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("创建出现异常！！");
//		}
//		
//		if(file.delete()) {
//			System.out.println("删除成功！！");
//		}
//		File filedir = new File("D:\\a\\b\\c");
		
//		filedir.mkdir();
//		filedir .mkdirs();
//		File target = ;
		if(file.renameTo(new File("b.html"))) {
			System.out.println("重命名成功！！");
		}
		
		
		
	}
}
