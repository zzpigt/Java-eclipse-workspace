package cn.zzpigt.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test5 {
	public static void main(String[] args) {
		//������һ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		System.out.println(sdf.format(date));
		
		//����
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		int dayMax = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for (int i = 0; i < dayOfWeek-1; i++) {
			System.out.print("\t");
		}
		System.out.print(1+"\t");
		
		for (int i = 2; i <= dayMax; i++) {
			if(c.get(Calendar.DAY_OF_WEEK) == 7) {
				System.out.println();
			}
			c.set(Calendar.DAY_OF_MONTH,i);
			System.out.print(i+"\t");
		}
	}
}
