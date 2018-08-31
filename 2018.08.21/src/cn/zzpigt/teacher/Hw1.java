package cn.zzpigt.teacher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

public class Hw1 {

	public static void main(String[] args) throws IOException {
		
		MyLineNumberReader br = new MyLineNumberReader(new FileReader("1.txt"));
		String line = null;
		
		br.setLineNumber(5);
		
		while((line = br.readLine()) != null) {
			System.out.print(br.getLineNumber() + ":");
			System.out.println(line);
		}
		br.close();
		
		
	}
	
}

class MyLineNumberReader extends BufferedReader {

	private int lineNumber;
	
	public MyLineNumberReader(Reader in) {
		super(in);
	}
	
	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		
		if(line != null) {
			lineNumber ++;
		}
		
		return line;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
