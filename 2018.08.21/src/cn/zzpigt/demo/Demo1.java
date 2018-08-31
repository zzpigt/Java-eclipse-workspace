package cn.zzpigt.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

public class Demo1 {
	public static void main(String[] args) {
		//���Ƶ����ļ���
		
		test1(new File("E:\\a"), new File("E:\\b"));
		
		//���ƶ༶�ļ���
		

		
		
		
	}


	private static void test1(File src,File dest) {
		
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		File newdir = new File(dest,src.getName());
		if(!newdir.exists()) {
			newdir.mkdir();
		}
		
		File[] files = src.listFiles();
		
		long srcLen = getLength(src);//�����ļ��Ĵ�С
		
		for (File f : files) {
			copy(f,new File(newdir,f.getName()),srcLen);
		}
		System.out.println("������ϣ���");
		
		
	}
	
	
	public static long srcLen = 0;
	private static long getLength(File src) {
		//���Ƕ༶�ļ���
		File[] files = src.listFiles();
		for (File f : files) {
			if(f.isFile()) {
				srcLen += f.length();
			}else {
				getLength(f);
			}
			
		}
		
		return srcLen;
	}

	public static long destLen = 0;
	private static void copy(File src, File dest, long srcLen) {
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			byte[] b = new byte[100];
			int len = 0;
			double perPercent = 0;
			while((len = bis.read(b)) != -1 ) {
				//��ӡ���ƵĽ���
				destLen += len;
				double percent = getPercent(destLen*1.0/srcLen);
				if(percent != perPercent) {
					System.out.println("��ɽ��ȣ�"+percent+"%");
					perPercent = percent;
				}
				bos.write(b,0,len);
			}
			bos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private static double getPercent(double d) {
		//0.72342345 -> 72.34
		double percent = Math.round(d*10000)*1.0/100;
		
		return percent;
	}
}
