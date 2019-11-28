package edu.uprm.cse.ds.graph;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;

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
	public Iterable<Vertex<E>> depthFirstSearch(E label) {
		// TODO Auto-generated method stub
		return null;
	}
}
