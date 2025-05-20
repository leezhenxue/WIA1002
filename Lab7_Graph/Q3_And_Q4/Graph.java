package Q3_And_Q4;

public class Graph<T extends Comparable<T>, N extends Comparable <N>> extends WeightedGraph<T, N> {

    public boolean addEdge(T source, T destination) {
        return super.addEdge(source, destination, null);
    }

    public boolean addUndirectedEdge(T source, T destination) {
        if (head == null) {
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex, look for destination now
                Vertex<T, N> destinationVertex = head;
                while (destinationVertex != null) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        // Reached destination vertex, add edge here
                        //first edge
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, null, destinationVertex.firstEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        //second edge
                        Edge<T, N> newEdge2 = new Edge<>(sourceVertex, null, sourceVertex.firstEdge);
                        destinationVertex.firstEdge = newEdge2;
                        destinationVertex.outdeg++;
                        sourceVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

}
