package cn.zzpigt.obj;

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

public class Animal{

	public String name;

	public Animal(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	

}