public boolean removeEdge(T source, T destination) {
        if (head == null) {
            System.out.println("The graph is empty");
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                Edge<T, N> previousEdge = null;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        if (previousEdge == null) {
                            sourceVertex.firstEdge = currentEdge.nextEdge;
                        } else {
                            previousEdge.nextEdge = currentEdge.nextEdge;
                        }
                        sourceVertex.outdeg++;
                        currentEdge.toVertex.indeg++;
                        return true;
                     }
                     previousEdge = currentEdge;
                     currentEdge = currentEdge.nextEdge;
                }

            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }
