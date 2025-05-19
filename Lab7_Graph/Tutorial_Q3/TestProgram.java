package Tutorial_Q3;

public class TestProgram {
    public static void main(String[] args) {
        String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        Graph<String> graph = new Graph<>();
        for (String elem : vertexs) {
            graph.addVertex(elem);
        }

        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "E");
        graph.addEdge("E", "G");
        graph.addEdge("F", "H");
        graph.addEdge("G", "H");
        graph.addEdge("H", "I");

        graph.printEdges();
    }
}
