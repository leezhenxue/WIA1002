package Lab4_Linked_List.Doubly_Q3;

public class Node<E> {
    E element;
    Node<E> previous;
    Node<E> next;

    public Node() {
        this.element = null;
        this.previous = null;
        this.next = null;
    }

    public Node(E e) {
        this.element = e;
        this.previous = null;
        this.next = null;
    }
}
