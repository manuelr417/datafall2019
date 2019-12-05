package edu.uprm.cse.ds.graph;

public interface Vertex<E> {
	
	public E getLabel();
		
	public boolean isVisited();
	
	public void visit();
	
	public void unVisit();
	
	public boolean connectEdge(Vertex<E> v, double weight);
	
	public boolean connectEdge(Vertex<E> v);
	
	public Iterable<Vertex<E>> neighbors();
	
	public Iterable<Edge<E>> edges();
	
	public boolean equals(Vertex<E> v);

	public boolean containsEdge(Vertex<E> v);
	
	public Edge<E> getEdge(Vertex<E> v);

	public int edgeCount();

}
