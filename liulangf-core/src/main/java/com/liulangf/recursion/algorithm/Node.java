package com.liulangf.recursion.algorithm;

public class Node<T> {
	private T value;
	private Node<T> next;
	public Node(T value) {
		this.value = value;
	}

	public static <E> Node<E> node(E value) {
		return new Node<E>(value);
	}
	
	public boolean hasNext() {
		return next != null;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> next() {
		return next;
	}
	
    public Node<T> reverse2() {
        Node<T> a = this;
        Node<T> b = a.next();
        while (a.hasNext() && b != null) {
            Node<T> c = b.next();
            b.setNext(a);
            a = b;
            b = c;
        }
        this.setNext(null);
        return a;
    }
	
	public Node<T> reverse() {
		return reverse(null, this);
	}
	
	//recursively version
	private Node<T> reverse(Node<T> a, Node<T> b) {
		if (b.hasNext()) {
			Node<T> tmp = b.next();
			b.setNext(a);
			return reverse(b, tmp);
		}
		b.setNext(a);
		return b;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> root = this;
		sb.append(root.getValue());
		while (root.hasNext()) {
			root = root.next();
			sb.append("->").append(root.getValue());
		}
		return sb.toString();
	}
	
	public static Node<String> create(char c) {
		Node<String> node = null;
		char i = 'z';
		for (; i >= 'a'; i--) {
			Node<String> cur = node;
			node = node(String.valueOf(i));
			node.setNext(cur);
		}
		
		return node;
	}

	public static void main(String...args) {
		Node<String> root = create('a');
		System.out.println(root);
		System.out.println(root.reverse());
		
		root = create('a');
		System.out.println(root.reverse2());
	}
	

}
