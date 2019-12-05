package edu.uprm.cse.ds.graph;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;

public class VertexImp<E> implements Vertex<E> {
	
	private E label;
	private boolean visited;
	private List<Edge<E>> adjacencyList;
	

	public VertexImp(E label) {
		super();
		this.label = label;
		this.visited = false;
		this.adjacencyList = new SinglyLinkedList<Edge<E>>();
	}


	@Override
	public E getLabel() {
		return this.label;
	}


	@Override
	public boolean isVisited() {
		return this.visited;
	}

	@Override
	public void visit() {
		this.visited = true;
	}

	@Override
	public void unVisit() {
		this.visited = false;
	}

	@Override
	public boolean connectEdge(Vertex<E> v, double weight) {
		// First determine if edge already exists 
		// if so, quit
		for (Edge<E> e: this.adjacencyList) {
			if (e.getEndVertex().equals(v)) {
				return false; // edge already present
			}
		}
		this.adjacencyList.add(new EdgeImp<E>(this, v, weight));
		return true;
	}

	@Override
	public boolean connectEdge(Vertex<E> v) {
		return this.connectEdge(v, 0.0);
	}

	@Override
	public Iterable<Vertex<E>> neighbors() {
		List<Vertex<E>> result = new SinglyLinkedList<Vertex<E>>();
		
		for (Edge<E> e : this.adjacencyList) {
			result.add(e.getEndVertex());
		}
		return result;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		return this.adjacencyList;
	}


	@Override
	public boolean equals(Vertex<E> v) {
		return this.label.equals(v.getLabel());
	}


	@Override
	public boolean containsEdge(Vertex<E> v) {
		return this.getEdge(v) != null;
	}


	@Override
	public Edge<E> getEdge(Vertex<E> v) {
		for (Edge<E>  e: this.adjacencyList) {
			if (e.getEndVertex().equals(v)) {
				return e;
			}
		}
		return null;
	}


	@Override
	public int edgeCount() {
		return this.adjacencyList.size();
	}

}
