package cn.zzpigt.teacher;

public class Demo8 {

	public static void main(String[] args) {
		
		// 1. ����һ���ַ�������s�����ڲ�����26����дӢ����ĸ�������
		
//		String s = "";
//		String tmp = s;
//		for(char i = 'A'; i <= 'Z' ; i ++) {
//			s += i;
//		}
//		System.out.println(s == tmp);
		
		
		// �� �ɱ��ַ�����д
		StringBuilder sb = new StringBuilder();
		StringBuilder tmp = sb;
		
		for(char i = 'A'; i <= 'Z' ; i ++) {
			sb.append(i);
		}
		
		System.out.println(sb);
		
		
	}
	
}
