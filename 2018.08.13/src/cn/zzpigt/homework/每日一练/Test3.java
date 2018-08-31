//定义一个长度为10 的数组，给内部元素赋值｛1，2，4，8，16.....｝

/*

	充分的训练 	50%
	动点脑子	80%
	用点心		100%

*/




class Test3{

	public static void main(String[] args){
		int[] arr = new int[10];
		

		for(int i = arr.length-1; i >=0  ; i --){
			arr[i] = 1 << i;			
	
		}
		for(int i = 0 ;i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
	}
}