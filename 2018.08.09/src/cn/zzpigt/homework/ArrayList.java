package cn.zzpigt.homework;


public class ArrayList<T> implements List<T>{
	
	
	 
	public int size = 0;
	public  Object[] arrAnimal = new Object[3];	
	
	
	public void add(T o){
		if(size>=arrAnimal.length){
			Object[] temp = new Object[2*arrAnimal.length];
			for(int i=0;i<arrAnimal.length;i++){
				temp[i]=arrAnimal[i];
			} 
			arrAnimal = temp;
		}
		arrAnimal[size++] = o;
	}

	public void remove(int index){
		if(index<size){

			for(int i=index;i<size;i++){
				arrAnimal[i] = arrAnimal[i+1];
			}
			size--;


		}
		
	}

	public T get(int index){
		if(index>size){
			return null;
		}
		return (T) arrAnimal[index];
	}

	public void set(int index,T o){

		arrAnimal[index] = o;
	}

	public int size(){
		return size;
	}
}