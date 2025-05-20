package Q3_And_Q4;

// WIA/WIB1002 Data Structures
// part of Graphs implementation using List
class Edge<T extends Comparable<T>, N extends Comparable <N>> {
	Vertex<T,N> toVertex;
	N weight;
	Edge<T,N> nextEdge;
	
	public Edge()	{
		toVertex = null;
		nextEdge = null;
		weight = null;
	}
	
	public Edge(Vertex<T,N> destination, N w, Edge<T,N> a)	{
		toVertex = destination;
		weight = w;
		nextEdge = a;
	}

}
