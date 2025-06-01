package Lab6_Queues.Q1;

public class TestProgram {
    public static void main(String[] args) {
        String[] fruits = {"Durian", "Blueberry"};
        MyQueue fruitQ = new MyQueue<String>(fruits);
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        System.out.println(fruitQ.toString());
        System.out.println("First element: " + fruitQ.peek());
        System.out.println("Size: " + fruitQ.getSize());
        System.out.println("Delete \"Durain\": " + fruitQ.remove("Durian"));
        System.out.println("Item in index position 2: " + fruitQ.getElement(2));
        System.out.println("\"Cherry\" in the queue: " + fruitQ.contains("Cherry"));
        System.out.println("\"Durian\" in the queue: " + fruitQ.contains("Durian"));
        fruitQ.isEmpty();
        fruitQ.toString();
    }
}
