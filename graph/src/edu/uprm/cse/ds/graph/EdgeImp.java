package edu.uprm.cse.ds.graph;

public class EdgeImp<E> implements Edge<E> {
	
	private double weight;
	
	private Vertex<E> startVertex;
	
	private Vertex<E> endVertex;


	public EdgeImp( Vertex<E> startVertex, Vertex<E> endVertex, double weight) {
		super();
		this.weight = weight;
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}

	public EdgeImp( Vertex<E> startVertex, Vertex<E> endVertex) {
		super();
		this.weight = 0.0;
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public Vertex<E> getEndVertex() {
		return this.endVertex;
	}

	@Override
	public Vertex<E> getStartVertex() {
		return this.startVertex;
	}

	@Override
	public boolean equals(Edge<E> e) {
		return this.startVertex.equals(e.getStartVertex()) &&
				this.endVertex.equals(e.getEndVertex());
	}

}
