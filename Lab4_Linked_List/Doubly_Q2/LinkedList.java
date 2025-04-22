package Doubly_Q2;

public class LinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void add(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void removeElement(E e) {
        Node<E> current = head;
        if (head.element.equals(e)) {
            head = head.next;
            size--;
        }
        for (int i = 0; i < size - 1; i++) {
            if (current.next.element.equals(e)) {
                current.next = current.next.next;
                size--;
                break;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.element + ", ");
            }
            else {
                System.out.print(current.element + ".\n");
            }
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace(E e, E newE) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                current.element = newE;
            }
            current = current.next;
        }
    }

}
