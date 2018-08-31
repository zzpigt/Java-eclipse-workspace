package cn.zzpigt.homework;

public class LinkedList<T> implements List<T> {

	private Node<T> headNode;// 头节点
	private Node<T> endNode;// 尾节点
	private int size;// 节点个数

	public LinkedList() {
		size = 0;
		headNode = new Node<T>(null);
		endNode = new Node<T>(null);

		headNode.next = endNode;
		endNode.before = headNode;
	}

	@Override
	public void add(T t) {

		Node<T> newNode = new Node<T>(t);
		Node<T> perNode = endNode.before;

		perNode.next = newNode;
		newNode.before = perNode;
		newNode.next = endNode;
		endNode.before = newNode;

		size++;

	}

	@Override
	public void remove(int index) {

		if (index > 0 && index < size) {
			// 首先根据索引找到这个位置的当前元素
			Node<T> delNode = headNode;
			for (int i = 0; i <= index; i++) {
				delNode = delNode.next;
			}

			Node<T> perNode = delNode.before;
			Node<T> nexNode = delNode.next;

			perNode.next = nexNode;
			nexNode.before = perNode;

			size--;

		}

	}

	@Override
	public T get(int index) {

		if (index < 0 || index >= size) {
			return null;
		}
		Node<T> getNode = null;
		if (index < (size / 2)) {
			getNode = headNode;
			for (int i = 0; i <= index; i++) {
				getNode = getNode.next;
			}

		} else if (index >= (size / 2)) {
			getNode = endNode;
			for (int i = 0; i < size - index; i++) {
				getNode = getNode.before;
			}
		}
		return getNode.t;

	}

	@Override
	public void set(int index, T t) {

		if (index >= 0 && index < size) {
			// 首先根据索引找到这个位置的当前元素
			Node<T> nowNode = headNode;
			for (int i = 0; i <= index; i++) {
				nowNode = nowNode.next;
			}
			Node<T> newNode = new Node<T>(t);
			Node<T> perNowNode = nowNode.before;
			Node<T> nextNowNode = nowNode.next;

			perNowNode.next = newNode;
			newNode.before = perNowNode;
			nextNowNode.before = newNode;
			newNode.next = nextNowNode;

		}

	}

	@Override
	public int size() {

		return this.size;
	}

	// node写成内部类

	private static class Node<T> {
		T t;
		Node<T> before;
		Node<T> next;

		public Node(T t) {
			this.t = t;
		}

	}

}
