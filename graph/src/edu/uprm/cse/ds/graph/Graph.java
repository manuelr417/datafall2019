package edu.uprm.cse.ds.graph;

public interface Graph<E> {
	
	public Iterable<Vertex<E>> getVertices();
	
	public Iterable<Edge<E>> getEdges();
	
	public Vertex<E> getVertex(E label);
	
	public boolean addVertex(E label);
	
	public boolean containsVertex(E label);
	
	public boolean connectEdge(E label1, E label2, double weight);
	
	public boolean connectEdge(E label1, E label2);
	
	public boolean containsEdge(E label1, E label2);
	 
	public Edge<E> getEdge(E label1, E label2);

	public double getWeight(E label1, E label2);
	
	public int vertexCount();
	
	public int edgeCount();
	
	public Iterable<Vertex<E>> depthFirstSearch(E label);
}
