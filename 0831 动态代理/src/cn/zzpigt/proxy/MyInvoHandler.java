package cn.zzpigt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoHandler implements InvocationHandler{
	
	private Object obj;
	
	public MyInvoHandler(Object obj) {
		super();
		this.obj = obj;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("È¨ÏÞ£¡£¡");
		Object res = method.invoke(obj, args);
		
		return res;
	}

}
