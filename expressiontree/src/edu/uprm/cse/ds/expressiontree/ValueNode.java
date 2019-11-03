package edu.uprm.cse.ds.expressiontree;

public class ValueNode implements BinaryTreeNode<Integer> {

	private Integer value;
	
	private BinaryTreeNode<Integer> parent;
	
	
	public ValueNode(Integer value, BinaryTreeNode<Integer> parent) {
		super();
		this.value = value;
		this.parent = parent;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}

	@Override
	public BinaryTreeNode<Integer> getLeftChild() {
		return null;
	}

	@Override
	public BinaryTreeNode<Integer> getRightChild() {
		return null;
	}

	@Override
	public BinaryTreeNode<Integer> getParent() {
		return this.parent;
	}

	@Override
	public BinaryTreeNode<Integer> getSibling() {
		if (this.parent.getLeftChild() == this) {
			return this.parent.getRightChild();
		}
		else {
			return this.parent.getLeftChild();
		}
	}

	@Override
	public void setParent(BinaryTreeNode<Integer> p) {
		this.parent = p;		
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}

}
