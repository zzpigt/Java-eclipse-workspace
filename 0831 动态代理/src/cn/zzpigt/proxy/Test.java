package cn.zzpigt.proxy;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		
		InterfaceUser u = new UserUtil();
		
		u.insert();
		
		InterfaceUser u_proxy = (InterfaceUser) Proxy.newProxyInstance(u.getClass().getClassLoader(), 
				u.getClass().getInterfaces(), 
				new MyInvoHandler(u));
		
		u_proxy.insert();
		
		
		InterfaceUser u_proxy2 = (InterfaceUser) Proxy.newProxyInstance(u.getClass().getClassLoader(), 
				u.getClass().getInterfaces(), 
				new MyInvoHandler2(u_proxy));
		
		u_proxy2.insert();
		
	}
}
