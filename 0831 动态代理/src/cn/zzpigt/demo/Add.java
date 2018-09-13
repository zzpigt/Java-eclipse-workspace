package cn.zzpigt.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Add {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<Integer> proxy = (List<Integer>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
				list.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long time1 = System.currentTimeMillis();
						Object res = method.invoke(list, args);
						// 增强add方法
						if ("add".equals(method.getName())) {
							long time2 = System.currentTimeMillis();
							System.out.println(time2 - time1 + "ms");
						}
						return res;
					}
				});
		proxy.add(2);
	}
}
