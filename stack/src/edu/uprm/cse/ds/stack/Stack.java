package edu.uprm.cse.ds.stack;

import java.io.PrintStream;

public interface Stack<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public E top();
	
	public E pop();

	public void push(E e);
	
	public void clear();
	
	public void print(PrintStream out);
	
}
