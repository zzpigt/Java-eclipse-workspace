package cn.zzpigt.exception;

public class Demo2 {
	public static void main(String[] args) {
		//fianlly的执行和后面的代码不同在于，finally就是程序return了也会执行的块
		
		try {
			String str = null;
			System.out.println(str.length());
			System.out.println("try执行了");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("catch处理了异常");
			return;
		} finally {
			System.out.println("最终执行！！！！");
		}
		System.out.println("程序正常执行！！");
	}
}
