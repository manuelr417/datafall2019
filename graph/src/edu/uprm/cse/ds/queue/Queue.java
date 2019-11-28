package edu.uprm.cse.ds.queue;

import java.io.PrintStream;

public interface Queue<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public E front();
	
	public E dequeue();
	
	public void enqueue(E e);
	
	public void makeEmpty();
	
	public void print(PrintStream P);

}
