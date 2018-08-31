package cn.zzpigt.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test2 {
	public static void main(String[] args) {
		// ����һ���ļ���
		File dir = new File("D:\\a");
		File dest = new File("E:\\a");

//		copySingleDe(dir, dest);
		
		
		//���ƶ༶�ļ���
		File dir2 = new File("D:\\b");
		File dest2 = new File("E:\\b");
		 
		copyMoreDe(dir2, dest2);
		

	}
	
	
	/**
	 * 
	 * ����һ���ļ���
	 * @param dir	��Ҫ���Ƶ��ļ���
	 * @param dest	Ŀ���ļ���
	 */
	private static void copySingleDe(File dir, File dest) {
		InputStream is = null;
		OutputStream os = null;

		if (!dest.exists()) {
			dest.mkdir();
		}

		if (dir != null && !dir.isFile()) {
			File[] files = dir.listFiles();
			
			if(files == null) {
				return;
			}
			
			
			for (File f : files) {
				try {
					is = new FileInputStream(f);
					File nfile = new File(dest.getAbsolutePath(),f.getName());
					os = new FileOutputStream(nfile);
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = is.read(b)) != -1) {
						os.write(b, 0, len);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					if (os != null) {
						try {
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			}
			System.out.println("����һ���ļ��гɹ���");
		}

	}
	
	/**
	 * ���ƶ༶�ļ���
	 * @param src	���Ƶ��ļ���
	 * @param dest	Ŀ���ļ���
	 */
	private static void copyMoreDe(File src,File dest) {
		InputStream is = null;
		OutputStream os = null;
		
		if (!dest.exists()) {
			dest.mkdir();
		}

		//���ļ������ֱ�Ӹ���
		File[] files = src.listFiles();
		
		for (File f : files) {
			if(f != null) {
				if(f.isFile()) {
					try {
						is = new FileInputStream(f);
						os = new FileOutputStream(new File(dest.getAbsolutePath(),f.getName()));
						byte[] b = new byte[1024];
						int len = 0;
						while ((len = is.read(b)) != -1) {
							os.write(b, 0, len);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if(is != null) {
							try {
								is.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
						if(os != null) {
							try {
								os.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}else if(f.isDirectory()) {
					copyMoreDe(f, new File(dest.getAbsolutePath(),f.getName()));
				}
			}
			
		}
		
		
	}
	
	
}
