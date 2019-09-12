package edu.uprm.cse.datastructures.list.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.uprm.cse.datastructures.list.ArrayList;
import edu.uprm.cse.datastructures.list.List;
import edu.uprm.cse.datastructures.list.SinglyLinkedList;

public class SinglyLinkedListTest {

	private List<String> L;
	
	@Before
	public void setUp() throws Exception {
		this.L = new SinglyLinkedList<String>();
		this.L.add("Kim");
		this.L.add("Ned");
		this.L.add("Ron");
		this.L.add("Jil");
		this.L.add("Amy");
		this.L.add("Ron");
	}

	@Test
	public void testSize() {
		assertTrue("Size of list must be 6", this.L.size() == 6);
	}

	@Test
	public void testIsEmpty() {
		this.L.clear();
		assertTrue("Fails to detect empty list", this.L.isEmpty());
	}

	@Test
	public void testIsMember() {
		assertTrue("Fails to detect Kim in the list", this.L.isMember("Kim"));
		assertTrue("Fails to detect Amy in the list", this.L.isMember("Amy"));
		assertFalse("Fails to detect that Bob is not in the list", this.L.isMember("Bob"));

	}

	@Test
	public void testIndexOf() {
		assertTrue("Fails to detect Kim at position 0", this.L.firstIndexOf("Kim") ==0);
		assertTrue("Fails to detect Ron at position 2", this.L.firstIndexOf("Ron") ==2);
		assertTrue("Fails to detect that Xi is has negative index ", this.L.firstIndexOf("Xi") < 0);

	}

	@Test
	public void testAddE() {
		this.L.add("Xi");
		assertTrue("Fails to detect Xi in the list", this.L.isMember("Xi"));
		this.L.add("Moe");
		assertTrue("Fails to detect Moe at position 7", this.L.firstIndexOf("Moe") ==7);

	}

	@Test
	public void testAddEInt() {
		this.L.add("Xi", 0);
		assertTrue("Fails to detect Xi in the list", this.L.isMember("Xi"));
		assertTrue("Fails to detect Kim at position 1", this.L.firstIndexOf("Kim") ==1);
		
		assertTrue("Fails to detect Jil at position 4", this.L.firstIndexOf("Jil") ==4);
		this.L.add("Moe", 4);
		assertTrue("Fails to detect Moe at position 4", this.L.firstIndexOf("Moe") ==4);
		assertTrue("Fails to detect Jil at position 5", this.L.firstIndexOf("Jil") ==5);

	}

	@Test
	public void testGet() {
		assertTrue("Fails to detect Kim in the list at position 0", this.L.get(0).equals("Kim"));
		assertTrue("Fails to detect Ron in the list at position 2", this.L.get(2).equals("Ron"));
		assertTrue("Fails to detect Ron in the list at position 5", this.L.get(5).equals("Ron"));

	}

	@Test
	public void testRemove() {
		assertTrue("Fails to detect Kim in the list at position 0", this.L.get(0).equals("Kim"));
		this.L.remove(0);
		assertTrue("Fails to detect Ned in the list at position 0", this.L.get(0).equals("Ned"));

		assertTrue("Fails to detect Amy in the list at position 3", this.L.get(3).equals("Amy"));
		this.L.remove(3);
		assertTrue("Fails to detect Ron in the list at position 3", this.L.get(3).equals("Ron"));
	}

	@Test
	public void testReplace() {
		assertTrue("Fails to detect Kim in the list at position 0", this.L.get(0).equals("Kim"));
		this.L.replace(0, "Xi");
		assertTrue("Fails to detect Xi in the list at position 0", this.L.get(0).equals("Xi"));

		assertTrue("Fails to detect Ron in the list at position 2", this.L.get(2).equals("Ron"));
		this.L.replace(2, "Cal");
		assertTrue("Fails to detect Cal in the list at position 2", this.L.get(2).equals("Cal"));

	}

	@Test
	public void testClear() {
		assertTrue("Fails to detect list with 6 elements", this.L.size() ==6);
		this.L.clear();
		assertTrue("Fails to detect empty list", this.L.isEmpty());

	}

	@Test
	public void testToArray() {
		Object[] data = this.L.toArray();
		assertTrue("Fails to detect array with 6 elements", data.length ==6);
		assertTrue("Fails to detect Kim at position 0", data[0].equals("Kim"));

	}

}
