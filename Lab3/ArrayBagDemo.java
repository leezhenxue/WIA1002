package Lab3.Q2;

public class ArrayBagDemo {

    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>();
        BagInterface<String> bag2 = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("bag1: ");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);

        System.out.println("Bag2: ");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);

        System.out.println("bag3, test the method union of bag1 and bag2: ");
        BagInterface<String> bag3 = bag1.union(bag2);
        displayBag(bag3);

        System.out.println("bag4, test the methos intersection of bag1 and bag2: ");
        BagInterface<String> bag4 = bag1.intersection(bag2);
        displayBag(bag4);
        
        System.out.println("bag5, test the method difference of bag1 and bag2: ");
        BagInterface bag5 = bag1.difference(bag2);
        displayBag(bag5);
    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding ");
        for (String item : content) {
            System.out.print(item + " ");
            aBag.add(item);
        }
        System.out.println();
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follow:");
        for (Object item : aBag.toArray()) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
