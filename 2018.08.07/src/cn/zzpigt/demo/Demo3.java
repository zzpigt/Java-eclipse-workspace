package cn.zzpigt.demo;

public class Demo3 {
	public static void main(String[] args) {
		//��һ���ַ�������S,���ڲ�����26����д��ĸ�������
		//String s ;
		/*for (byte i = 65; i < 80; i++) {
			s += new String(i);
		}*/
		
		
		
		//�ɱ��ַ���
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = sb;
		
		for(char i='A';i<='Z';i++) {
			sb.append(i);
		}
		
		System.out.println(sb);
		
	}
}
