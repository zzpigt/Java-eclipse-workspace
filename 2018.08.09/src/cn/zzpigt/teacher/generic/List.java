package com.bwf.generic;

// ���� - ����������
interface List<T>{
	
  	//���һ������
	void add(T t);
	//ɾ��һ������
	T remove(int index);
 	//��������ȡ������һ������
	T get(int index);
  	//������������һ������
	T set(int index, T t);
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