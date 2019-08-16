package edu.uprm.cse.datastructures.bag;

public class DynamicBag<E> implements Bag<E>{

	private E[] elements;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;

	public DynamicBag(int initialSize) {
		if (initialSize < 1) {
			throw new IllegalArgumentException("Size must be at least 1");
		}
		this.elements = (E[]) new Object[initialSize];
		this.currentSize = 0;
	}

	public DynamicBag() {
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
	public void add(E e) {
		if (e == null) {
			throw new IllegalArgumentException("Argument cannot be null");
		}

		if (this.size() == this.elements.length) {
			this.reAllocate();
		}
		this.elements[this.currentSize++] = e;

	}
    private void reAllocate() {
        E temp[] = (E[]) new Object[2*this.size()];
        for (int i=0; i < this.size(); ++i) {
                temp[i] = this.elements[i];
        }
        this.elements = temp;
}
	
	@Override
	public boolean isMember(E e) {
		return this.count(e) > 0;
	}

	@Override
	public boolean remove(E e) {
        for (int i=0; i < this.size(); ++i) {
            if (this.elements[i].equals(e)) {
                    this.elements[i] = this.elements[this.currentSize-1];
                    this.elements[this.currentSize-1] = null;
                    --this.currentSize;
                    return true;
            }
        }
        return false;
	}

	@Override
	public int removeAll(E e) {
        int result = 0;
        while(this.remove(e)) {
                result++;
        }
        return result;

	}

	@Override
	public int count(E e) {
        int result = 0;
        for (int i=0; i < this.size(); ++i) {
                if (this.elements[i].equals(e)) {
                        result++;
                }
        }
        return result;

	}

	@Override
	public void clear() {
        for (int i=0; i < this.size(); ++i) {
            this.elements[i] = null;
        }
        this.currentSize = 0;           
	}

	@Override
	public E[] toArray() {
		E result[] = (E[]) new Object[this.size()];
		
		for (int i=0; i < this.size(); ++i) {
			result[i]  = this.elements[i];
		}
		
		return result;
	}
}
