package cn.zzpigt.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args) {
		File src = new File("a.txt");
		File dest = new File("b.txt");
		
		if(!src.exists()) {
			try {
				src.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		copy(src, dest);
		
		
		
	}
	
	private static void copy(File src,File dest) {
		
		//”√ª∫≥Â«¯∂¡»°
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = is.read(b)) != -1) {
				os.write(b,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
