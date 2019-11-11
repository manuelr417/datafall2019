package edu.uprm.cse.ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.plaf.basic.BasicComboPopup.InvocationKeyHandler;

public class ArrayList<E> implements List<E> {
	
	private class ArrayListIterator<E> implements Iterator<E> {
		
		private int currentPosition; 
		
		public ArrayListIterator() {
			this.currentPosition = 0;
		}

		@Override
		public boolean hasNext() {
			return this.currentPosition < currentSize;
		}

		@Override
		public E next() {
			if (this.hasNext()) {
				E result = (E) elements[this.currentPosition++];
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
	private  E[] elements; 
	
	private int currentSize;
	
	private static final int  DEFAULT_SIZE = 10;

	public ArrayList(int initialSize) {
		if (initialSize < 1) {
			throw new IllegalArgumentException("Initial size must be at least 1");
		}
		this.elements = (E[]) new Object[initialSize];
		this.currentSize = 0;
	}

	public ArrayList() {
		this(DEFAULT_SIZE);
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
	public void add(E e) {
		if (this.currentSize == this.elements.length) {
			this.reAllocate();
		}
		this.elements[this.currentSize++] = e;
	}

	private void reAllocate() {
		E[] temp = (E[]) new Object[2*this.currentSize];
		for (int i=0; i < this.currentSize; ++i) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}

	@Override
	public void add(E e, int index) {
		if (this.currentSize == this.elements.length) {
			this.reAllocate();
		}
		if (index == this.currentSize) {
			this.add(e);
		}
		else if  ((index < 0 ) || (index > this.currentSize)) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for (int i= this.currentSize; i > index; --i) {
				this.elements[i] = this.elements[i-1];
			}
			this.elements[index] = e;
			this.currentSize++;
		}
	}

	@Override
	public E first() {
		return (this.isEmpty() ? null : this.elements[0]);
	}

	@Override
	public E last() {
		return (this.isEmpty() ? null : this.elements[this.currentSize - 1]);
	}

	@Override
	public int firstIndex(E e) {
		for (int i=0; i < this.size(); ++i) {
			if (this.elements[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndex(E e) {
		for (int i= this.currentSize -1; 
				i >= 0; --i) {
			if (this.elements[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public E get(int index) {
		if ((index < 0) || (index >= this.currentSize)) {
			throw new IndexOutOfBoundsException();
		}
		return this.elements[index];
	}

	@Override
	public E replace(E e, int index) {
		if ((index < 0) || (index >= this.currentSize)) {
			throw new IndexOutOfBoundsException();
		}
		E result = this.elements[index];
		this.elements[index] = e;
		return result;
	}

	@Override
	public E remove(int index) {
		if ((index < 0) || (index >= this.currentSize)){
			throw new IndexOutOfBoundsException();
		}
		E result = this.elements[index];
		for (int i=index; i < this.currentSize -1 ; ++i) {
			this.elements[i] = this.elements[i+1];
		}
		this.elements[this.currentSize-1] = null;
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
	}

	@Override
	public int removeAll(E e) {
		int counter = 0;
		while (this.remove(e)) {
			counter++;
		}
		return counter;
	}

	@Override
	public void clear() {

		while(!this.isEmpty()) {
			this.remove(0);
		}
	}

	@Override
	public boolean isMember(E e) {
//		for (int i=0; i < this.size(); ++i) {
//			if (this.elements[i].equals(e)) {
//				return true;
//			}
//		}
//		return false;
		return this.firstIndex(e) >= 0;
		
	} // Foo!

	@Override
	public Object[] toArray() {
		Object[] result = new Object[this.currentSize];
		for (int i=0; i < this.currentSize; ++i) {
			result[i] = this.get(i);
		}
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>();
	}
	
	

}
