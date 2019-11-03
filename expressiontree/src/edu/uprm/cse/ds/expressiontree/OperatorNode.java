package edu.uprm.cse.ds.expressiontree;

public class OperatorNode implements BinaryTreeNode<Integer> {

	private OperatorType op;
	private BinaryTreeNode<Integer> parent;
	private BinaryTreeNode<Integer> leftChild;
	private BinaryTreeNode<Integer> rightChild;

	
	public OperatorNode(OperatorType op, BinaryTreeNode<Integer> parent, BinaryTreeNode<Integer> leftChild,
			BinaryTreeNode<Integer> rightChild) {
		super();
		this.op = op;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.leftChild.setParent(this);
		this.rightChild.setParent(this);
	}

	@Override
	public Integer getValue() {
		Integer left = this.getLeftChild().getValue();
		Integer right = this.getRightChild().getValue();
		
		if (this.op == OperatorType.PLUS) {
			return left + right;
		}
		else if (this.op == OperatorType.MINUS) {
			return left - right;

		}
		else if (this.op == OperatorType.MULT) {
			return left * right;

		}
		else if (this.op == OperatorType.DIV) {
			return left / right;

		}
		else  {
			return left % right;
		}
	}

	@Override
	public BinaryTreeNode<Integer> getLeftChild() {
		return this.leftChild;
	}

	@Override
	public BinaryTreeNode<Integer> getRightChild() {
		return this.rightChild;
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
		String result = null;
		switch(op) {
		case PLUS:
			result =  "(" + this.leftChild.toString() + "+" + 
				this.rightChild.toString() + ")";
			break;

		case MINUS:
			result =  "(" + this.leftChild.toString() + "-" + 
				this.rightChild.toString() + ")";
			break;
			
		case MULT:
			result =  "(" + this.leftChild.toString() + "*" + 
				this.rightChild.toString() + ")";
			break;
		case DIV:
			result =  "(" + this.leftChild.toString() + "/" + 
				this.rightChild.toString() + ")";
			break;
		default:
			result =  "(" + this.leftChild.toString() + "%" + 
				this.rightChild.toString() + ")";
			break;
		}
		return result;
	}
}
