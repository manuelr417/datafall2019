package edu.uprm.cse.datastructures.set.test;
// comment for eclipse to work
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uprm.cse.datastructures.set.ArraySet;
import edu.uprm.cse.datastructures.set.Set;

public class ArraySetTest {
	private Set<String> S1 = new ArraySet<>();
	private Set<String> S2 = new ArraySet<>();

	@Before
	public void setUp() throws Exception {
		S1.add("Ned");
		S1.add("Ken");
		S1.add("Jil");
		S1.add("Ron");
		S1.add("Bob");
		
		S2.add("Amy");
		S2.add("Bob");
		S2.add("Ned");

	}

	@Test
	public void testSize() {
		assertTrue(S1.size() == 5);
		assertTrue(S2.size() == 3);
	}

	@Test
	public void testIsEmpty() {
		S1.clear();
		assertTrue(S1.isEmpty());
		S1.add("Ron");
		S1.clear();
		assertTrue(S1.isEmpty());

	}

	@Test
	public void testAdd() {
		assertFalse(S1.isMember("Cal"));
		S1.add("Cal");
		assertTrue(S1.isMember("Cal"));
	}

	@Test
	public void testIsMember() {
		assertTrue(S1.isMember("Ned"));
		assertTrue(S1.isMember("Jil"));
		assertTrue(S1.isMember("Bob"));
		assertFalse(S1.isMember("Kim"));

	}

	@Test
	public void testRemove() {
		assertTrue(S2.isMember("Amy"));
		assertTrue(S2.remove("Amy"));
		assertFalse(S2.isMember("Amy"));
		assertFalse(S1.remove("Lu"));

	}

	@Test
	public void testClear() {
		S1.clear();
		assertTrue(S1.isEmpty());
		S2.clear();
		assertTrue(S2.isEmpty());
	}

	@Test
	public void testIsSubset() {
		S1.add("Amy");
		assertTrue(S2.isSubset(S1));
		assertTrue(S1.isSubset(S1));
		assertFalse(S1.isSubset(S2));

	}

	@Test
	public void testUnion() {
		Set<String> S3 = null;
		S3 = S1.union(S2);
		assertTrue(S3.isMember("Ron"));
		assertTrue(S3.isMember("Amy"));
		assertTrue(S3.size() == 6);


	}

	@Test
	public void testDifference() {
		Set<String> S3 = null;
		S3 = S1.difference(S2);
		assertTrue(S3.isMember("Ken"));
		assertTrue(S3.isMember("Jil"));
		assertTrue(S3.isMember("Ron"));
		assertFalse(S3.isMember("Ned"));
		
		S3 = S2.difference(S1);
		assertTrue(S3.isMember("Amy"));
		assertTrue(S3.size()==1);

		assertTrue(S1.difference(S1).isEmpty());
	}

	@Test
	public void testIntersection() {
		Set<String> S3 = null;
		S3 = S1.intersection(S2);
		assertTrue(S3.isMember("Bob"));
		assertTrue(S3.isMember("Ned"));
		assertTrue(S3.size() == 2);

		S3 = S2.intersection(S1);
		assertTrue(S3.isMember("Bob"));
		assertTrue(S3.isMember("Ned"));
		assertTrue(S3.size() == 2);


	}

}
