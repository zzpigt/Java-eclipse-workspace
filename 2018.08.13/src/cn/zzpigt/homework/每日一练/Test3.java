//����һ������Ϊ10 �����飬���ڲ�Ԫ�ظ�ֵ��1��2��4��8��16.....��

/*

	��ֵ�ѵ�� 	50%
	��������	80%
	�õ���		100%

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