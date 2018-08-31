package cn.zzpigt.ArraySort;

public class ChoiceArray {
	public static void main(String[] args) {
		
		int[] arr = {36,455,4,975,155,165,554,555,415,5,478,564,645,65};
		
//		choice(arr);//ѡ������
		bubbling(arr);
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
		
	}
	
	/**
	 * ����֪��ѡ�������ԭ��
	 * ѡ���������ÿ��ȷ��һ��������������Ǵ�ͷ��ʼȷ����
	 * ȷ���ľ�����Ϊ���ģ�Ȼ�����������бȽϣ��ҳ������е�����������λ��
	 * ȱ�㣺����ÿ������������Ҫ����һ�飬��ͺܵ�Ч��
	 * @param arr
	 */
	public static void choice(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int maxNum = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[j]>arr[maxNum]) {
					maxNum = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[maxNum];
			arr[maxNum] = temp;
		}
	}
	
	
	/**
	 * Ҳ��Ҫ֪��ð�������ԭ��
	 *�Ƚ����ڵ��������Ĵ�С��Ȼ�󽻻�λ�� 
	 *
	 * @param arr
	 */
	public static void bubbling(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
}
