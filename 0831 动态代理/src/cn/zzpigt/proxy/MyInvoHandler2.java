package cn.zzpigt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoHandler2 implements InvocationHandler{
	
	private Object obj;
	
	public MyInvoHandler2(Object obj) {
		super();
		this.obj = obj;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("²Ù×÷¼ÇÂ¼£¡£¡");
		Object res = method.invoke(obj, args);
		
		return res;
	}

}
