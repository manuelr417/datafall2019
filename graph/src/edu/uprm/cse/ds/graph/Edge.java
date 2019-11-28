package edu.uprm.cse.ds.graph;

public interface Edge<E> {
	
	public double getWeight();
	
	public Vertex<E> getEndVertex();
	
	public Vertex<E> getStartVertex();
	
	public boolean equals(Edge<E> e);

}
