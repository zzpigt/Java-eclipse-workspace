package cn.zzpigt.homework;

public class Node{
	
	private Object data;//��������ڵ�����Ҫ�Ĺ��ܾ��Ǵ洢һ����������
	private Node next = null;//ָ����һ���ڵ�
	
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


