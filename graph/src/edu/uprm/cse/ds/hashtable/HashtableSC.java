package edu.uprm.cse.ds.hashtable;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
import edu.uprm.cse.ds.map.Map;

public class HashtableSC<K, V> implements Map<K, V> {
	
	public static class MapEntry<K,V> {
		private K key;
		private V value;
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
		}
		
		
	}

	private int currentSize;
	private Object[] buckets;
	private static final int DEFAULT_BUCKETS = 11;
	
	private int hashFunction(K key) {
		return key.hashCode() % this.buckets.length;
	}
	
	public HashtableSC(int numBuckets) {
		this.currentSize  = 0;
		this.buckets = new Object[numBuckets];
		for (int i =0; i < numBuckets; ++i) {
			this.buckets[i] = new SinglyLinkedList<MapEntry<K,V>>();
		}
	}
	
	public HashtableSC() {
		this(DEFAULT_BUCKETS);
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
		int targetBucket = this.hashFunction(key);
		List<MapEntry<K,V>> L = (List<MapEntry<K,V>>) this.buckets[targetBucket];
		
		for (MapEntry<K, V> M : L) {
			if (M.getKey().equals(key)) {
				return M.getValue();
			}
		}
		return null;
				
	}

	@Override
	public V put(K key, V value) {
		V oldValue = this.get(key);
		if (oldValue != null) {
			this.remove(key);
		}
		int targetBucket = this.hashFunction(key);
		List<MapEntry<K,V>> L = (List<MapEntry<K,V>>) this.buckets[targetBucket];
		MapEntry<K,V> M = new MapEntry<K,V>(key, value);
		L.add(M, 0);
		this.currentSize++;

		return oldValue;
	}

	@Override
	public V remove(K key) {
		int targetBucket = this.hashFunction(key);
		List<MapEntry<K,V>> L = (List<MapEntry<K,V>>) this.buckets[targetBucket];
		int i=0;
		
		for (MapEntry<K,V> M: L ) {
			if (M.getKey().equals(key)) {
				// borrar
				V result = M.getValue();
				L.remove(i);
				this.currentSize--;
				return result;
			}
			else {
				i++;
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return this.get(key) != null;
	}

	@Override
	public List<K> getKeys() {
		List<K> result = new SinglyLinkedList<>();
		
		for (Object o : this.buckets) {
			List<MapEntry<K,V>> L = (List<MapEntry<K,V>>) o;
			for (MapEntry<K,V> M : L) {
				result.add(M.getKey(), 0);
			}
		}
		return result;
	}

	@Override
	public List<V> getValues() {
		List<V> result = new SinglyLinkedList<>();
		
		for (Object o : this.buckets) {
			List<MapEntry<K,V>> L = (List<MapEntry<K,V>>) o;
			for (MapEntry<K,V> M : L) {
				result.add(M.getValue(), 0);
			}
		}
		return result;
	}

}
