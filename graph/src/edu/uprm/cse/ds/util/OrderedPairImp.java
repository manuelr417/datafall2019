package edu.uprm.cse.ds.util;

public class OrderedPairImp<T, E> implements OrderedPair<T, E> {

	private T first;
	
	private E second;

	
	public OrderedPairImp(T first, E second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public T getFirst() {
		return this.first;
	}

	@Override
	public E getSecond() {
		return this.second;
	}

	@Override
	public boolean equals(OrderedPair<T, E> p) {
		return this.getFirst().equals(p.getFirst()) &&
				this.getSecond().equals(p.getSecond());
	}
	
	@Override
	public String toString() {
		return "(" + this.first + "," + this.second + ")";
	}

}
