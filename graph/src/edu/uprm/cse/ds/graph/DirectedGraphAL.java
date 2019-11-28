package edu.uprm.cse.ds.graph;

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
	
	
}
