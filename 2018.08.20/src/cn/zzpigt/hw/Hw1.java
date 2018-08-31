package cn.zzpigt.hw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Hw1 {
	public static void main(String[] args) {
		// 1. ����һ���ļ�file,��C://IO/out.txt��,����������ͨ��IO��д�����ݡ�д��file��
		File file = new File("C:/IO/out.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("�ļ������ɹ���");
		}
		// //�ַ���д��
		// Writer wFile = null;
		// try {
		// wFile = new FileWriter(file);
		// wFile.write("������ͨ��IO��д������");
		// wFile.flush();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(wFile != null) {
		// try {
		// wFile.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }
		// System.out.println("д��ɹ�����");

		// �ֽ���д

		// OutputStream os = null;
		// String str = "������ͨ��IO��д������fadsfadsf";
		// try {
		// os = new FileOutputStream(new File("C:/IO/in.txt"));
		// os.write(str.getBytes());
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(os != null) {
		// try {
		// os.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }

		// 2. �ֶ�����һ���ļ���C://IO/in.txt��,�����д��һЩ���ݣ�ͨ��FileInputStream��ȡ���������
		// �ֽڶ�
		// InputStream is = null;
		// try {
		// is = new FileInputStream(new File("C:/IO/in.txt"));
		// byte[] b = new byte[1024];
		// int len = 0;
		// while((len = is.read(b)) != -1) {
		// System.out.print(new String(b,0,len));
		// }
		// System.out.println();
		// System.out.println("��ȡ�ɹ�����");
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(is != null) {
		// try {
		// is.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }

		// 3. ����һ���ļ�file����C://IO/in.txt���������д��һЩ���ݣ�Ȼ��ͨ�������������������ӡ�ڿ���̨��
		// File file2 = new File("C:/IO/in.txt");
		// if(!file2.exists()) {
		// try {
		// file2.createNewFile();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// //дһЩ���ݽ�ȥ���ֽ�д��(�����壩
		// OutputStream os = null;
		// InputStream is = null;
		//
		// BufferedOutputStream bos = null;
		// BufferedInputStream bis = null;
		//
		// String str = "afsdfasd����һ����˧�磡����";
		// try {
		// os = new FileOutputStream(file2);
		// bos = new BufferedOutputStream(os);
		// bos.write(str.getBytes());
		// bos.flush();
		//
		// //���뵽����̨��
		// is = new FileInputStream(file2);
		// bis = new BufferedInputStream(is);
		// byte[] b = new byte[1024];
		// int len =0;
		// while((len = bis.read(b)) != -1) {
		// System.out.print(new String(b,0,len));
		// }
		// System.out.println();
		// System.out.println("������ϣ���");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(bos != null) {
		// try {
		// bos.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		//
		// if( os != null) {
		// try {
		// os.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }

		// 4. ��ȡһ���ļ����ݣ�д����һ���ļ������վ�Ż��־��ӣ�ÿһ��дһ������
		// copy(new File("C:/IO/test.txt"),new File("D:/a.txt"));

		// 5. ����Good good study���ú�ѧϰ���������ϣ�Day day up����仰д�뵽�ļ�Test1.txt��
		// Writer w = null;
		// try {
		// w = new FileWriter(new File("Test1.txt"));
		// w.write("Good good study���ú�ѧϰ���������ϣ�Day day up");
		// w.flush();
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(w != null) {
		// try {
		// w.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }
		//

		// Ȼ���ȡ���ļ���Ϣ�������е�Ӣ����ĸȡ����д�뵽Test2.txt��
		Reader r = null;
		Writer w = null;
		try {
			r = new FileReader(new File("Test1.txt"));
			w = new FileWriter("Test2.txt");
			char[] c = new char[10];
			int len = 0;
			StringBuilder str = new StringBuilder();
			while ((len = r.read(c)) != -1) {
				for (int i = 0; i < len; i++) {
					if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
						str.append(c[i]);
					}
				}
			}
			w.write(str.toString());
			w.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// 6. ����C://IO/src/���µ�һ��ͼƬ��������C://IO/dest/���£�ע��ͼƬ��������
		// ���ֽ��������壩

		// BufferedInputStream bis = null;
		// BufferedOutputStream bos = null;
		//
		// try {
		//
		// File filejpg = new File("C:/IO/dest/2.jpg");
		// if(!filejpg.getParentFile().exists()) {
		// filejpg.getParentFile().mkdirs();
		// }
		//
		// bis = new BufferedInputStream(new FileInputStream("C:/IO/src/1.jpg"));
		// bos = new BufferedOutputStream(new FileOutputStream(filejpg));
		//
		//
		// byte[] b = new byte[1024];
		// int len = 0;
		// while((len = bis.read(b)) != -1) {
		// bos.write(b,0,len);
		// }
		// bos.flush();
		// System.out.println("������ϣ���");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// if(bis != null) {
		// try {
		// bis.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		//
		// if(bos != null) {
		// try {
		// bos.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// }

		// 7. ��֪�������ļ�file1��file2����߶�����һЩ���ݣ�����file1���ǡ��ú�ѧϰ��,file2
		// ���ǡ��������ϡ�������ͨ��IO���������ļ��е����ݡ��ú�ѧϰ���������ϡ��ϲ� ��һ���ļ�file��

//		File f = mergeFiles(new File("a.txt"), new File("b.txt"));
		// 8. ����C://IO/src/source.doc����������C://IO/src/copy.doc��
		//����6���װ��һ��copy����������Ϳ�����
		
		
		// 9. �ļ���ң�ͨ������¼��Ҫ�ƶ����ļ���ȫ·����Ҫ�ƶ�����λ�ã������ļ����

		
		
		
	}

	public static void copy(File src, File dest) {
		// �ֽڰѣ���ŵĻ���Ĭ�������ĵľ�ţ�������ַ�
		Writer w = null;
		Reader r = null;

		try {
			r = new FileReader(src);
			w = new FileWriter(dest);

			char[] c = new char[10];
			int len = 0;
			while ((len = r.read(c)) != -1) {
				String str = new String(c, 0, len).replace("��", "��\r\n");
				w.write(str);
			}
			w.flush();
			System.out.println("������ϣ���");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (r != null) {
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static File mergeFiles(File targer1, File target2) {
		File meFile = new File("meFile.txt");

		Reader r1 = null;
		Reader r2 = null;
		
		Writer w = null;

		try {
			 r1 = new FileReader(targer1);
			 r2 = new FileReader(target2);
			w = new FileWriter(meFile,true);
			char[] c = new char[10];
			int len = 0;
			while ((len = r1.read(c)) != -1) {
				w.write(c, 0, len);
			}
			w.flush();
			while ((len = r2.read(c)) != -1) {
				w.write(c, 0, len);
			}
			w.flush();
			System.out.println("�ϲ����!!!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(r1 != null) {
				try {
					r1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(r2 != null) {
				try {
					r2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return meFile;
	}
}
