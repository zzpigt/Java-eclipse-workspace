package cn.zzpigt.demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Test {
	public static void main(String[] args) {
		//把这个项目整个复制到D盘根目录下
		File src = new File("E:\\java-workspace\\Practice");
		File dest = new File("D:\\");
		
		copy(src,dest);
		
	}

	private static void copy(File src, File dest) {
		Writer w = null;
		Reader r = null;
		if(src.isDirectory()) {
			File rootFile = new File(dest,src.getName());
			if(!rootFile.exists()) {
				rootFile.mkdirs();
			}
			File[] listFiles = src.listFiles();
			for (File f : listFiles) {
				File nfile = new File(rootFile,f.getName());
				if(!nfile.exists()) {
					nfile.mkdirs();
				}
				copy(f,nfile);
			}
			
			
		}else {
			try {
				w = new FileWriter(new File(dest,src.getName()));
				r = new FileReader(src);
				char[] c = new char[12];
				int len=0;
				while((len = r.read(c)) != -1) {
					w.write(c,0,len);
				}
				w.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(w != null) {
					try {
						w.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(r != null) {
					try {
						r.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}
}
