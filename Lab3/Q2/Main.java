package Lab3.Q2;

public class Main {
    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        BagInterface<String> bag2 = new ArrayBag<>();
        bag1.add("b");
        bag1.add("b");
        bag1.add("d");
        bag1.add("e");

        BagInterface<String> everything = bag1.union(bag2);

        System.out.println("Union of bags: ");
        for (String item : everything.toArray()) {
            System.out.print(item + " ");
        }

        BagInterface<String> commonItems = bag1.intersection(bag2);

        System.out.println("Intersection of bags: ");
        for (String item : everything.toArray()) {
            System.out.print(item + " ");
        }
    }
}
