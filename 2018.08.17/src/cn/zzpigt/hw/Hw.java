package cn.zzpigt.hw;

import java.io.File;

public class Hw {
	
	public static void main(String[] args) {
//		3. ��ӡ��ĳ��Ŀ¼�������ļ�������
		File file = new File("D:\\a\\b");
		
//		File[] listFiles = file.listFiles();
//		
//		for (File f : listFiles) {
//			if(f.isDirectory()) {
//				System.out.println("�ļ��У�"+f.getName());
//			}else if(f.isFile()) {
//				System.out.println("�ļ���"+f.getName());
//			}
//		}
		
//		#4. �༶Ŀ¼������Ҳ��ӡ����
//		System.out.println(new File("D:\\a").getParentFile());
		boolean isDone = false;
		do {
			if(file== null) {
				isDone = true;
				break;
			} 
			
			File[] listFiles = file.listFiles();
			System.out.println("=======================");
			System.out.println(file.getPath()+"Ŀ¼�µ������ļ���");
			for (File f : listFiles) {
				if(f.isDirectory()) {
					System.out.println("�ļ��У�"+f.getName());
				}else if(f.isFile()) {
					System.out.println("�ļ���"+f.getName());
				}
			}
			
			file = file.getParentFile();
					
		}while(!isDone);
		
		
	}
}
