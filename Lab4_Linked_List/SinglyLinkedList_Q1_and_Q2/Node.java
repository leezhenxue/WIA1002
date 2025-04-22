package SinglyLinkedList_Q1_and_Q2;
public class Node<E> {
    E element;
    Node<E> next;

    Node() {
        this.element = null;
        this.next = null;
    }

    Node(E element) {
        this.element = element;
        this.next = null;
    }
}