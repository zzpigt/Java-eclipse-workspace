package cn.zzpigt.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Demo6 {
	
	public static void main(String[] args) {
		MyLineNumberReader mnb = null;
		try {
			mnb = new MyLineNumberReader(new FileReader("1.txt"));
//			mnb.setLineNumber(10);
			mnb.setLineNumber(20);
			String line;
			while((line = mnb.readLine()) != null) {
				System.out.println(line);
			}
			mnb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}

class MyLineNumberReader{
	private Reader r;
	private static int lineNumber = 1;
	
	public MyLineNumberReader(Reader r) {
		this.r = r;
	}
	
	public String readLine() throws IOException {
		int c = 0;
		StringBuilder str = new StringBuilder();
		
		while((c = r.read()) != -1) {
			if(c == '\r') {
				continue;
			}else if(c == '\n') {
				return this.getLineNumber()+":"+str.toString();
			}else {
				str.append((char)c);
			}
		}
		
		if(str.length()>0) {
			return this.getLineNumber()+":"+str.toString();
		}else {
			return null;
		}
		
	}

	public int getLineNumber() {
		return lineNumber++;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = ++lineNumber;
	}
	
	public void close() throws IOException {
		r.close();
	}
	
	
}
