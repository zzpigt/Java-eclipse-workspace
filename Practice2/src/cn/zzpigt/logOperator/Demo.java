package cn.zzpigt.logOperator;

public class Demo {
	public static void main(String[] args) {
		test1();
	}
	
	/**
	 * & ��λ�� �����߶���1������1
	 * | ��λ�� �����߶���0������0
	 * ^ ��λ��� �����ǲ�ͬ�;���1����ͬ����0
	 * ~ ��λȡ�� ��0��1��1��0
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
		//��λȡ������ôȷ��һ������2���Ƴ�����
		System.out.println("~b = "+Integer.toBinaryString(~b));
	}
	
}
