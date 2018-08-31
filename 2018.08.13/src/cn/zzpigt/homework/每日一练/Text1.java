//键盘输入5个数，从大到小排序输出
import java.util.Scanner;
class Text1{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入5个数");
		int[]a=new int [5];
		for(int i = 0; i<=4;i++){
			a[i]=sc.nextInt();
		}
		
		for(int i = 0;i<a.length;i++){
			for(int j =0;j<a.length-i-1;j++){
				if(a[j]<a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int i =0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}



}