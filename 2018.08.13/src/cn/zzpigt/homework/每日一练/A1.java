/*
输入十个整数 输出最大值和最小值
*/
import java.util.Scanner;
class A1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int[] a = new int[10];

		System.out.println("请输入十个整数：");

		for(int i = 0;i < a.length;i++){
			a[i] = sc.nextInt();
		}
		int max = a[0];
		int min = a[0];

		for(int i = 0;i < a.length;i++){
			if(max < a[i]){
				max = a[i];
			}
			if(min > a[i]){
				min = a[i];
			}
		}
		System.out.println("最大值为：" + max + "最小值为：" + min);
	}
}