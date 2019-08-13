package edu.uprm.cse.datastructures.bag.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.uprm.cse.datastructures.bag.Bag;
import edu.uprm.cse.datastructures.bag.DynamicBag;

public class DynamicBagTest {
	
	private Bag B;

	@Before
	public void setUp() throws Exception {
		B = new DynamicBag();
		B.add("Joe");
		B.add("Ned");
		B.add("Kim");
		B.add("Joe");
		
	}

	@Test
	public void testSize() {
		assertTrue(B.size() == 4);
	}
	
	@Test 
	public void testCount() {
		assertTrue(B.count("Ned") == 1);
		assertTrue(B.count("Joe") == 2);
		assertTrue(B.count("Meg") == 0);

	}

	@Test
	public void testIsMember() {
		assertTrue(B.isMember("Ned"));
		assertTrue(B.isMember("Joe"));
		assertTrue(B.isMember("Kim"));


	}
	@Test
	public void testAdd() {
		B.add("Ron");
		assertTrue(B.isMember("Ron"));
		B.add("Li");
		assertTrue(B.isMember("Li"));
		B.add("Lo");
		assertTrue(B.isMember("Lo"));

	}
	@Test
	public void testRemove() {
		assertTrue(B.remove("Kim"));
		assertFalse(B.isMember("Kim"));
		assertTrue(B.remove("Joe"));
		assertTrue(B.isMember("Joe"));
	}
	@Test
	public void testRemoveAll() {
		assertTrue(B.removeAll("Kim") == 1);
		assertFalse(B.isMember("Kim"));
		assertTrue(B.removeAll("Joe") == 2);
		assertFalse(B.isMember("Joe"));
	}

	
}
