package cn.zzpigt.obj;

public class Demo4 {
	public static void main(String[] args) {
		
		//基本类型->引用类型
		
		Integer i1 = new Integer(123);
		Integer i2 = Integer.valueOf(123);
		System.out.println(i2);
		
		//引用类型->基本类型
		int i3 = i1.intValue();
		System.out.println(i3);
		
		
		//JDK1.5后
		//自动装箱
		Integer i4 = 5;
		
		
		//自动拆箱
		int i5 = i4;
		
		
		
		//包装类的好处
		
		//可以为Null
		Integer integer1 = null;
//		int int1 = null;
		//包装类里有属性
		
		System.out.println(Integer.MAX_VALUE);
		
		//包装类中有方法
		System.out.println(Integer.toHexString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toBinaryString(100));
		
		//包装类可以和字符串转换
		String str = "123243";
		int num = Integer.parseInt(str);
		System.out.println(num);
		
		
	}
}
