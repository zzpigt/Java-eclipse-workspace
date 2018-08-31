package cn.zzpigt.test;

public class Test10 {
	public static void main(String[] args) {
		//1*1=1
		//2*1=2 2*2=4
		//3
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
}
