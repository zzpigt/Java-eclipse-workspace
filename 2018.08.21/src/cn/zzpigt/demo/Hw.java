package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Hw {
	
	public static void main(String[] args) {
		MyLineNumberReader2 mnb = null;
		try {
			mnb = new MyLineNumberReader2(new FileReader("1.txt"));
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

class MyLineNumberReader2 extends BufferedReader{

	private static int lineNumber = 1;
	

	public MyLineNumberReader2(Reader in) {
		super(in);
	}
	
	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		if(line != null) {
			lineNumber++;
		}
		return line;
	}
	

	public int getLineNumber() {
		return lineNumber++;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = ++lineNumber;
	}
	
	
	
}

