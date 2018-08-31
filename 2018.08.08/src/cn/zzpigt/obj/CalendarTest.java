package cn.zzpigt.obj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		//��ӡ�Լ���Ҫ�������ʽ��ʱ�������
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		String s_date = sdf.format(date);
		System.out.println(s_date);
		System.out.println("****************************************");
		//��ӡȫ�������
		/*
		 * ��ӡ�����Ļ���ÿ������Ҫ���ã�ÿ���µ�һ����Ҫ����
		 * 
		 * 
		 * */
		Calendar cd = Calendar.getInstance();
//		System.out.println(cd.get(Calendar.YEAR));
		int yearNow = cd.get(Calendar.YEAR); 
//		int monthNow = cd.get(Calendar.MONTH); 
		//cd.set(Calendar.MONTH,1);
		//cd.set(Calendar.DAY_OF_MONTH, 1);
		//System.out.println(cd.getActualMaximum(Calendar.DAY_OF_MONTH));
		for(int i=0;i<12;i++) {
			System.out.println("======================"+yearNow+"��"+(i+1)+"��=====================");
			//��һ����
			cd.set(Calendar.MONTH, i);
			cd.set(Calendar.DAY_OF_MONTH, 1);
			//���Ӧ���Ǽ����1�ſ�ʼ�����������(����)***��API������������Ǹ���Calendar��ʱ��ֵ������ָ���������ֶε����ֵ
			int dayMax = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
			int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			for(int j=1;j<dayOfWeek;j++) {
				System.out.print("\t");
			}
			System.out.print(1+"\t");
			for(int j=2;j<=dayMax;j++) {
				if(cd.get(Calendar.DAY_OF_WEEK) == 7) {
					System.out.println();
				}
				cd.set(Calendar.DAY_OF_MONTH, j);
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		
	}
	
	
}
