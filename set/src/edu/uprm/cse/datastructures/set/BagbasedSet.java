package edu.uprm.cse.datastructures.set;

import edu.uprm.cse.datastructures.bag.Bag;

public class BagbasedSet<E> implements Set<E> {
	// This is called object composition and it is preferred over inheritance 
	private Bag<E> elements; 

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMember(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSubset(Set<E> S) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<E> union(Set<E> S) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> difference(Set<E> S) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> intersection(Set<E> S) {
		// TODO Auto-generated method stub
		return null;
	}

}
