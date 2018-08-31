//定义一个长度为10的数组，元素分别是1，2，4，8，16，32，....
class Text2{
	public static void main(String[] args){
		int[] arr = new int[10];	
		for(int i = 0 ; i < arr.length ; i ++  ){
			//arr[i] = (int)Math.pow(2,i);

			arr[i] = 1;
			for(int j = 1; j <= i; j ++){
				arr[i] *= 2;
			}

			
		}
		for(int i = 0 ; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}
	
}
/*
i  0  1  2  3   4    i
a  1  2  4  8   16   2的i次方
*/

