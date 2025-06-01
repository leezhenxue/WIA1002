package Lab7_Graph.Tutorial_Q3;

// WIA/WIB1002 Data Structures
// part of Graphs implementation using List
class Vertex<T extends Comparable<T>> {
   T vertexInfo;
   int indeg;
   int outdeg;
   Vertex<T> nextVertex;
   Edge<T> firstEdge;
    
   public Vertex() {
      vertexInfo=null;
      indeg=0;
      outdeg=0;
      nextVertex = null;
      firstEdge = null;
   }
	
   public Vertex(T vInfo, Vertex<T> next) {
      vertexInfo = vInfo;
      indeg=0;
      outdeg=0;
      nextVertex = next;
      firstEdge = null;
   }	
}

