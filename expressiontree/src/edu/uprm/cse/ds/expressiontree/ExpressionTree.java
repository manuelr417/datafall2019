package edu.uprm.cse.ds.expressiontree;

public class ExpressionTree {
	
	private BinaryTreeNode<Integer> root;

	public ExpressionTree(BinaryTreeNode<Integer> root) {
		super();
		this.root = root;
	}
	
	public Integer getValue() {
		return this.root.getValue();
	}
	
	@Override
	public String toString() {
		return this.root.toString();
	}

}
