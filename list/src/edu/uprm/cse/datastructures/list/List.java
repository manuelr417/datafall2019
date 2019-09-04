package edu.uprm.cse.datastructures.list;

public interface List<E> extends Iterable<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isMember(E e);
	
	public int firstIndexOf(E e);
	
	public int lastIndexOf(E e);

	public void add(E e);
	
	public void add(E e, int position);
	
	public E get(int position);
	
	public E remove(int position);
	
	public E replace(int position, E newElement);
	
	public void clear();
	
	public Object[] toArray();	

}
