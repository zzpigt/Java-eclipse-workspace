package cn.zzpigt.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo5 {
	public static void main(String[] args) {
		//��������ַ�������
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("1.txt"));
			bw.write("���Ǵ�˧�磡��");
			bw.newLine();
			bw.write("������˧����");
			bw.flush();
			
			br = new BufferedReader(new FileReader("1.txt"));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
