package edu.uprm.cse.datastructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	@SuppressWarnings("hiding")
	private class ArrayListIterator<E> implements Iterator<E> {
		
		private int currentPosition;
		
		

		public ArrayListIterator() {
			super();
			this.currentPosition = 0;
			
		}

		@Override
		public boolean hasNext() {
			return this.currentPosition < currentSize;
		}

		@Override
		public E next() {
			if (this.hasNext()) {
				E result = (E) elements[this.currentPosition++]; // elements is array in enclosing class
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}
 	
	private E[] elements;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;
	
	public ArrayList(int initialSize) {
		if (initialSize < 1) {
			throw new IllegalArgumentException("Size must be at least 1.");
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
	public boolean isMember(E e) {
		return this.firstIndexOf(e) >= 0;
	}

	@Override
	public int firstIndexOf(E e) {
		for (int i=0; i < this.size(); ++i) {
			if (this.elements[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void add(E e) {
		if (this.size() == this.elements.length) {
			this.reAllocate();
		}
		this.elements[this.currentSize++]  = e;
	}

	private void reAllocate() {
		E[] temp = (E[]) new Object[2*this.size()];
		for (int i=0; i < this.size(); ++i) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}

	@Override
	public void add(E e, int position) {
		if ((position < 0) || (position > this.currentSize)){
			throw new IndexOutOfBoundsException("Illegal position");
		}
		if (position == this.currentSize) {
			this.add(e);
		}
		else {
			if (this.size() == this.elements.length) {
				this.reAllocate();
			}
			for (int i=this.currentSize; i > position; --i) {
				this.elements[i] = this.elements[i-1];
			}
			this.elements[position] = e;
			this.currentSize++;
		}	
	}

	@Override
	public E get(int position) {
		if ((position < 0) || (position >= this.currentSize)) {
			throw new IndexOutOfBoundsException("Illegal position");
		}
		return this.elements[position];
	}

	@Override
	public E remove(int position) {
		if ((position < 0) || (position >= this.currentSize)) {
			throw new IndexOutOfBoundsException("Illegal position");
		}
		E result = this.elements[position];

		for (int i=position; i < this.size() - 1; ++i) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[this.currentSize-1] = null;
		this.currentSize--;
		return result;

	}

	@Override
	public E replace(int position, E newElement) {
		if ((position < 0) || (position >= this.currentSize)) {
			throw new IndexOutOfBoundsException("Illegal position");
		}
		E result = this.elements[position];
		this.elements[position] = newElement;
		return result;
	}

	@Override
	public void clear() {
		while(!this.isEmpty()) {
			this.remove(0);
		}
	}

	@Override
	public Object[] toArray() {
		Object[] result = (E[]) new Object[this.size()];
		System.arraycopy(this.elements, 0, result, 0, this.size());
//		for (int i=0; i < this.size(); ++i) {
//			result[i] = this.elements[i];
//		}
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>();
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i=this.currentSize-1; i>= 0; --i) {
			if (this.elements[i].equals(e)) {
				return i;
			}
		}
		// not found
		return -1;
	}

	@Override
	public boolean remove(E e) {
		int target = this.firstIndexOf(e);
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
		int result=0;
		
		while(this.remove(e)) {
			result++;
		}
		return result;
	}

}
