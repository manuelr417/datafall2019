package edu.uprm.cse.ds.bst.test;

import java.util.Comparator;

import edu.uprm.cse.ds.bst.BinarySearchTree;
import edu.uprm.cse.ds.list.List;

public class BSTTest {

	public static class StringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	public static void main(String[] args) {
		BinarySearchTree<String, String> T = 
				new BinarySearchTree<>(new StringComparator());
		
		T.put("Joe", "Joe Smith");
		T.put("Ned", "Ned Perez");
		T.put("Jil", "Jil Li");
		T.put("Amy", "Amy Diaz");
		T.put("Ron", "Ron Diaz");
		T.put("Al", "Al Capone");

		T.print(System.out);
		
		List<String> L = T.getKeys();
		for (String s : L) {
			System.out.println(s);
		}
		System.out.println();

		L = T.getValues();
		for (String s : L) {
			System.out.println(s);
		}

	}

}
