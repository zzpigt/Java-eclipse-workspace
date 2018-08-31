package cn.zzpigt.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		List<Integer> listproxy = (List<Integer>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
				list.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object res = null;
						
						if("add".equals(method.getName())) {
							long time1 = System.currentTimeMillis();
							res = method.invoke(list, args);
							for (int i = 0; i < 10000; i++) {
								System.out.println(i);
							}
							long time2 = System.currentTimeMillis();
							System.out.println(time2-time1+"ms");
						}
						return res;
					}
				});
		
		
		listproxy.add(100);
		
		
	}
}
