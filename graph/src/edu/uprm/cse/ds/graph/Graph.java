package edu.uprm.cse.ds.graph;

import java.io.PrintStream;
import java.util.Map;

import edu.uprm.cse.ds.util.OrderedPair;

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
		
	public OrderedPair<Iterable<Vertex<E>>, Integer> depthFirstSearch(E label);
	
	public OrderedPair<Iterable<Vertex<E>>, Integer> breathFirstSearch(E label);
	
	public Map<E, Iterable<Edge<E>>> shortestPathDijkstra(E source);
	
	public Iterable<Vertex<E>> unVisited();
	
	public void print(PrintStream P);
	
	public void unvisitAll();
}
