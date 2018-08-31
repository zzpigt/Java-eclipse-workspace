package cn.zzpigt.homework;

public class Hw {
	public static void main(String[] args) {
		//享元模式 ：典型的String
		Integer t1 = 97;
		Integer t2 = 97;
		Integer t7 = Integer.valueOf(123);
		
		
		System.out.println(t1==t2);
		
		Integer t3 = 297;
		Integer t4 = 297;
		
		System.out.println(t3==t4);
	}

}
