//����һ�������������ĸ�λ����֮��

import java.util.Scanner;

class Text5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ����");

		int a= sc.nextInt();
		int num = 0;
		int sum = 0;
		do{
			num = a % 10;
			sum += num;
			a /= 10;
					
		}while(a > 0);
		//sum += a;
		
		System.out.println("�ĸ�λ����Ϊ" + sum);
	}
}