package Tutorial_Q3;

// WIA/WIB1002 Data Structures
// part of Graphs implementation using List
class Edge<T extends Comparable<T>> {
	Vertex<T> toVertex;
	Edge<T> nextEdge;
	
	public Edge()	{
		toVertex = null;
		nextEdge = null;
	}
	
	public Edge(Vertex<T> destination, Edge<T> a) {
		toVertex = destination;
		nextEdge = a;
	}

}
