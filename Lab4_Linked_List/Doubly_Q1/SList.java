package Doubly_Q1;

public class SList<E> {

    SNode<E> head;
    SNode<E> tail;
    int size;

    public SList() {
        head = null;
        tail = null;
        size = 0;
    }

    public SList(E e) {
        head = tail = new SNode<>(e);
        size = 1;
    }

    public void appendEnd(E e) {
        if (size == 0) {
            head = tail = new SNode<>(e);
        } else {
            SNode<E> node = new SNode<>(e);
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public E removeInitial() {
        SNode<E> temp = head;
        head = head.next;
        temp.next = null;
        return temp.element;
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void display() {
        SNode<E> current = head;
        while (current != null) {
            System.out.println(current.element);
            current = current.next;
        }
    }

}
