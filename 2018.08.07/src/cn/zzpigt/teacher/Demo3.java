package cn.zzpigt.teacher;

public class Demo3 {

	public static void main(String[] args) {
		
		// ����������ȵ�4���ַ���
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		String s5 = "ABC";
		
		// �ַ������ݱȽϲ���ʹ�� == 
		System.out.println(s1 == s2);	// true
		System.out.println(s2 == s3);	// false
		System.out.println(s3 == s4);	// false
		
		
		// equals ����
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s4));
		System.out.println(s4.equals(s5));
		
		// �����ִ�Сд��֤
		System.out.println(s1.equalsIgnoreCase(s5));
		
	}
	
}
