package cn.zzpigt.teacher;

public class Demo6 {

	public static void main(String[] args) {
		
		// �մ�
		String s1 = "";
		// null��
		String s2 = null;
		
		System.out.println(s2);
		
		// ����жϿմ�
		System.out.println(s1.length() == 0);
		System.out.println(s1.equals(""));
		System.out.println("".equals(s1));	// �Ƽ�
		
		// ����ж�null��
		System.out.println(s2 == null);
		
		
		// ����ж�һ���ַ����Ȳ��ǿմ���Ҳ����null��
		System.out.println(s2 != null && s2.length() > 0);
		
	}
	
}
