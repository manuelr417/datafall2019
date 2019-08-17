package edu.uprm.cse.datastructures.list.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uprm.cse.datastructures.list.ArrayList;
import edu.uprm.cse.datastructures.list.List;
import junit.framework.Assert;

public class ArrayListTest {

	private List<String> L;
	
	@Before
	public void setUp() throws Exception {
		this.L = new ArrayList<String>();
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
		fail("Not yet implemented");
	}

	@Test
	public void testIsMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexOf() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddE() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplace() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented");
	}

}
