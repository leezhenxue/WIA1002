package Lab7_Graph.Q3_And_Q4;
// WIA/WIB1002 Data Structures
// part of Graphs implementation using List

import java.util.ArrayList;

class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {

    Vertex<T, N> head;
    int size;

    public WeightedGraph() {
        head = null;
        size = 0;
    }

    public void clear() {
        head = null;
    }

    public int getSize() {
        return this.size;
    }

    public int getIndeg(T v) {
        if (hasVertex(v) == true) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0) {
                    return temp.indeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public int getOutdeg(T v) {
        if (hasVertex(v) == true) {
            Vertex<T, N> temp = head;
            while (temp != null) {
                if (temp.vertexInfo.compareTo(v) == 0) {
                    return temp.outdeg;
                }
                temp = temp.nextVertex;
            }
        }
        return -1;
    }

    public boolean hasVertex(T v) {
        if (head == null) {
            return false;
        }
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                return true;
            }
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T v) {
        if (hasVertex(v) == false) {
            Vertex<T, N> temp = head;
            Vertex<T, N> newVertex = new Vertex<>(v, null);
            if (head == null) {
                head = newVertex;
            } else {
                Vertex<T, N> previous = head;
                while (temp != null) {
                    previous = temp;
                    temp = temp.nextVertex;
                }
                previous.nextVertex = newVertex;
            }
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addUndirectedEdge(T source, T destination, N w) {
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
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, w, destinationVertex.firstEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        //second edge
                        Edge<T, N> newEdge2 = new Edge<>(sourceVertex, w, sourceVertex.firstEdge);
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

    // public boolean removeEdge(T source, T destination) {
    //     if (head == null) {
    //         System.out.println("The graph is empty");
    //         return false;
    //     }
    //     if (!hasVertex(source) || !hasVertex(destination)) {
    //         return false;
    //     }
    //     Vertex<T, N> sourceVertex = head;
    //     while (sourceVertex != null) {
    //         if (sourceVertex.vertexInfo.compareTo(source) == 0) {
    //             Edge<T, N> currentEdge = sourceVertex.firstEdge;
    //             Edge<T, N> previousEdge = null;
    //             while (currentEdge != null) {
    //                 if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
    //                     if (previousEdge == null) {
    //                         sourceVertex.firstEdge = currentEdge.nextEdge;
    //                     } else {
    //                         previousEdge.nextEdge = currentEdge.nextEdge;
    //                     }
    //                     sourceVertex.outdeg++;
    //                     currentEdge.toVertex.indeg++;
    //                     return true;
    //                 }
    //                 previousEdge = currentEdge;
    //                 currentEdge = currentEdge.nextEdge;
    //             }
    //         }
    //         sourceVertex = sourceVertex.nextVertex;
    //     }
    //     return false;
    // }

    //test write again removeEdge() method
    public boolean removeEdge(T source, T destination) {
        if (head == null || !hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        Vertex<T, N> currentVertex = head;
        while (currentVertex != null) {
            if (currentVertex.vertexInfo.equals(source)) {
                Edge<T, N> currentEdge = currentVertex.firstEdge;
                Edge<T, N> previousEdge = null;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.equals(destination)) {
                        if (previousEdge == null) {
                            currentVertex.firstEdge = currentEdge.nextEdge;
                        }
                        else {
                            previousEdge.nextEdge = currentEdge.nextEdge;
                        }
                    }
                    previousEdge = currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            currentVertex = currentVertex.nextVertex;
        }
        return false;
    }

    public int getIndex(T v) {
        Vertex<T, N> temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                return pos;
            }
            temp = temp.nextVertex;
            pos += 1;
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            list.add(temp.vertexInfo);
            temp = temp.nextVertex;
        }
        return list;
    }

    public ArrayList<Vertex<T, N>> getAllVertices() {
        ArrayList<Vertex<T, N>> list = new ArrayList<>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.nextVertex;
        }
        return list;
    }

    public T getVertex(int pos) {
        if (pos > size - 1 || pos < 0) {
            return null;
        }
        Vertex<T, N> temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.nextVertex;
        }
        return temp.vertexInfo;
    }

    public boolean addEdge(T source, T destination, N w) {
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
                        Edge<T, N> currentEdge = sourceVertex.firstEdge;
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean hasEdge(T source, T destination) {
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
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) // destination vertex found 
                    {
                        return true;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public N getEdgeWeight(T source, T destination) {
        N notFound = null;
        if (head == null) {
            return notFound;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return notFound;
        }
        Vertex<T, N> sourceVertex = head;
        while (sourceVertex != null) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                // Reached source vertex, look for destination now 
                Edge<T, N> currentEdge = sourceVertex.firstEdge;
                while (currentEdge != null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) // destination vertex found 
                    {
                        return currentEdge.weight;
                    }
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return notFound;
    }

    public ArrayList<T> getNeighbours(T v) {
        if (!hasVertex(v)) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        Vertex<T, N> temp = head;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(v) == 0) {
                // Reached vertex, look for destination now
                Edge<T, N> currentEdge = temp.firstEdge;
                while (currentEdge != null) {
                    list.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return list;
    }

    public void printEdges() {
        Vertex<T, N> temp = head;
        while (temp != null) {
            System.out.print("# " + temp.vertexInfo + " : ");
            Edge<T, N> currentEdge = temp.firstEdge;
            while (currentEdge != null) {
                System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo + "] ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }

}
