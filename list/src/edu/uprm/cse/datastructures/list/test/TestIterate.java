package edu.uprm.cse.datastructures.list.test;

import java.util.Iterator;

import edu.uprm.cse.datastructures.list.ArrayList;
import edu.uprm.cse.datastructures.list.List;
import edu.uprm.cse.datastructures.list.SinglyLinkedList;

public class TestIterate {

	public static void main(String[] args) {
		//List<String> L = new ArrayList<String>();
		List<String> L = new SinglyLinkedList<String>();

		L.add("Kim");
		L.add("Ned");
		L.add("Ron");
		L.add("Jil");
		L.add("Amy");
		L.add("Ron");
		
		// To Array
		System.out.println("with toArray");
		for (Object c : L.toArray()) {
			System.out.println(c);
		}
		
		// for each with iterator
		System.out.println("\n with iterator");
		for (String s : L) {
			System.out.println(s);
		}
		
		// Old method to use iterators
		System.out.println("\n with  old school iterator");
		Iterator<String> I = L.iterator();
		while (I.hasNext()) {
			System.out.println(I.next());
		}
		
	}

}
