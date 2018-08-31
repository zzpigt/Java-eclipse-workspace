package cn.zzpigt.logOperator;

public class Demo {
	public static void main(String[] args) {
		test1();
	}
	
	/**
	 * & 按位与 ：两边都是1，才是1
	 * | 按位或 ：两边都是0，才是0
	 * ^ 按位异或 ：就是不同就就是1，相同就是0
	 * ~ 按位取反 ：0变1，1变0
	 */
	public static void test1() {
		Integer a = 5;
		int b = 9;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println("===============");
		System.out.println("a&b = "+Integer.toBinaryString(a&b));
		System.out.println("a|b = "+Integer.toBinaryString(a|b));
		System.out.println("a^b = "+Integer.toBinaryString(a^b));
		//按位取反，怎么确定一个数的2进制长度呢
		System.out.println("~b = "+Integer.toBinaryString(~b));
	}
	
}
