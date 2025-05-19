public boolean addEdge(T source, T destination, N w)   {
      if (head==null)
         return false;
      if (!hasVertex(source) || !hasVertex(destination)) 
         return false;
      Vertex<T,N> sourceVertex = head;
      while (sourceVertex!=null)	{
         if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
            // Reached source vertex, look for destination now
            Vertex<T,N> destinationVertex = head;
            while (destinationVertex!=null)	{
               if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
                  // Reached destination vertex, add edge here
                  Edge<T,N> currentEdge = sourceVertex.firstEdge;
                  Edge<T,N> newEdge = new Edge<>(destinationVertex, w, currentEdge);
                  sourceVertex.firstEdge=newEdge;
                  sourceVertex.outdeg++;
                  destinationVertex.indeg++;
                  return true;
               }
               destinationVertex=destinationVertex.nextVertex;
            }
         }
         sourceVertex=sourceVertex.nextVertex;
      }
      //add another edge from destination to source
      Vertex<T,N> destinationVertex = head;
      while (destinationVertex!=null)	{
         if ( destinationVertex.vertexInfo.compareTo( destination ) == 0 )   {
            // Reached destination vertex, look for source now
            Vertex<T,N> sourceVertex = head;
            while (sourceVertex!=null)	{
               if ( sourceVertex.vertexInfo.compareTo( source ) == 0 )   {
                  // Reached source vertex, add edge here
                  Edge<T,N> currentEdge = destinationVertex.firstEdge;
                  Edge<T,N> newEdge = new Edge<>(sourceVertex, w, currentEdge);
                  destinationVertex.firstEdge=newEdge;
                  destinationVertex.outdeg++;
                  sourceVertex.indeg++;
                  return true;
               }
               sourceVertex=sourceVertex.nextVertex;
            }
         }
         destinationVertex=destinationVertex.nextVertex;
      }
      return false;
   }