package edu.uprm.cse.ds.map;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;

public class LinkedListMap<K, V> implements Map<K, V> {
	
	private static class MapEntry<K,V> {
		private K key;
		private V value;
		
		
		public MapEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
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
		
		
	}

	private List<MapEntry<K,V>> elements;
	
	public LinkedListMap() {
		this.elements = new SinglyLinkedList<>();
		
	}
	@Override
	public int size() {
		return this.elements.size();
	}

	@Override
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	@Override
	public V get(K key) {
		for (MapEntry<K,V> M : this.elements) {
			if (M.getKey().equals(key)) {
				return M.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		MapEntry<K,V> newEntry = new MapEntry<>(key, value);
		V result = this.remove(key);
		this.elements.add(newEntry, 0);
		return result;
	}

	@Override
	public V remove(K key) {
		int i=0;
		
		for (MapEntry<K,V> M : this.elements) {
			if (M.getKey().equals(key)) {
				MapEntry<K,V> temp = this.elements.remove(i);
				return temp.getValue();				
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
		for (MapEntry<K,V> M : this.elements) {
			result.add(M.getKey());
		}
		return result;
	}

	@Override
	public List<V> getValues() {
		List<V> result = new SinglyLinkedList<>();
		for (MapEntry<K,V> M : this.elements) {
			result.add(M.getValue());
		}
		return result;
	}

}
