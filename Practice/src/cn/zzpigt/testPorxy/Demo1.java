package cn.zzpigt.testPorxy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo1 {
	
	public static void main(String[] args) {
		
		//复制一个文件所要花费的时间
		
		try {
			Writer w = new FileWriter("newcopy.txt");
			Writer p_write = (Writer) Proxy.newProxyInstance(w.getClass().getClassLoader(), w.getClass().getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					long time1 = System.currentTimeMillis();
					Object res = method.invoke(w, args);
					if("write".equals(method.getName())) {
						long time2 = System.currentTimeMillis();
						System.out.println("写入一句话需要："+(time1 - time2));
					}
					return res;
				}
			});
			
			p_write.write("hello,world");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}

}
