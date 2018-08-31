package cn.zzpigt.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo3 {
	public static void main(String[] args) {
		File file = new File("E:\\java-workspace\\Practice");
		List<File> javaFile = getJavaFile(file);
		for (File f2 : javaFile) {
			System.out.println(f2.getName());
		}
		
	}
	
//	static List<File> javaFiles = new ArrayList<>();
	public static List<File> getJavaFile(File dir){
		List<File> javaFiles = new ArrayList<>();
		File[] files = dir.listFiles();
		for (File f : files) {
			if(f.isFile()) {
				String isJava = f.getName().substring(f.getName().indexOf(".")+1);
				if("java".equals(isJava)) {
					javaFiles.add(f);
				}
			}else if(f.isDirectory()) {
				javaFiles.addAll(getJavaFile(f));
			}
		}
		return javaFiles;
	}
}
