package edu.uprm.cse.datastructures.list;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {
	
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
	
	public SinglyLinkedList() {
		this.header = new Node<>();
		this.currentSize = 0;
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
	public boolean isMember(E e) {
		return this.firstIndexOf(e) >= 0;
	}

	@Override
	public int firstIndexOf(E e) {
		int i = 0;
		for (Node<E> temp = this.header.getNext(); temp != null; 
				temp = temp.getNext(), ++i) {
			if (temp.getElement().equals(e)) {
				return i;
			}
		}
		// not found
		return -1;
	}

	@Override
	public void add(E e) {
		Node<E> temp = null;
		for (temp = this.header; temp.getNext() != null; temp = temp.getNext()) {
			// do nothing
		}
		Node<E> temp2 = new Node<>(e, null);
		temp.setNext(temp2);
		this.currentSize++;
	}

	@Override
	public void add(E e, int position) {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int position) {
		if ((position < 0) || position >= this.currentSize) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> temp  = this.getPosition(position);
		return temp.getElement();
		
	}

	private Node<E> getPosition(int position){
		int i=0;
		Node<E> temp  = null;
		for (temp = this.header.getNext(); i != position; temp = temp.getNext(), ++i);
		return temp;

	}
	
	@Override
	public E remove(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replace(int position, E newElement) {
		if ((position < 0) || position >= this.currentSize) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp  = this.getPosition(position);
		E result = temp.getElement();
		temp.setElement(newElement);
		return temp.getElement();
		
	}

	@Override
	public void clear() {
		while(!this.isEmpty()) {
			this.remove(0);
		}
	}

	@Override
	public Object[] toArray() {
		Object[] result =  new Object[this.size()];
		int i;
		Node<E> temp;
		for (i=0, temp = this.header.getNext(); temp != null; i++, temp  = temp.getNext()) {
			result[i] = temp.getElement();
		}
		return result;
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int lastIndexOf(E e) {
		int i = 0, result = -1;
		for (Node<E> temp = this.header.getNext(); temp != null; 
				temp = temp.getNext(), ++i) {
			if (temp.getElement().equals(e)) {
				result = i;
			}
		}
		// not found
		return result;
	}

}
