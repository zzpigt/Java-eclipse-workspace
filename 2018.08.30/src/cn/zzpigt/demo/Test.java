package cn.zzpigt.demo;

public class Test {
	
	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			boolean isZ = true;
			for (int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					isZ = false;
				}
			}
			if(isZ) {
				System.out.println(i);
			}
		}
		
		
		
		
	}
	
}
