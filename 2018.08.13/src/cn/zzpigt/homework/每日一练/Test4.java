// 键盘输入 10个数 逆序
import java.util.Scanner;
class Test4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		System.out.println("输入10个数");
		for(int i = 0;i < 10; i++){
			a[i] = sc.nextInt();
		}
		

		for(int i = 0;i < a.length; i++){
			System.out.println(a[a.length - 1 - i]);
		}

		/*
		for(int i = 0;i < a.length / 2;i++){
			int tmp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = tmp;
		}
		for(int i = 0;i < a.length; i++){
			System.out.println(a[i]);
		}
		*/
		
	}
}