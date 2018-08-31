package cn.zzpigt.hw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Hw2 {
	public static void main(String[] args) {

		// 9. 文件搬家，通过键盘录入要移动的文件的全路径和要移动到的位置，进行文件搬家
		// #4. 文件搬家
		// 有几点要求
		// 1. 带缓冲的字节流
		// 2. 如果有同名文件 在文件名后加上 - 副本
		// 3. 在循环复制的过程中,打印复制完成度的百分比
		// 4. 复制完成前,用临时文件名 后缀名加上.tmp
		moveFile(new File("D:/b/[Java参考文档].JDK_API_1_6_zh_CN.CHM"), new File("D:/a/"));

	}

	/**
	 * 文件搬家
	 * 
	 * @param src
	 * @param target
	 */
	public static void moveFile(File src, File target) {
		// 比如：D:/b/b.txt --> D:/a （单个文件的复制）
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		if (!target.exists()) {
			target.mkdir();
		}
		// 如果这个文件在目标文件夹下存在
		// String newName = null;
		File newTarget = null;
		if (new File(target.getAbsolutePath(), src.getName()).exists()) {
			// .第一次出现的地方
			int index = src.getName().indexOf(".");
			String newName = src.getName().substring(0, index) + "-副本" + src.getName().substring(index);
//			System.out.println(newName);
			newTarget = new File(target.getAbsolutePath(), newName+".tmp");
		} else {
			newTarget = new File(target.getAbsolutePath(), src.getName()+".tmp");
		}

		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(newTarget));

			byte[] b = new byte[1024];
			int len = 0;
			int count = 0;
			while ((len = bis.read(b)) != -1) {
				count++;
				for (int i = 1; i <= 10; i++) {
					if(count == (src.length()/1024)/10*i) {//36055
						System.out.println("进度：%"+(i*10));
					}
					
				}
				bos.write(b, 0, len);
			}
			bos.flush();
			
			//复制完毕就把.tmp去掉
//			System.out.println(newTarget.getAbsolutePath());
//			File newTarget = ;
//			System.out.println(newTarget.getAbsolutePath());
//			System.out.println(target.renameTo(newTarget));
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			if(newTarget.renameTo(new File(newTarget.getParentFile(),src.getName()))) {
				System.out.println("复制完毕！！");
			}
		}

	}

}
