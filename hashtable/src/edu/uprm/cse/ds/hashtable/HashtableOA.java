package edu.uprm.cse.ds.hashtable;

import edu.uprm.cse.ds.hashtable.HashtableSC.MapEntry;
import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
import edu.uprm.cse.ds.map.Map;

public class HashtableOA<K, V> implements Map<K, V> {
	
	public static enum State{
		NEVER_USER, FULL, EMPTY;
	}
	
	public static class MapEntry<K,V> {
		private K key;
		private V value;
		private State state;
		
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public MapEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
			this.setState(State.FULL);
		}
		
		public MapEntry() {
			super();
			this.key = null;
			this.value = null;
			this.setState(State.NEVER_USER);
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
	
		
	}

	private int currentSize;
	private Object[] buckets;
	private static final int DEFAULT_BUCKETS = 11;
	
	
	public HashtableOA(int numBuckets) {
		this.currentSize  = 0;
		this.buckets = new Object[numBuckets];
		for (int i =0; i < numBuckets; ++i) {
			this.buckets[i] = new MapEntry<>();
		}

	}

	public HashtableOA() {
		
		this(DEFAULT_BUCKETS);
	}

	private int hashFunction(K key) {
		return key.hashCode() % this.buckets.length;
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
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<K> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> getValues() {
		// TODO Auto-generated method stub
		return null;
	}

}
