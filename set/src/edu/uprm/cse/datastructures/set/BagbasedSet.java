package edu.uprm.cse.datastructures.set;
// Comment for eclipse to work
import edu.uprm.cse.datastructures.bag.Bag;
import edu.uprm.cse.datastructures.bag.DynamicBag;

public class BagbasedSet<E> implements Set<E> {
	// This is called object composition and it is preferred over inheritance 
	private Bag<E> theBag; 

	
	public BagbasedSet(int initialSize) {
		this.theBag = new DynamicBag<E>(initialSize);
	}
	
	public BagbasedSet() {
		this.theBag = new DynamicBag<E>();
	}
	
	@Override
	public int size() {
		return this.theBag.size();
	}

	@Override
	public boolean isEmpty() {
		return this.theBag.isEmpty();
	}

	@Override
	public void add(E e) {
		if (!this.isMember(e)) {
			this.theBag.add(e);
		}

	}

	@Override
	public boolean isMember(E e) {
		return this.theBag.isMember(e);
	}

	@Override
	public boolean remove(E e) {
		return this.theBag.remove(e);
	}

	@Override
	public void clear() {
		this.theBag.clear();

	}

	@Override
	public boolean isSubset(Set<E> S) {
		E[] elements = this.theBag.toArray();
		for (int i=0; i < this.size(); ++i) {
			if (!S.isMember(elements[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<E> union(Set<E> S) {
		Set<E> result = new BagbasedSet<>(this.size() + S.size());
		E[] temp = this.toArray();
		for (int i=0; i < this.size(); ++i) {
			result.add(temp[i]);
		}
		temp = S.toArray();
		for (int i=0; i < this.size(); ++i) {
			if (!result.isMember(temp[i])) {
				result.add(temp[i]);
			}
		}
		return result;
	}

	@Override
	public Set<E> difference(Set<E> S) {
		Set<E> result = new BagbasedSet<>(this.size());
		E[] temp = this.toArray();
		for (int i=0; i < this.size(); ++i) {
			if (!S.isMember(temp[i])) {
				result.add(temp[i]);
			}
		}
		return result;
	}

	@Override
	public Set<E> intersection(Set<E> S) {
		return this.difference(this.difference(S));
	}

	@Override
	public E[] toArray() {
		return this.theBag.toArray();
	}

}
