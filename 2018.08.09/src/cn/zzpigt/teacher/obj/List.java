package com.bwf.obj;


interface List{
	
  	//���һ������
	void add(Object o);
	//ɾ��һ������
	Object remove(int index);
 	//��������ȡ������һ������
	Object get(int index);
  	//������������һ������
	Object set(int index, Object o);
	// ��ȡ�ڲ���������
	int size();
}

class Animal{
	public String name;
	public Animal(String name){
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
}