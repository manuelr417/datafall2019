package edu.uprm.cse.ds.stack.maintest;

import edu.uprm.cse.ds.stack.ArrayStack;
import edu.uprm.cse.ds.stack.Stack;

public class StackTester {

	public static void main(String[] args) {
		Stack<String> S = new ArrayStack<String>();
		
		// Add Elements
		S.push("Bob");
		S.push("Ned");
		S.push("Moe");
		S.push("Ron");
		S.push("Kim");
		
		System.out.println("Stack: ");
		S.print(System.out);
		
		S.pop();
		S.pop();
		S.push(S.pop());
		S.push(S.top());
		
		System.out.println();
		System.out.println("Stack: ");
		S.print(System.out);



	}

}
