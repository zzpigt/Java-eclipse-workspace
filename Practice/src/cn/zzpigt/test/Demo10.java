package cn.zzpigt.test;

import java.util.Arrays;

public class Demo10 {
	public static void main(String[] args) {
		
		int[] num = {9,9,9,9,9,9,9,9};
		int[] plusOne = plusOne(num);
		System.out.println(Arrays.toString(plusOne));
	}

	public static int[] plusOne(int[] digits) {
		// �Ƚ���������е���ƴ������
		
		//���һλ��9���жϵ����ڶ�λ�ǲ���9�����������ж�
		String sb = new String();
		boolean isNeedAddOne = true;
		for (int i = digits.length-1; i >= 0; i--) {
			if(digits[i] +1 > 9 && isNeedAddOne) {
				if(i == 0) {
					sb += "01";
				}else {
					sb +="0";
				}
			}else {
				if(isNeedAddOne) {
					sb += digits[i]+1;
					isNeedAddOne = false;
					continue;
				}
				sb += digits[i];
			}
		}
		char[] cArr = sb.toCharArray();
		int[] target = new int[cArr.length];
		for (int i = 0; i < cArr.length; i++) {
			target[i] = Integer.parseInt(String.valueOf(cArr[cArr.length-i-1]));
		}
		
		return target;
	}

}
