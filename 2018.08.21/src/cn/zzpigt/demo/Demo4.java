package cn.zzpigt.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class Demo4 {
	public static void main(String[] args) {
		Reader r = null;
		Writer w = null;
		File file = new File("a.txt");
		
		try {
			r = new FileReader(file);
			char[] c = new char[(int) file.length()];
			r.read(c);
			Arrays.sort(c);
//			for (int i = 0; i < c.length-1; i++) {
//				for (int j = 0; j < c.length-1-i; j++) {
//					if(c[j]>c[j+1]) {
//						char tmp = c[j];
//						c[j] = c[j+1];
//						c[j+1] = tmp;
//					}
//				}
//			}
			
			w = new FileWriter("b.txt");
			w.write(c);
			w.flush();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(r != null) {
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(w != null){
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
