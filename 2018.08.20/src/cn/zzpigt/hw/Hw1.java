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
		// 1. 创建一个文件file,”C://IO/out.txt”,将”这是我通过IO流写的数据”写到file中
		File file = new File("C:/IO/out.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("文件创建成功！");
		}
		// //字符流写入
		// Writer wFile = null;
		// try {
		// wFile = new FileWriter(file);
		// wFile.write("这是我通过IO流写的数据");
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
		// System.out.println("写入成功！！");

		// 字节流写

		// OutputStream os = null;
		// String str = "这是我通过IO流写的数据fadsfadsf";
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

		// 2. 手动创建一个文件“C://IO/in.txt”,往里边写入一些内容，通过FileInputStream读取出来并输出
		// 字节读
		// InputStream is = null;
		// try {
		// is = new FileInputStream(new File("C:/IO/in.txt"));
		// byte[] b = new byte[1024];
		// int len = 0;
		// while((len = is.read(b)) != -1) {
		// System.out.print(new String(b,0,len));
		// }
		// System.out.println();
		// System.out.println("读取成功！！");
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

		// 3. 创建一个文件file，”C://IO/in.txt”，往里边写入一些数据，然后通过输入流将其读出来打印在控制台上
		// File file2 = new File("C:/IO/in.txt");
		// if(!file2.exists()) {
		// try {
		// file2.createNewFile();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// //写一些数据进去，字节写吧(带缓冲）
		// OutputStream os = null;
		// InputStream is = null;
		//
		// BufferedOutputStream bos = null;
		// BufferedInputStream bis = null;
		//
		// String str = "afsdfasd我是一个大帅哥！！！";
		// try {
		// os = new FileOutputStream(file2);
		// bos = new BufferedOutputStream(os);
		// bos.write(str.getBytes());
		// bos.flush();
		//
		// //输入到控制台上
		// is = new FileInputStream(file2);
		// bis = new BufferedInputStream(is);
		// byte[] b = new byte[1024];
		// int len =0;
		// while((len = bis.read(b)) != -1) {
		// System.out.print(new String(b,0,len));
		// }
		// System.out.println();
		// System.out.println("输入完毕！！");
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

		// 4. 读取一个文件内容，写入另一个文件，按照句号划分句子，每一行写一个句子
		// copy(new File("C:/IO/test.txt"),new File("D:/a.txt"));

		// 5. 将“Good good study，好好学习，天天向上，Day day up”这句话写入到文件Test1.txt中
		// Writer w = null;
		// try {
		// w = new FileWriter(new File("Test1.txt"));
		// w.write("Good good study，好好学习，天天向上，Day day up");
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

		// 然后读取该文件信息，把其中的英文字母取出来写入到Test2.txt中
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

		// 6. 将”C://IO/src/”下的一个图片拷贝到”C://IO/dest/”下，注意图片的完整性
		// 用字节流（缓冲）

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
		// System.out.println("复制完毕！！");
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

		// 7. 已知有两个文件file1和file2，里边都各有一些数据，比如file1中是“好好学习”,file2
		// 中是“天天向上”，现在通过IO流将两个文件中的数据“好好学习，天天向上”合并 到一个文件file中

//		File f = mergeFiles(new File("a.txt"), new File("b.txt"));
		// 8. 将”C://IO/src/source.doc”拷贝到”C://IO/src/copy.doc”
		//将第6题封装成一个copy方法，这个就可以用
		
		
		// 9. 文件搬家，通过键盘录入要移动的文件的全路径和要移动到的位置，进行文件搬家

		
		
		
	}

	public static void copy(File src, File dest) {
		// 字节把，句号的话，默认是中文的句号，句号是字符
		Writer w = null;
		Reader r = null;

		try {
			r = new FileReader(src);
			w = new FileWriter(dest);

			char[] c = new char[10];
			int len = 0;
			while ((len = r.read(c)) != -1) {
				String str = new String(c, 0, len).replace("。", "。\r\n");
				w.write(str);
			}
			w.flush();
			System.out.println("复制完毕！！");

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
			System.out.println("合并完毕!!!");

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
