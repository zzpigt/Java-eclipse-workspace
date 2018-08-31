package cn.zzpigt.obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��");
		
		//ʱ��ת�ַ���
		String s_date = sdf.format(date);
		System.out.println(s_date);
		
		//�ַ���תʱ��
		//��API���ȿ����죬Ȼ�󿴷��������û���ҵ���Ҫ�ģ����Կ��������еķ���
		Date date2 = sdf.parse(s_date);
		System.out.println(date2);
		
		
		
		//��ӡ����µ�����
		Calendar rightNow = Calendar.getInstance();
		
		System.out.println(rightNow.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println("====================="+s_date+"====================");
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		rightNow.set(Calendar.DAY_OF_MONTH, 1);
		int maxDay = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayofWeek = rightNow.get(Calendar.DAY_OF_WEEK);
		//System.out.println(dayofWeek);
		for (int i = 1; i < dayofWeek; i++) {
			System.out.print("\t");
		}
		//��һ��Ž�ȥ
		System.out.print(1+"\t");
		
		for (int i = 2; i <= maxDay; i++) {
			rightNow.set(Calendar.DAY_OF_MONTH,i);
			System.out.print(i+"\t");
			if(rightNow.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println();
			}
		}
		
		//ʵ��getActualMaximum()����
		//������������Ǹ�ʲôֵ�������һ�������е�һ�죨DAY_OF_WEEK��,	��ô�������ֵ�������������˵��7�� 
		System.out.println();
		System.out.println("========================================");
		int num = rightNow.getActualMaximum(Calendar.DAY_OF_WEEK);
		System.out.println(num);
		
		
	}
}
