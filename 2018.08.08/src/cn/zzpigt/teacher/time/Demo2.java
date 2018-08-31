package cn.zzpigt.teacher.time;

import java.util.Calendar;

public class Demo2 {

	public static void main(String[] args) {
		
		Calendar rightNow = Calendar.getInstance();
		// 想使用 Calendar 获取现在的年月日，礼拜几之类的信息
		
		System.out.println(rightNow.get(Calendar.YEAR));
		// 月份从0开始
		System.out.println(rightNow.get(Calendar.MONTH) + 1);
		System.out.println(rightNow.get(Calendar.DATE));
		// 礼拜几
		System.out.println(rightNow.get(Calendar.DAY_OF_WEEK) - 1);
		// 设置成2月份
		rightNow.set(Calendar.MONTH, 1);
		// 这个月最大有几天
		System.out.println(rightNow.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		
	}
	
}
