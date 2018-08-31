package cn.zzpigt.hw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw3 {
	
	public static void main(String[] args) {
//		1. ͨ��·����C://IO/������һ��File����fileDir
//			2. �ж�fileDir�Ƿ���ڣ�����������򴴽����ļ���
		File fileDir = new File("C:\\IO");
		if(!fileDir.exists()) {
			fileDir.mkdir();
		}
//			3. ͨ��·����C://IO/io.txt������File����file
//			4. �ж�file�Ƿ���ڣ����������򴴽�
		File file = new File("C:\\IO\\io.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
//			5. ���file�Ķ�дȨ��
		System.out.println("���file��дȨ��:"+file.canWrite());
		System.out.println("���file�Ķ�Ȩ��:"+file.canRead());
//			6. ��ȡ�����file������
		System.out.println("file������:"+file.getName());
		
//			7. ��ȡ�����file��ȫ·��
		System.out.println("file��ȫ·��"+file.getPath());
		
//			8. ��ȡ�����file���ϼ�·��
		System.out.println("file���ϼ�·��"+file.getParent());
		
//			9. ��file����ΪnewFile
		System.out.println("��file����ΪnewFile:");
		File newFile = file;
//			10. �ж�fileDir�Ƿ�Ϊ�ļ����Ƿ�Ϊ·��
		System.out.println("fileDir�Ƿ�Ϊ�ļ�:"+fileDir.isFile());
		System.out.println("fileDir�Ƿ�Ϊ·��:"+fileDir.isDirectory());
		
//			11. ��ȡ�����newFile���ļ���С
		System.out.println("newFile���ļ���С:"+newFile.length()*1.0/1024/1024);
		
//			12. �ڡ�C://IO/�����ٴ���3���ļ�
		for(int i=0;i<3;i++) {
			try {
				new File(fileDir+"\\"+i+".txt").createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//			13. ��ȡ��C://IO/���µ������ļ�ȫ·��
		System.out.println("�����ļ�ȫ·��:");
		File[] files = fileDir.listFiles();
		for (File f : files) {
			System.out.println(f.getPath()+"---"+f.getName());
		}
		
		
//			14. ��ȡ��C://IO/���µ������ļ�����
		File[] fs = fileDir.listFiles();

		
//			15. �õ�newFile�ϴ��޸ĵ�ʱ��
		System.out.println("�õ�newFile�ϴ��޸ĵ�ʱ��:"+newFile.lastModified());
		
//			16. ��ȡ�����C�̵Ĵ洢�ռ��С�����пռ��С
		System.out.println("C�̵Ĵ洢�ռ��С:"+fileDir.getTotalSpace()/1024/1024/1024);
		System.out.println("C�̵Ŀ��пռ��С:"+fileDir.getUsableSpace()/1024/1024/1024);
		
//			17. ��дһ������ʵ������ĳһ������ָ�����ֵ��ļ�
		seacher();
		

	}

	private static void seacher() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������������Χ������:C:\\��");
		String seachPath = sc.next();
		System.out.println("�����������ļ�������:a.txt��");
		String seachFile = sc.next();
		
//		File seachRange = new File(seachPath);
		
		List<File> files = findFile(seachPath, seachFile);
		for (File f : files) {
			System.out.println(f);
		}
		
		
	}
	
	private static List<File> findFile(String sRange,String sFile) {
		List<File> fileList = new ArrayList<>();
		
		File dir = new File(sRange);
		
		if(!dir.exists() || dir.isFile()) {
			return fileList;
		}
		
		
		File[] files = dir.listFiles();
		
		
		if(files == null) {
			return fileList;
		}
		
		for (File f : files) {
			
			if(f.isFile() && sFile.equals(f.getName())) {
				fileList.add(f);
			}else if(f.isDirectory()){
				fileList.addAll(findFile(f.getAbsolutePath(), sFile));
			}
		}
		
		
		return fileList;
	}

}
