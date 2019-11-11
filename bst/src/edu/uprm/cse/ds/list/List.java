package edu.uprm.cse.ds.list;

public interface List<E> extends Iterable<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isMember(E e);

	public void add(E e);
	
	public void add(E e, int index);
	
	public E first();
	
	public E last();
	
	public int firstIndex(E e);
	
	public int lastIndex(E e);
	
	public E get(int index);
	
	public E replace(E e, int index);
	
	public E remove(int index);
	
	public boolean remove(E e);
	
	public int removeAll(E e);
	
	public void clear();
	
	public Object[] toArray();
	

}
