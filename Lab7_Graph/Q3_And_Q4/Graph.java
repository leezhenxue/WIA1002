package Q3_And_Q4;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>, N extends Comparable <N>> {

    Vertex<T,N> head;
    int size;

    public Graph() {
        head = null;
        size = 0;
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

    public int getSize() {
        return this.size;
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


    public boolean addEdge(T source, T destination, N weight) {
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
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, currentEdge, weight);
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
    public boolean addEdge(T source, T destination) {
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
                        Edge<T, N> newEdge = new Edge<>(destinationVertex, currentEdge);
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
