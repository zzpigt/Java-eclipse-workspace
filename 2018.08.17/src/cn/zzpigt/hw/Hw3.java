package cn.zzpigt.hw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw3 {
	
	public static void main(String[] args) {
//		1. 通过路径”C://IO/”构造一个File对象fileDir
//			2. 判断fileDir是否存在，如果不存在则创建该文件夹
		File fileDir = new File("C:\\IO");
		if(!fileDir.exists()) {
			fileDir.mkdir();
		}
//			3. 通过路径”C://IO/io.txt”构造File对象file
//			4. 判断file是否存在，若不存在则创建
		File file = new File("C:\\IO\\io.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
//			5. 检查file的读写权限
		System.out.println("检查file的写权限:"+file.canWrite());
		System.out.println("检查file的读权限:"+file.canRead());
//			6. 获取并输出file的名字
		System.out.println("file的名字:"+file.getName());
		
//			7. 获取并输出file的全路径
		System.out.println("file的全路径"+file.getPath());
		
//			8. 获取并输出file的上级路径
		System.out.println("file的上级路径"+file.getParent());
		
//			9. 将file更名为newFile
		System.out.println("将file更名为newFile:");
		File newFile = file;
//			10. 判断fileDir是否为文件，是否为路径
		System.out.println("fileDir是否为文件:"+fileDir.isFile());
		System.out.println("fileDir是否为路径:"+fileDir.isDirectory());
		
//			11. 获取并输出newFile的文件大小
		System.out.println("newFile的文件大小:"+newFile.length()*1.0/1024/1024);
		
//			12. 在”C://IO/”下再创建3个文件
		for(int i=0;i<3;i++) {
			try {
				new File(fileDir+"\\"+i+".txt").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//			13. 获取”C://IO/”下的所有文件全路径
		System.out.println("所有文件全路径:");
		File[] files = fileDir.listFiles();
		for (File f : files) {
			System.out.println(f.getPath()+"---"+f.getName());
		}
		
		
//			14. 获取”C://IO/”下的所有文件对象
		File[] fs = fileDir.listFiles();

		
//			15. 得到newFile上次修改的时间
		System.out.println("得到newFile上次修改的时间:"+newFile.lastModified());
		
//			16. 获取并输出C盘的存储空间大小及空闲空间大小
		System.out.println("C盘的存储空间大小:"+fileDir.getTotalSpace()/1024/1024/1024);
		System.out.println("C盘的空闲空间大小:"+fileDir.getUsableSpace()/1024/1024/1024);
		
//			17. 编写一个程序实现搜索某一个盘中指定名字的文件
		seacher();
		

	}

	private static void seacher() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入搜索范围：【如:C:\\】");
		String seachPath = sc.next();
		System.out.println("请输入搜索文件：【如:a.txt】");
		String seachFile = sc.next();
		
//		File seachRange = new File(seachPath);
		
		List<File> files = findFile(seachPath, seachFile);
		for (File f : files) {
			System.out.println(f);
		}
		
		
	}
	
	private static List<File> findFile(String sRange,String sFile) {
		List<File> fileList = new ArrayList<>();
		
		File dir = new File(sRange);
		
		if(!dir.exists() || dir.isFile()) {
			return fileList;
		}
		
		
		File[] files = dir.listFiles();
		
		
		if(files == null) {
			return fileList;
		}
		
		for (File f : files) {
			
			if(f.isFile() && sFile.equals(f.getName())) {
				fileList.add(f);
			}else if(f.isDirectory()){
				fileList.addAll(findFile(f.getAbsolutePath(), sFile));
			}
		}
		
		
		return fileList;
	}

}
