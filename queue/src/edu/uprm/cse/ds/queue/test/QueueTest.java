package edu.uprm.cse.ds.queue.test;

import edu.uprm.cse.ds.queue.DoublyLinkedQueue;
import edu.uprm.cse.ds.queue.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> Q = new DoublyLinkedQueue<>();
		
		Q.enqueue("Ron");
		Q.enqueue("Ned");
		Q.enqueue("Jil");
		Q.enqueue("Amy");
		Q.print(System.out);
		System.out.println();
		Q.enqueue("Ken");
		Q.dequeue();
		Q.dequeue();
		Q.print(System.out);
	}

}
