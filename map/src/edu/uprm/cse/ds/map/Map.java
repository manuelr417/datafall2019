package edu.uprm.cse.ds.map;

import edu.uprm.cse.ds.list.List;

public interface Map<K, V> {
	
	public int size();
	
	public boolean isEmpty();
	
	public V get(K key);
	
	public V put(K key, V value);
	
	public V remove(K key);
	
	public boolean contains(K key);
	
	public List<K> getKeys();
	
	public List<V> getValues();
	
	

}
