package cn.zzpigt.homework;

public class Node{
	
	private Object data;//首先这个节点最主要的功能就是存储一个对象数据
	private Node next = null;//指向下一个节点
	
	public Node(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}


