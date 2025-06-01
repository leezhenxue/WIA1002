package Lab4_Linked_List.Doubly_Q1;

public class SNode<E> {
    E element;
    SNode<E> previous;
    SNode<E> next;

    public SNode() {
        this.element = null;
        this.previous = null;
        this.next = null;
    }

    public SNode(E e) {
        this.element = e;
        this.previous = null;
        this.next = null;
    }
}
