package com.bwf.obj;


class Hw1{

	public static void main(String[] args){

		// �������ǵĶ�̬����
		List list = new ArrayList();
		
		list.add(new Animal("è"));
		list.add(new Animal("��"));
		list.add(new Animal("ţ"));

		list.add("abc");
		list.add(1);
		

		
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i) instanceof Animal) {
				System.out.println(((Animal)list.get(i)).name);
			} else {
				System.out.println(list.get(i));
			}
		}


	}

}