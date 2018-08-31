package cn.zzpigt.hw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Hw2 {
	public static void main(String[] args) {

		// 9. �ļ���ң�ͨ������¼��Ҫ�ƶ����ļ���ȫ·����Ҫ�ƶ�����λ�ã������ļ����
		// #4. �ļ����
		// �м���Ҫ��
		// 1. ��������ֽ���
		// 2. �����ͬ���ļ� ���ļ�������� - ����
		// 3. ��ѭ�����ƵĹ�����,��ӡ������ɶȵİٷֱ�
		// 4. �������ǰ,����ʱ�ļ��� ��׺������.tmp
		moveFile(new File("D:/b/[Java�ο��ĵ�].JDK_API_1_6_zh_CN.CHM"), new File("D:/a/"));

	}

	/**
	 * �ļ����
	 * 
	 * @param src
	 * @param target
	 */
	public static void moveFile(File src, File target) {
		// ���磺D:/b/b.txt --> D:/a �������ļ��ĸ��ƣ�
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		if (!target.exists()) {
			target.mkdir();
		}
		// �������ļ���Ŀ���ļ����´���
		// String newName = null;
		File newTarget = null;
		if (new File(target.getAbsolutePath(), src.getName()).exists()) {
			// .��һ�γ��ֵĵط�
			int index = src.getName().indexOf(".");
			String newName = src.getName().substring(0, index) + "-����" + src.getName().substring(index);
//			System.out.println(newName);
			newTarget = new File(target.getAbsolutePath(), newName+".tmp");
		} else {
			newTarget = new File(target.getAbsolutePath(), src.getName()+".tmp");
		}

		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(newTarget));

			byte[] b = new byte[1024];
			int len = 0;
			int count = 0;
			while ((len = bis.read(b)) != -1) {
				count++;
				for (int i = 1; i <= 10; i++) {
					if(count == (src.length()/1024)/10*i) {//36055
						System.out.println("���ȣ�%"+(i*10));
					}
					
				}
				bos.write(b, 0, len);
			}
			bos.flush();
			
			//������ϾͰ�.tmpȥ��
//			System.out.println(newTarget.getAbsolutePath());
//			File newTarget = ;
//			System.out.println(newTarget.getAbsolutePath());
//			System.out.println(target.renameTo(newTarget));
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			if(newTarget.renameTo(new File(newTarget.getParentFile(),src.getName()))) {
				System.out.println("������ϣ���");
			}
		}

	}

}
