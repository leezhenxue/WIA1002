public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size; 

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e) {
        if (head == null) {
            head = tail = new Node<>(e);
        }
        else {
            Node<E> temp = head;
            head = new Node<>(e);
            head.next = temp;
        }
        size++;
    }

    public void addLast(E e) {
        if (tail == null) {
            head = tail = new Node<>(e);
        }
        else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(e);
        }
        else if (index >= size) {
            addLast(e);
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        Node<E> temp = head;
        head = head.next;
        size--;
        return temp.element;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        else if (size == 1) {
            E element = head.element;
            head = tail = null;
            size = 0;
            return element;
        }
        Node<E> current = head;
        for (int i = 0; i < size - 2; i++) {
            current = current.next;
        }
        Node<E> temp = current.next;
        tail = current;
        tail.next = null;
        size--;
        return temp.element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            Node<E> temp = previous.next;
            Node<E> current = temp.next;
            previous.next = current;
            size--;
            return temp.element; 
        }
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

    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.element;
    }

    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E temp = current.element;
        current.element = e;
        return temp;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void print() {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node<E> previous = null;
        Node<E> current = head;
        Node<E> next = null;
        tail = head; // The old head becomes the new tail
    
        while (current != null) {
            next = current.next;     // Step 1: Save next
            current.next = previous; // Step 2: Reverse the link
            previous = current;      // Step 3: Move previous forward
            current = next;          // Step 4: Move current forward
        }
    
        head = previous; // New head
    }
    
    
}
