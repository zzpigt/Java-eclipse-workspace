//输入一个数，计算他的各位数字之和

import java.util.Scanner;

class Text5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数");

		int a= sc.nextInt();
		int num = 0;
		int sum = 0;
		do{
			num = a % 10;
			sum += num;
			a /= 10;
					
		}while(a > 0);
		//sum += a;
		
		System.out.println("的各位数和为" + sum);
	}
}