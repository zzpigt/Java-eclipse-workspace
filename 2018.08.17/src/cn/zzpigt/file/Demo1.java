package cn.zzpigt.file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
		
		
		File file = new File("b.txt");
//		try {
//			if(file.createNewFile()) {
//				System.out.println("�����ɹ���");
//			}else {
//				System.out.println("����ʧ�ܣ��ļ��Ѿ����ڣ�");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("���������쳣����");
//		}
//		
//		if(file.delete()) {
//			System.out.println("ɾ���ɹ�����");
//		}
//		File filedir = new File("D:\\a\\b\\c");
		
//		filedir.mkdir();
//		filedir .mkdirs();
//		File target = ;
		if(file.renameTo(new File("b.html"))) {
			System.out.println("�������ɹ�����");
		}
		
		
		
	}
}
