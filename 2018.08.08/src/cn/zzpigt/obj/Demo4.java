package cn.zzpigt.obj;

public class Demo4 {
	public static void main(String[] args) {
		
		//��������->��������
		
		Integer i1 = new Integer(123);
		Integer i2 = Integer.valueOf(123);
		System.out.println(i2);
		
		//��������->��������
		int i3 = i1.intValue();
		System.out.println(i3);
		
		
		//JDK1.5��
		//�Զ�װ��
		Integer i4 = 5;
		
		
		//�Զ�����
		int i5 = i4;
		
		
		
		//��װ��ĺô�
		
		//����ΪNull
		Integer integer1 = null;
//		int int1 = null;
		//��װ����������
		
		System.out.println(Integer.MAX_VALUE);
		
		//��װ�����з���
		System.out.println(Integer.toHexString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toBinaryString(100));
		
		//��װ����Ժ��ַ���ת��
		String str = "123243";
		int num = Integer.parseInt(str);
		System.out.println(num);
		
		
	}
}
