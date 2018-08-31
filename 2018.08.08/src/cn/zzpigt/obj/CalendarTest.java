package cn.zzpigt.obj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		//打印自己想要的任意格式的时间和日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String s_date = sdf.format(date);
		System.out.println(s_date);
		System.out.println("****************************************");
		//打印全年的年历
		/*
		 * 打印年历的话，每个月你要设置，每个月第一天你要设置
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
			System.out.println("======================"+yearNow+"年"+(i+1)+"月=====================");
			//第一个月
			cd.set(Calendar.MONTH, i);
			cd.set(Calendar.DAY_OF_MONTH, 1);
			//这个应该是计算从1号开始当月最大天数(错误)***看API，这个方法就是给定Calendar的时间值，返回指定日历的字段的最大值
			int dayMax = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
			int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
			System.out.println("日\t一\t二\t三\t四\t五\t六");
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
