package edu.uprm.cse.ds.util;

public interface OrderedPair<T, E> {
	
	public T getFirst();
	
	public E getSecond();
	
	public boolean equals(OrderedPair<T,E> p);
	

}
