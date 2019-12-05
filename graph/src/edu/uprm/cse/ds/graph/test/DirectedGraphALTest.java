package edu.uprm.cse.ds.graph.test;

import java.util.HashMap;
import java.util.Map;

import edu.uprm.cse.ds.graph.DirectedGraphAL;
import edu.uprm.cse.ds.graph.Edge;
import edu.uprm.cse.ds.graph.Vertex;
import edu.uprm.cse.ds.hashtable.HashtableSC;
import edu.uprm.cse.ds.util.OrderedPair;
import edu.uprm.cse.ds.util.OrderedPairImp;

public class DirectedGraphALTest {

	public static void main(String[] args) {
		DirectedGraphAL<String> G = new DirectedGraphAL<>();
		G.addVertex("Joe");
		G.addVertex("Jil");
		G.addVertex("Tom");
		G.addVertex("Apu");
		G.addVertex("Amy");
		
		G.connectEdge("Joe", "Jil", 10);
		
		G.connectEdge("Joe", "Tom", 3);
		
		G.connectEdge("Tom", "Jil", 1);
		
		G.connectEdge("Tom", "Apu", 3);
		
		G.connectEdge("Amy", "Apu", 5);
		
		G.connectEdge("Apu", "Amy", 16);
		G.connectEdge("Tom", "Amy", 20);
		
		G.print(System.out);
		
		OrderedPair<Iterable<Vertex<String>>, Integer>  P = G.depthFirstSearch("Tom");
		
		System.out.println("Reach from Tom");
		testBFS(P);
		G.unvisitAll();
		
		System.out.println("Reach from Joe");
		P = G.depthFirstSearch("Joe");
		testBFS(P);

		Map<OrderedPair<String, String>, Double > M2 = new HashMap<>();
		M2.put(new OrderedPairImp<String, String>("Joe", "Jil"), 3.155);
		if (M2.get(new OrderedPairImp<String, String>("Joe", "Jil")) == null) {
			System.out.println("HQJ");
		}
		else {
			System.out.println("WTF");

		}
		
		HashMap<OrderedPair<String, String>, Double> M3 = new HashMap<>();
		M3.put(new OrderedPairImp<String, String>("Joe", "Jil"), 3.155);
		if (M3.get(new OrderedPairImp<String, String>("Joe", "Jil")) == null) {
			System.out.println("HQJ ^ 2");
		}
		else {
			System.out.println("WTF - my HT suckea");

		}
		
		HashMap<String, Double> M4 = new HashMap<>();
		M4.put(new String("Joe" + "Jil"), 3.155);
		if (M4.get("Joe" + "Jil") == null) {
			System.out.println("HQJ ^ 2");
		}
		else {
			System.out.println("WTF - my HT suckea");

		}

		G.unvisitAll();
		Map<String, Iterable<Edge<String>>> M = G.shortestPathDijkstra("Joe");
		
		System.out.println("Shortest Paths from Joe: ");

		for (Vertex<String> v: G.getVertices()) {
			System.out.print(v.getLabel() + ": ");
			for (Edge<String> e : M.get(v.getLabel())){
				System.out.printf("(%s, %s, %f) ", e.getStartVertex().getLabel(), e.getEndVertex().getLabel(),
						e.getWeight());
			}
			System.out.println();
		}
		System.out.println("Done");

	}

	private static void testBFS(OrderedPair<Iterable<Vertex<String>>, Integer> P) {
		System.out.println("Reachable: " + P.getSecond());
		System.out.print("Nodes: ");

		for (Vertex<String> v : P.getFirst()) {
			System.out.print(v.getLabel() + " ");
		}
		System.out.println();
		

	}

}
