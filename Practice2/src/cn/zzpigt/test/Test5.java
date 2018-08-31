package cn.zzpigt.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test5 {
	public static void main(String[] args) {
		//日期做一下
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		System.out.println(sdf.format(date));
		
		//月历
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		int dayMax = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
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
