package edu.uprm.cse.ds.expressiontree;

public interface BinaryTreeNode<E> extends TreeNode<E> {
	
	public BinaryTreeNode<E> getLeftChild();
	
	public BinaryTreeNode<E> getRightChild();
	
	public BinaryTreeNode<E> getParent();
	
	public BinaryTreeNode<E> getSibling();

	public void setParent(BinaryTreeNode<E> p);
	@Override
	public String toString();

}
