package cn.zzpigt.teacher;

// �����ر������ݵ��ص�
public class Demo4 {

	public static void main(String[] args) {
		
//		String s1 = "ab";
//		String s2 = "ab";
//		String s3 = "a" + "b";
//		
//		System.out.println(s1 == s2);	// true
//		System.out.println(s2 == s3);	// true
		
		/*
		 * ����Ҫȷ��ͬһ���ַ����ڳ�������ֻ����һ�ݿ���
		 * s1 ��Ȼ�� s2 ���
		 * ��s3��������������ӵõ��������������ڱ���ʱ���Ѿ��������
		 * ���� s3���൱�� = "ab"
		 * ���� s1 == s2 == s3
		 */
		
//		String s1 = "hello";
//		String s2 = new String("hello");
//		String s3 = "he" + new String("llo");
//		
//		System.out.println(s1 == s2);	// false
//		System.out.println(s1 == s3);	// false
		
		/*
		 * ��new�������ַ��������ڶ���
		 * "hello"���������ڳ�������
		 * ����s1 �� s2 ��ָ��ͬ�Ŀռ䣬�϶�����
		 * 
		 * s3����һ�������ͱ�����Ӷ��ɣ������ڲ����ڱ���ʱȷ����ַ
		 * ���յĽ���϶����ڶ��У����� s1 != s3
		 */
		
//		String a = "sfalse";
//		String b = "s" + false;
//		System.out.println(a == b);
		
		/*
		 * "s1"�����ڳ������У�
		 * ��b = "s"+1 ��������������ӣ��ڱ���ʱ���Ѿ�ȷ������͵�ַ
		 * ���� a == b
		 * 
		 */
		
		
//		String s1 = "ab";
//		String s2 = "aab";
//		String s3 =  "a" + s1;
//		System.out.println(s2 == s3);
		
		/*
		 * ��Ϊ s1 �� s2 ���Ǳ���
		 * s3 ������һ�� �����ͱ�����ӵõ��������ڱ���ʱȷ������͵�ַ
		 * ���� s2 != s3
		 */
		
//		final String s1 = "ab";
//		String s2 = "aab";
//		String s3 =  "a" + s1;
//		System.out.println(s2 == s3);
		
		/*
		 * ��final���ε�s1 ��ʾ��һ������
		 * �Զ���ĳ���Ҳ�����ڳ�������
		 * s3 ����һ������ֵ������һ���Զ��峣����ӵõ�
		 * �ڱ���ʱ���Ѿ�ȷ������͵�ַ
		 * ���� s2 �� s3 ��ָ����ͬ�Ŀռ�
		 */
		
		
//		String s1 = "abc";
//		String s2 = getAbc();
//		System.out.println(s1 == s2);	// true
		
		
		
		String s1 = "abc";
		String s2 = getAbc2();
		System.out.println(s1 == s2);
		
	}

	private static String getAbc() {
		return "abc";
	}
	
	private static String getAbc2() {
		String s = new String("ab") + "c";
		return s;
	}
	
	
	
	
	
}
