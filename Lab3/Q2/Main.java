package Lab3.Q2;

public class Main {

    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        BagInterface<String> bag2 = new ArrayBag<>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        System.out.print("Bag 1: ");
        bag1.display();
        System.out.print("Bag 2: ");
        bag2.display();

        BagInterface<String> everything = bag1.union(bag2);

        System.out.print("Union of bags: ");
        for (Object item : everything.toArray()) {
            System.out.print(item + " ");
        }

        BagInterface<String> commonItems = bag1.intersection(bag2);

        System.out.print("\nIntersection of bags: ");
        for (Object item : commonItems.toArray()) {
            System.out.print(item + " ");
        }
    }
}
