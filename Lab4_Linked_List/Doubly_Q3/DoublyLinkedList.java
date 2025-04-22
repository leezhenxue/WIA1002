package Doubly_Q3;

public class DoublyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        }
        else {
            head.previous = new Node<>(e);
            head .previous.next = head;
            head = head.previous;
        }
        size++;
        System.out.println("adding: " + e);
    }

    public void addLast(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        }
        else {
            tail.next = new Node<>(e);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        System.out.println("adding: " + e);
    }

    public void addIndex(int index, E e) {
        if (index < 0 || index > size) {
            return;
        }
        else if (index == 0) {
            addFirst(e);
        }
        else if (index == size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(e);
            current.previous.next = newNode;
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous = newNode;
            size++;
            System.out.println("adding: " + e);
        }       
    }

    public void removeIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node<E> current = head;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        System.out.println("deleted: " + current.element);
    }

    public void traverseForward() {
        System.out.println("iterating forward..");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackward() {
        System.out.println("iterating backward..");
        Node<E> current = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.previous;
        }
        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        head = tail = null;
        System.out.println("successfully clear " + size + " node(s)");
        size = 0;
    }
}
