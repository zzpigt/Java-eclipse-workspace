package com.bwf.generic;


class Hw1{

	public static void main(String[] args){

		// �������ǵĶ�̬����
		List<Animal> list = new ArrayList<Animal>();
		
		list.add(new Animal("è"));
		list.add(new Animal("��"));
		list.add(new Animal("ţ"));

		// �������һ��������⣬��ϣ���������ڱ���ʱ����������ʱ��
		//
		
		list.add("abc");
		list.add(1);
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i).name);
		}


	}

}