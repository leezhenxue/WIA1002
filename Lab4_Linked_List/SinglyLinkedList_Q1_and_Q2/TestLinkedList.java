package SinglyLinkedList_Q1_and_Q2;
public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.addFirst('a');
        linkedList.addLast('e');
        linkedList.add(1, 'b');
        linkedList.add(2, 'c');
        linkedList.add(3, 'd');
        linkedList.print();
        System.out.println("The middle value: " + linkedList.getMiddleValue());
        linkedList.reverse();
        linkedList.print();
        System.out.println("The number of elements: " + linkedList.size);
        System.out.println("The first value: " + linkedList.getFirst());
        System.out.println("The last value: " + linkedList.getLast());
        linkedList.remove(2);
        System.out.print("After remove third value: ");
        linkedList.print();
        System.out.println("The middle value: " + linkedList.getMiddleValue());
        System.out.println("The index location of second value(d): " + linkedList.indexOf('d'));
        System.out.println("The index location of third value(b): " + linkedList.indexOf('b'));
        System.out.println(linkedList.contains('c'));
        linkedList.set(0, 'j');
        linkedList.set(1, 'a');
        linkedList.set(2, 'v');
        linkedList.set(3, 'a');
        System.out.print("After changing the items to 'java': ");
        linkedList.print();
        System.out.println("The middle value: " + linkedList.getMiddleValue());

        

    } 

}
