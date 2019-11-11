package edu.uprm.cse.ds.bst;

import java.util.Comparator;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.map.Map;

public class BinarySearchTree<K, V> implements Map<K, V> {
	
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

	private int currentSize;
	private BinaryTreeNode<MapEntry<K,V>> root;
	private Comparator<K> keyComparator;
	
	public BinarySearchTree(Comparator<K> keyComparator) {
		this.root = null;
		this.currentSize = 0;
		this.keyComparator = keyComparator;
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
		return this.getAux(key, this.root);
		
	}

	private V getAux(K key, BinaryTreeNode<MapEntry<K, V>> N) {
		if (N == null) {
			return null; // not found
		}
		else {
			int comparison = this.keyComparator.compare(key, N.getValue().getKey());
			if (comparison == 0) {
				return N.getValue().getValue();
			}
			else if (comparison < 0) {
				return this.getAux(key, N.getLeftChild());
			}
			else {
				return this.getAux(key, N.getRightChild());
			}
		}
	}

	@Override
	public V put(K key, V value) {
		if (this.root == null) {
			MapEntry<K,V> M = new MapEntry<K,V>(key, value);
			this.root = new 
					BinaryTreeNodeImp<MapEntry<K,V>>(M, null, null, null);
			this.currentSize++;
			return value;
		}
		else {
			return this.putAux(key, value, (BinaryTreeNodeImp<MapEntry<K, V>>) this.root);
		}
	}

	private V putAux(K key, V value, BinaryTreeNodeImp<MapEntry<K, V>> N) {
		int comparison = this.keyComparator.compare(key,  N.getValue().getKey());
		if (comparison < 0) {
			// left
			if (N.getLeftChild() == null) {
				MapEntry<K,V> M = new MapEntry<K,V>(key, value);
				BinaryTreeNodeImp<MapEntry<K,V>> newNode =
						new BinaryTreeNodeImp<MapEntry<K,V>> 
				(M, null, null, N);
				N.setLeftChild(newNode);
				this.currentSize++;
				return value;
			}
			else {
				return this.putAux(key, value, 
						(BinaryTreeNodeImp<MapEntry<K, V>>) N.getLeftChild());
			}
		}
		else {
			// right
			if (N.getRightChild() == null) {
				MapEntry<K,V> M = new MapEntry<K,V>(key, value);
				BinaryTreeNodeImp<MapEntry<K,V>> newNode =
						new BinaryTreeNodeImp<MapEntry<K,V>> 
				(M, null, null, N);
				N.setRightChild(newNode);
				this.currentSize++;
				return value;
			}
			else {
				return this.putAux(key, value, 
						(BinaryTreeNodeImp<MapEntry<K, V>>) N.getRightChild());
			}
			
		}
	}

	@Override
	public V remove(K key) {
		if (this.root == null) {
			return null;
		}
		else {
			int comparison = this.keyComparator.compare(key, this.root.getValue().getKey());
			if (comparison == 0) {
				// remove from root
				if (this.isLeaf(this.root)) {
					V result = this.root.getValue().getValue();
					((BinaryTreeNodeImp<MapEntry<K, V>>) this.root).setValue(null);
					this.root = null;
					this.currentSize--;
					return result;
					
				}
				else {
					return null;
				}
			}
			else if (comparison < 0) {
				// remove from left
				return this.removeAux(key, this.root.getLeftChild());
			}
			else {
				//remore right
				return this.removeAux(key, this.root.getRightChild());

			}
		}
	}

	private boolean isLeaf(BinaryTreeNode<MapEntry<K, V>> N) {
		return N.getLeftChild() == null && N.getRightChild() == null;
	}

	private V removeAux(K key, BinaryTreeNode<MapEntry<K, V>> N) {
		// TODO Auto-generated method stub
		return null;
	}

	private BinaryTreeNodeImp<MapEntry<K, V>> smallestChild(
			BinaryTreeNodeImp<MapEntry<K, V>> N) {
		BinaryTreeNodeImp<MapEntry<K, V>> temp = N;
		
		while (temp.getLeftChild() != null) {
			temp = (BinaryTreeNodeImp<MapEntry<K, V>>) temp.getLeftChild();
		}
		return temp;
		
	}
	@Override
	public boolean contains(K key) {
		return this.get(key) != null;
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
