package cn.zzpigt.file;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		// 1. 创建一个父目录不存在的文件
		//
		File file = new File("D:\\a\\b\\c.txt");
		// File dirFile = new File("D:\\a\\b");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if(dirFile.mkdirs()) {
		// try {
		// if(file.createNewFile()) {
		// System.out.println("创建成功！！");
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		//
		// 2. 封装方法,传入File对象,打印获取到的文件基本信息
		// 文件名
		System.out.println("文件名:" + file.getName());
		// 文件路径
		System.out.println("文件路径:" + file.getPath());
		// 绝对路径
		System.out.println("绝对路径:" + file.getAbsolutePath());

		// 父文件夹名称
		System.out.println("父文件夹名称:" + file.getParent());
		// 文件是否存在
		System.out.println("文件是否存在" + file.exists());
		// 文件是否可写
		System.out.println("文件是否可写:" + file.canWrite());
		// 文件是否可读
		System.out.println("文件是否可读:" + file.canRead());
		// 文件是不是目录
		System.out.println("文件是不是目录:" + file.isDirectory());
		// 文件是不是文件
		System.out.println("文件是不是文件" + file.isFile());
		// 路径是不是绝对路径
		System.out.println("路径是不是绝对路径:" + file.isAbsolute());
		// 文件最后修改时间
		System.out.println("文件最后修改时间:" + file.lastModified());
		// 文件大小
		System.out.println("文件大小:" + file.getTotalSpace());

	}
}
