package edu.uprm.cse.ds.stack;

import java.io.PrintStream;

public class SingleLinkedStack<E> implements Stack<E> {

	// node class
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node() {
			super();
		}
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		
	}
	
	private Node<E> header;
	private int currentSize;
	
	public SingleLinkedStack(){
		this.header = new Node<>();
		this.currentSize =0;
	}
	
	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public E top() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getNext().getElement();
		}
	}

	@Override
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			E result = this.header.getNext().getElement();
			Node<E> temp = this.header.getNext();
			this.header.setNext(temp.getNext());
			temp.setNext(null);
			temp.setElement(null);
			this.currentSize--;
			return result;
		}
	}

	@Override
	public void push(E e) {
		Node<E> newNode = new Node<>();
		newNode.setElement(e);
		newNode.setNext(this.header.getNext());
		this.header.setNext(newNode);
		this.currentSize++;
		return;
	}

	@Override
	public void clear() {
		while (this.pop() !=null);

	}

	@Override
	public void print(PrintStream out) {
		Node<E> temp = this.header.getNext();
		while(temp != null) {
			out.println(temp.getElement());
			temp = temp.getNext();
		}
		
	}

}
