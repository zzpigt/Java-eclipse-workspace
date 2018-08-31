package cn.zzpigt.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
	private static long allFileLength = 0;
	private static long filesLength = 0;
	private static double perPercent = 0;
	
	
	public static void main(String[] args) {
		// ���ƶ༶�ļ���

		//��ӡ�ٷֱȣ����ȿ�������ʲô�����ӡ���϶������ļ����ƹ����У�������copy�о͸ô�ӡ
		
		
		test2(new File("D:\\b"), new File("D:\\a"));
	}

	private static void test2(File src, File dest) {

		if (!dest.exists()) {
			dest.mkdirs();
		}
		allFileLength = getAllFileLength(src);

		File newdir = new File(dest, src.getName());
		if (!newdir.exists()) {
			newdir.mkdir();
		}

		File[] files = src.listFiles();
		
		for (File f : files) {
			if(f.isFile()) {
				copy(f, new File(newdir, f.getName()));
			}else {
				test2(f,newdir);
			}
		}
		System.out.println(src.getAbsolutePath()+"���Ƴɹ�����");
	}

	/**
	 * 
	 * @param src
	 * @param dest
	 * @param length ��¼������ɵĳ���
	 */
	private static void copy(File src, File dest) {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));

			byte[] b = new byte[1024];
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				filesLength += len;
				double percent = filesLength*1.0/allFileLength;
				double getperchent = getStrPercent(percent);
				if(getperchent != perPercent) {
					System.out.println("���ȣ�"+getperchent+"%");
					perPercent = getperchent;
				}
				bos.write(b, 0, len);
			}
			bos.flush();

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
		}

	}
	
	private static double getStrPercent(double percent) {
		percent = Math.round(percent*10000)*1.0/100;
		return percent;
	}

	private static long getAllFileLength(File src) {
		if(!src.exists()) {
			return allFileLength;
		}
		File[] files = src.listFiles();
		for (File f : files) {
			if(f.isFile()) {
				allFileLength += f.length();
			}else {
				getAllFileLength(f);
			}
		}
		
		return allFileLength;
	}
}
