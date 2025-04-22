package Doubly_Q3;

public class TestProgram {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(100);
        list.addIndex(2, 2);
        list.removeIndex(2);
        list.traverseForward();
        list.traverseBackward();
        System.out.println("size of current Doubly Linked List: " + list.getSize());
        list.clear();
        System.out.println("size of current Doubly Linked List: " + list.getSize());

    }

}
