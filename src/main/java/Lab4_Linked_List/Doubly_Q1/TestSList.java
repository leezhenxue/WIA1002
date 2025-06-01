package Lab4_Linked_List.Doubly_Q1;

public class TestSList {
    public static void main(String[] args) {
        SList<String> node = new SList<>("Linked list");
        node.appendEnd("is");
        node.appendEnd("easy");
        node.display();
        System.out.println("Removed value: " + node.removeInitial());
        System.out.println(node.contains("dificult"));
        node.clear();
    }
}
