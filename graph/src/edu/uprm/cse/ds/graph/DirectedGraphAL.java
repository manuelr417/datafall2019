package edu.uprm.cse.ds.graph;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import edu.uprm.cse.ds.hashtable.HashtableSC;
import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
import edu.uprm.cse.ds.queue.DoublyLinkedQueue;
import edu.uprm.cse.ds.queue.Queue;
import edu.uprm.cse.ds.util.OrderedPair;
import edu.uprm.cse.ds.util.OrderedPairImp;

public class DirectedGraphAL<E> implements Graph<E> {
	
	private List<Vertex<E>> vertexList; 
	

	
	public DirectedGraphAL() {
		super();
		this.vertexList = new SinglyLinkedList<>();
		
	}

	@Override
	public Iterable<Vertex<E>> getVertices() {
		return this.vertexList;
	}

	@Override
	public Iterable<Edge<E>> getEdges() {
		List<Edge<E>> result = new SinglyLinkedList<>();
		for (Vertex<E> v: this.vertexList) {
			for (Edge<E> e  : v.edges()) {
				result.add(e);
			}
		}
		return result;
	}


	@Override
	public Vertex<E> getVertex(E label) {
		for (Vertex<E> o : this.vertexList) {
			if (o.getLabel().equals(label)) {
				return o;
			}
		}
		return null;
	}

	@Override
	public boolean addVertex(E label) {
		if (!this.containsVertex(label)) {
			this.vertexList.add(new VertexImp<>(label));
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean connectEdge(E label1, E label2, double weight) {
		if (!this.containsEdge(label1, label2)) {
			// verify that the vertices with these labels exist
			Vertex<E> u = this.getVertex(label1);
			Vertex<E> v = this.getVertex(label2);
			if ((u == null) || (v == null)) {
				return false; // one of u or v is not in the vertex list
			}
			else {
				// add the edge
				u.connectEdge(v, weight);
				return true;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public boolean connectEdge(E label1, E label2) {
		return this.connectEdge(label1, label2, 0.0);
	}

	@Override
	public boolean containsVertex(E label) {
		return this.getVertex(label) != null;
	}

	@Override
	public boolean containsEdge(E label1, E label2) {
		return this.getEdge(label1, label2) != null;
	}

	@Override
	public Edge<E> getEdge(E label1, E label2) {
		Vertex<E> u = this.getVertex(label1);
		Vertex<E> v = this.getVertex(label2);
		
		if ((u == null) || (v == null)) {
			return null;
		}
		else {
			return u.getEdge(v);
		}

	}

	@Override
	public double getWeight(E label1, E label2) {
		Edge<E> e = this.getEdge(label1, label2);
		if (e == null) {
			return Double.POSITIVE_INFINITY;
		}
		else {
			return e.getWeight();
		}
	}

	@Override
	public int vertexCount() {
		return this.vertexList.size();
	}

	@Override
	public int edgeCount() {
		int result = 0;
		
		for (Vertex<E> v : this.vertexList) {
			result += v.edgeCount();
		}
		return result;
	}

	@Override
	public OrderedPair<Iterable<Vertex<E>>, Integer> depthFirstSearch(E label) {
		if (!this.containsVertex(label)) {
			// avoid bugs by throwing an exception here
			// do not run dfs on non existing vertex
			throw new IllegalArgumentException("No vertex with the given label exits."); 
		}
		else {
			List<Vertex<E>> L = new SinglyLinkedList<Vertex<E>>();
			OrderedPair<Iterable<Vertex<E>>, Integer> result = null;
			Vertex<E> u = this.getVertex(label);

			int count = 0;
			this.dfsAux(u, L);
			count = L.size();
			result = new OrderedPairImp<>(L, count);
			return result;
		}
	}

	private void dfsAux(Vertex<E> u, List<Vertex<E>> L) {
		Vertex<E> v = null;
		// mark u as visited
		u.visit();
		//now loop adding what is reachable 
		for (Edge<E> e : u.edges()) {
			v = e.getEndVertex();
			if (!v.isVisited()) {
				L.add(v);
				this.dfsAux(e.getEndVertex(), L);
			}
		}	
	}

	@Override
	public OrderedPair<Iterable<Vertex<E>>, Integer> breathFirstSearch(E label) {
		if (!this.containsVertex(label)) {
			// avoid bugs by throwing an exception here
			// do not run dfs on non existing vertex
			throw new IllegalArgumentException("No vertex with the given label exits."); 
		}
		else {
			List<Vertex<E>> L = new SinglyLinkedList<Vertex<E>>();
			OrderedPair<Iterable<Vertex<E>>, Integer> result = null;
			Vertex<E> u = this.getVertex(label);
			Queue<Vertex<E>> Q = new DoublyLinkedQueue<>();
			Vertex<E> v = this.getVertex(label);

			
			u.visit();
			Q.enqueue(u);
			while(!Q.isEmpty()) {
				v = Q.dequeue();
				if (!v.isVisited()) {
					v.visit();
					L.add(v);
					for (Edge<E> e : v.edges()) {
						Q.enqueue(e.getEndVertex());
					}
				}
			}
			result = new OrderedPairImp<>(L, L.size());
			return result;
		}
	}

	@Override
	public Map<E, Iterable<Edge<E>>> shortestPathDijkstra(E source) {
		Map<E, Iterable<Edge<E>>> result = new HashMap<>(this.vertexCount());
		// Initialize C
		Map<String, Double> C = null;
		Map<E, Double> D= null;
		Map<E, E> predecessors = null;
		C = this.initC();

		D = this.initD(source, C);
		predecessors = this.initPredecessors(source);
		
		Vertex<E> v = this.getVertex(source);
		Vertex<E> u = null;
		v.visit();
		//predecessors.put(v.getLabel(), v.getLabel());
		int counter = this.vertexCount();
		for (int i=0; i <counter; ++i) {
			u = finMinUnvisited(D);
			if (u != null) {
				u.visit();
				for (Vertex<E> v2: u.neighbors()) {
					this.relax(u, v2, D, C, predecessors);
				}
			}
		}
		result = this.buildBackPath(v, this.getVertices(), this.vertexList.size(), predecessors);
		return result;
	}




	private Map<E, E> initPredecessors(E source) {
		Map<E, E> result = new HashMap<>(this.vertexCount());
		
		for (Vertex<E> v : this.vertexList) {
			if (!v.getLabel().equals(source)) {
				result.put(v.getLabel(), source);
			}
		}
		return result;
	}

	private Map<E, Iterable<Edge<E>>> buildBackPath(Vertex<E> source, Iterable<Vertex<E>> vertices, int vertexCount, Map<E, E> predecessors) {
		Map<E, Iterable<Edge<E>>> result = new HashMap<>(vertexCount);
		List<Edge<E>> path = null;
		E predecessor = null;
		System.out.println("SOURC: " + source.getLabel());
		for (Vertex<E> v : vertices) {
			path = new SinglyLinkedList<>();
			boolean done = false;
			Vertex<E> u = v;
			while (!done) {
				predecessor = predecessors.get(u.getLabel());
				if (predecessor != null) {
					path.add(this.getEdge(predecessor, u.getLabel()), 0);
					u = this.getVertex(predecessor);
					if (source.getLabel().equals(predecessor)) {
						done = true; // we reach the source node
					}
				}
				else {
					// no way to reach v from the source
					done = true;
				}
			}
			result.put(v.getLabel(), path);
		}
		return result;
	}

	private void relax(Vertex<E> u, Vertex<E> v, Map<E, Double> D, Map<String, Double> C, 
			Map<E, E> predecessors) {
		OrderedPair<E, E> p = null;
		p = new OrderedPairImp<>(u.getLabel(), v.getLabel());
		double vDist = 0.0, uDist = 0.0, uvDist = 0.0;
		
		vDist = D.get(v.getLabel());
		uDist = D.get(u.getLabel());
		uvDist = C.get(p.toString());
		
		if (vDist > (uDist + uvDist)) {
			D.put(v.getLabel(), uDist + uvDist);
			predecessors.put(v.getLabel(), u.getLabel());
		}
		
	}

	private Vertex<E> finMinUnvisited(Map<E, Double> D) {
		double min = Double.POSITIVE_INFINITY;
		Vertex<E> minV =null;
		for (Vertex<E> v : this.unVisited()) {
			if (D.get(v.getLabel()) < min){
				min = 	D.get(v.getLabel());
				minV = v;
			}
		}
		return minV;
	}

	private Map<String, Double> initC() {
		Map<String, Double>  result= new HashMap<>(this.vertexCount());
		OrderedPair<E, E> p = null;
		// initialize all pairs of edges
		for (Vertex<E> u : this.vertexList) {
			for (Vertex<E> v: this.vertexList) {
				p = new OrderedPairImp<E, E>(u.getLabel(), v.getLabel());
				

				if (u.equals(v)) {
					System.out.printf("(%s, %s) - %f \n", p.getFirst(), p.getSecond(), 0.0);
					result.put(p.toString(), new Double(0.0));
				}
				else {
					System.out.printf("(%s, %s) - %f \n", p.getFirst(), p.getSecond(), this.getWeight(u.getLabel(), v.getLabel()));

					result.put(p.toString(), new Double(this.getWeight(u.getLabel(), v.getLabel())));
				}
			}
		}
		return result;
	}

	private Map<E, Double> initD(E source, Map<String, Double> C) {
		 Map<E, Double> D = new HashMap<>(this.vertexCount());
		 OrderedPair<E, E> p = null;
		 for (Vertex<E> v: this.vertexList) {
			 if (!v.getLabel().equals(source)) {
				 p = new OrderedPairImp<E, E>(source, v.getLabel());
				 System.out.printf("(%s, %s) \n", p.getFirst(), p.getSecond());
				 if (C.get(p.toString()) == null) {
					 System.out.printf("PR libre\n");
 
				 }
				 D.put(v.getLabel(), C.get(p.toString()).doubleValue());
			 }
		 }
		return D;
	}

	@Override
	public Iterable<Vertex<E>> unVisited() {
		List<Vertex<E>> L = new SinglyLinkedList<>();
		for (Vertex<E> v : this.vertexList) {
			if (!v.isVisited()) {
				L.add(v);
			}
		}
		return L;
	}

	@Override
	public void print(PrintStream P) {
		for (Vertex<E> v: this.vertexList) {
			P.print(v.getLabel()+ ": ");
			for (Vertex<E> u: v.neighbors()) {
				P.printf("(%s, %s, %f)  ", v.getLabel(), u.getLabel(), this.getWeight(v.getLabel(), u.getLabel()));
			}
			P.println();
		}
	}

	@Override
	public void unvisitAll() {
		for (Vertex<E> v : this.vertexList) {
			v.unVisit();
		}
		
	}
	
}
