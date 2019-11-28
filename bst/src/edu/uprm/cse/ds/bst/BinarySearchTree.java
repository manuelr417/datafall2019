package edu.uprm.cse.ds.bst;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
import edu.uprm.cse.ds.map.Map;

public class BinarySearchTree<K, V> implements Map<K, V> {
	
	private static class MapEntry<K,V> implements KeyValuePair<K,V> {
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
				else if (this.root.getRightChild() == null) {
					V result = this.root.getValue().getValue();
					this.root = this.root.getLeftChild();
					this.currentSize--;
					return result;
				}
				else {
					V result = this.root.getValue().getValue();
					BinaryTreeNodeImp<MapEntry<K, V>> S = 
							this.smallestChild((BinaryTreeNodeImp<MapEntry<K, V>>) this.root.getRightChild());
					((BinaryTreeNodeImp<MapEntry<K, V>>) this.root).setValue(S.getValue());;
					this.removeAux(S.getValue().getKey(), this.root.getRightChild());
					return result;
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
		List<K> result = new SinglyLinkedList<K>();
		this.getKeysAux(this.root, result);
		return result;
		
	}

	private void getKeysAux(BinaryTreeNode<MapEntry<K, V>> N, List<K> result) {
		if (N == null) {
			return;
		}
		else {
			this.getKeysAux(N.getLeftChild(), result);
			result.add(N.getValue().getKey());
			this.getKeysAux(N.getRightChild(), result);
		}
	}

	@Override
	public List<V> getValues() {
		List<V> result = new SinglyLinkedList<V>();
		this.getValuesAux(this.root, result);
		return result;
		

	}

	private void getValuesAux(BinaryTreeNode<MapEntry<K, V>> N, List<V> result) {
		if (N == null) {
			return;
		}
		else {
			this.getValuesAux(N.getLeftChild(), result);
			result.add(N.getValue().getValue());
			this.getValuesAux(N.getRightChild(), result);
		}
		
	}

	public void print(PrintStream out) {
		printAux(this.root, out, 0);
		
		
	}
	
	public void printAux(BinaryTreeNode<MapEntry<K, V>> N, 
			PrintStream out, int spaces) {
		if (N == null) {
			return;
		}
		else {
			printAux(N.getRightChild(), out, spaces + 4);
			// print this values
			for (int i=0; i< spaces; ++i) {
				out.print(" ");
			}
			out.println(N.getValue().getKey());
			printAux(N.getLeftChild(), out, spaces + 4);
			
		}
	}

}
