package edu.uprm.cse.ds.expressiontree.test;

import edu.uprm.cse.ds.expressiontree.BinaryTreeNode;
import edu.uprm.cse.ds.expressiontree.ExpressionTree;
import edu.uprm.cse.ds.expressiontree.OperatorNode;
import edu.uprm.cse.ds.expressiontree.OperatorType;
import edu.uprm.cse.ds.expressiontree.ValueNode;

public class ExpressionTreeTest {

	public static void main(String[] args) {

		// evaluate (10 - 2) + (2 * 5)
		BinaryTreeNode<Integer> N1 = null;
		BinaryTreeNode<Integer> N2 = null;
		BinaryTreeNode<Integer> N3 = null;
		BinaryTreeNode<Integer> N4 = null;
		BinaryTreeNode<Integer> N5 = null;

		N1 = new ValueNode(10, null);
		N2 = new ValueNode(2, null);
		N3 = new OperatorNode(OperatorType.MINUS, null, N1, N2);
		
		N1 = new ValueNode(2, null);
		N2 = new ValueNode(5, null);;
		N4 = new OperatorNode(OperatorType.MULT, null, N1, N2);

		N5 = new OperatorNode(OperatorType.PLUS, null, N3, N4);
		
		ExpressionTree T = new ExpressionTree(N5);
		
		System.out.println("Expression String: " + T);

		System.out.println("Expression: " + T.getValue());
		BinaryTreeNode<Integer> N6 = null;
		N6 = new OperatorNode(OperatorType.MULT, null, N5, N4);
		T = new ExpressionTree(N6);
		System.out.println("Expression String: " + T);

		System.out.println("Expression: " + T.getValue());


	}

}
