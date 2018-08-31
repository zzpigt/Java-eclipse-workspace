package cn.zzpigt.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {

		ShapeFactory sf = new ShapeFactory();

//		Shape s1 = sf.getShape("cn.zzpigt.factory.Circle");
//		Shape s2 = sf.getShape("cn.zzpigt.factory.Square");

		Shape s3 = sf.getShape(readShapeName());

//		s1.draw();
//		s2.draw();
		s3.draw();

	}

	public static String readShapeName() {
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new FileReader("shapename.txt"));
			str = br.readLine();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	
}
