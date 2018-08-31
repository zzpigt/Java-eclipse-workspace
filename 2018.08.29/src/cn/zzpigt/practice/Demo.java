package cn.zzpigt.practice;

public class Demo {
	public static void main(String[] args) {
		//

		int count = 0;

		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (j == i) {
					continue;
				}
				for (int j2 = 1; j2 < 5; j2++) {
					if (j2 == i || j2 == j) {
						continue;
					}
					for (int k = 1; k < 5; k++) {
						if (k == i || k == j || k == j2) {
							continue;
						}
						System.out.println(" "+i + j + j2 + k);
						count++;
					}
				}
			}

		}
		System.out.println(count);

	}
}
