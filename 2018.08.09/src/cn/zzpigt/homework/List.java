package cn.zzpigt.homework;

interface List<T>{
	
	//���һ������
	void add(T t);
	//ɾ��һ������
	void remove(int index);
 	//��������ȡ������һ������
	T get(int index);
  	//������������һ������
	void set(int index, T t);
	// ��ȡ�ڲ���������
	int size();
}
