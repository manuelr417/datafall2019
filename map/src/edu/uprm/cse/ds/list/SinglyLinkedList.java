package edu.uprm.cse.ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {
	
	private class SinglyLinkedListIterator<E> implements Iterator<E>{
		
		private Node<E> nextNode;
		

		public SinglyLinkedListIterator() {
			super();
			this.nextNode = (Node<E>) header.getNext();
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
			if (this.hasNext()) {
				E result = this.nextNode.getElement();
				this.nextNode = this.nextNode.getNext();
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	
	// node class
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public Node() {
			super();
			this.element = null;
			this.next = null;
		
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
	
	// private fields
	private Node<E> header;
	private int currentSize;
	
	

	public SinglyLinkedList() {
		this.header = new Node<>();
		this.currentSize = 0;
		
	}

	@Override
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator<E>();
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
		return this.firstIndex(e) >= 0;
	}

	@Override
	public void add(E e) {
		
		Node<E> temp = this.header;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(new Node<E>(e, null));
		this.currentSize++;
		
		// cool
		//this.getPosition(this.size() -1).setNext(new Node<E>(e, null));
		//this.currentSize++;
	}

	@Override
	public void add(E e, int index) {
		if ((index <0) || (index > this.size())){
			throw new IndexOutOfBoundsException();
		}
		if (index == this.size()) {
			this.add(e);
		}
		else {
			Node<E> temp = null; 
			if (index == 0) {
				temp = this.header;
			}
			else {
				temp = this.getPosition(index -1);
			}
			// add new node
			Node<E> newNode = new Node<>();
			newNode.setElement(e);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			this.currentSize++;
		}
	}

	@Override
	public E first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getNext().getElement();
		}
	}

	@Override
	public E last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			Node<E> temp = this.header.getNext();
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			
//			Cool code!
//			Node<E> temp; 
//			for (temp = this.header.getNext();
//					temp.getNext() != null;
//					temp = temp.getNext());
				
			
			return temp.getElement(); 
		}
	}

	@Override
	public int firstIndex(E e) {
		int currentPosition = 0;
		Node<E> temp = this.header.getNext();
		
		while(temp != null) {
			if (temp.getElement().equals(e)) {
				return currentPosition;
			}
			else {
				temp = temp.getNext();
				currentPosition++;
			}
		}
		return -1;
		
	}

	@Override
	public int lastIndex(E e) {
		int i=0;
		int lastIndex = -1;
		Node<E> temp = this.header.getNext();
		while (temp != null) {
			if (temp.getElement().equals(e)) {
				lastIndex = i;
			}
			i++;
			temp = temp.getNext();
		}
		return lastIndex;
	}
	
	private Node<E> getPosition(int index){
		int currentPosition = 0;
		Node<E> temp = this.header.getNext();
		
		while (currentPosition != index) {
			temp = temp.getNext();
			currentPosition++;
		}
		return temp;
	}

	@Override
	public E get(int index) {
		if ((index <0) || (index >= this.currentSize)) {
			throw new IndexOutOfBoundsException();
		}
		return this.getPosition(index).getElement();
	}

	@Override
	public E replace(E e, int index) {
		if ((index <0) || (index >= this.currentSize)) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = this.getPosition(index);
		E result = temp.getElement();
		temp.setElement(e);
		return result;
	}

	@Override
	public E remove(int index) {
		if ((index < 0) || (index >= this.currentSize)){
			throw new IndexOutOfBoundsException();
		}
		int currentPosition =0;
		Node<E> temp = this.header;
		while(currentPosition != index) {
			temp = temp.getNext();
			currentPosition++;
		}
		Node<E> target = temp.getNext();
		E result = target.getElement();
		temp.setNext(target.getNext());
		target.setElement(null);
		target.setNext(null);
		this.currentSize--;
		return result;

	}

	@Override
	public boolean remove(E e) {
		int target = this.firstIndex(e);
		if (target < 0) {
			return false;
		}
		else {
			this.remove(target);
			return true;
		}
		// cool!
		// return (this.firstIndex(e) < 0 ? false :
		//	(this.remove(this.firstIndex(e)) != null));
	}

	@Override
	public int removeAll(E e) {
		int count = 0;
		while (this.remove(e)) {
			count++;
		}
		return count;
	}

	@Override
	public void clear() {
		while(!this.isEmpty()) {
			this.remove(0);
		}

	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.size()];
		for (int i=0; i < this.size(); ++i) {
			result[i]= this.get(i);
		}
		return result;
	}

}
