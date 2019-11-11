package edu.uprm.cse.ds.bst;

public interface BinaryTreeNode<E> extends TreeNode<E> {
	
	public BinaryTreeNode<E> getLeftChild();
	
	public BinaryTreeNode<E> getRightChild();
	
	public BinaryTreeNode<E> getParent();
	

}
