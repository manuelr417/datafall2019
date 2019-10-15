package edu.uprm.cse.ds.queue;

import java.io.PrintStream;

public class CircularArrayQueue<E> implements Queue<E> {
	
	private E[] elements;
	private int currentSize;
	private int front;
	private int end;
	private static final int DEFAULT_SIZE = 10;
	
	public CircularArrayQueue(int initSize) {
		this.currentSize = 0;
		this.front = this.end = 0;
		this.elements = (E[]) new Object[initSize];
	}

	public CircularArrayQueue() {
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
	public E front() {
		return (this.isEmpty()? null : 
			this.elements[this.front]);
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			E result = this.elements[this.front];
			this.elements[this.front] = null;
			this.front = (this.front + 1) % this.elements.length;
			this.currentSize--;
			return result;
		}
	}

	@Override
	public void enqueue(E e) {
		if (this.size() == this.elements.length) {
			this.reAllocate();
		}
		this.elements[this.end] = e;
		this.end = (this.end + 1) % this.elements.length;
		this.currentSize++;
	}
	
	private void reAllocate() {
		E temp[] = (E[]) new Object[this.size() * 2];
		int i = 0, j = this.front;
		while (i < this.elements.length) {
			temp[i] = this.elements[j];
			i++;
			j = (j + 1) % this.elements.length;
		}
		this.elements = temp;
		this.front = 0;
		this.end = this.size();
	}

	
	@Override
	public void makeEmpty() {
		while (this.dequeue() != null);
	}

	@Override
	public void print(PrintStream P) {
		int i = this.front; 
		while (i != this.end) {
			P.println(this.elements[i]);
		}
		
	}
	

}
