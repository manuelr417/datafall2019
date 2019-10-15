package edu.uprm.cse.ds.map.test;

import edu.uprm.cse.ds.map.LinkedListMap;
import edu.uprm.cse.ds.map.Map;

public class MapTest {
	
	public static class Person {
		private int Id;
		private String FirstName;
		private String LastName;
		private int Age;
		private String City;
		public Person(int id, String firstName, String lastName, int age, String city) {
			super();
			Id = id;
			FirstName = firstName;
			LastName = lastName;
			Age = age;
			City = city;
		}
		public int getId() {
			return Id;
		}
		public String getFirstName() {
			return FirstName;
		}
		public String getLastName() {
			return LastName;
		}
		public int getAge() {
			return Age;
		}
		public String getCity() {
			return City;
		}
		@Override
		public String toString() {
			return "Person [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Age=" + Age
					+ ", City=" + City + "]";
		}
		
		
		
	}
	
	public static void main(String[] argv) {
		Map<Integer, Person> M = new LinkedListMap<>();
		
		M.put(1, new Person(1, "Joe", "Smith", 18, "NY"));
		M.put(2, new Person(2, "Kim", "Zoe", 34, "SF"));
		M.put(3, new Person(3, "Apu", "Ortiz", 21, "LA"));
		M.put(4, new Person(4, "Lu", "Li", 23, "DC"));
		
		System.out.println("Element with Key 1: " + M.get(1));
		System.out.println("Element with Key 4: " + M.get(4));
		System.out.println("Element with Key 3: " + M.get(3));
		System.out.println("Element with Key 2: " + M.get(2));
		
		// Iterate over Keys
		System.out.println();
		System.out.println("Keys: ");
		for (Integer i : M.getKeys()) {
			System.out.println(i);
		}
		
		// Iterate over Values
		System.out.println();
		System.out.println("Values: ");
		for (Person p : M.getValues()) {
			System.out.println(p);
		}

		System.out.println();
		Person p = M.put(1, new Person(1, "Ken", "Bee", 17, "KC"));
		System.out.println("Element with Key 1: " + M.get(1));
		System.out.println("Old Element with Key 1: " + p);
		
		System.out.println();
		p = M.remove(2);
		System.out.println("Element with Key 2: " + M.get(2));
		System.out.println("Old Element with Key 2: " + p);
		System.out.println("Constains Key 2: " + M.contains(2));
		
		
		// Iterate over Keys
		System.out.println();
		System.out.println("Keys: ");
		for (Integer i : M.getKeys()) {
			System.out.println(i);
		}
		
		// Iterate over Values
		System.out.println();
		System.out.println("Values: ");
		for (Person p2 : M.getValues()) {
			System.out.println(p2);
		}


		

	}

}
