package edu.uprm.cse.ds.stack;

import java.io.OutputStream;
import java.io.PrintStream;

public class ArrayStack<E> implements Stack<E> {
	
	private E[] elements;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;
	
	public ArrayStack() {
		this.currentSize = 0;
		this.elements= (E[]) new Object[DEFAULT_SIZE];
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
			return this.elements[this.currentSize-1];
		}
		//
		//return this.isEmpty() ? null : this.elements[this.currentSize-1]
	}

	@Override
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			E result = this.elements[this.currentSize-1];
			this.elements[this.currentSize-1] = null;
			this.currentSize--;
			return result;
		}
	}

	@Override
	public void push(E e) {
		if (this.size() == this.elements.length) {
			this.reAllocate();
		}
		this.elements[this.currentSize++]= e;
	}

	private void reAllocate() {
		E[] temp = (E[]) new Object[2*this.currentSize];
		for (int i=0; i < this.currentSize; ++i) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}
	@Override
	public void clear() {
		while (!this.isEmpty()) {
			this.pop();
		}
		
		// on line?
		//while (!(this.pop() == null));
	}


	@Override
	public void print(PrintStream out) {
		for (int i=this.size()-1; i>=0; --i) {
			out.println(this.elements[i]);
		}
		
	}

}
