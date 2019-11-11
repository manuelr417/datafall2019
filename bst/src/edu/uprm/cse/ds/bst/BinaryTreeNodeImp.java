package edu.uprm.cse.ds.bst;

public class BinaryTreeNodeImp<E> implements BinaryTreeNode<E> {
	
	private E value;
	
	private BinaryTreeNode<E>  leftChild;
	private BinaryTreeNode<E>  rightChild;
	private BinaryTreeNode<E>  parent;


	public BinaryTreeNodeImp(E value, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild,
			BinaryTreeNode<E> parent) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}

	@Override
	public E getValue() {
		return this.value;
	}

	@Override
	public BinaryTreeNode<E> getLeftChild() {
		return this.leftChild;
	}

	@Override
	public BinaryTreeNode<E> getRightChild() {
		return this.rightChild;
	}

	@Override
	public BinaryTreeNode<E> getParent() {
		return this.parent;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public void setLeftChild(BinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(BinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

	public void setParent(BinaryTreeNode<E> parent) {
		this.parent = parent;
	}


}
