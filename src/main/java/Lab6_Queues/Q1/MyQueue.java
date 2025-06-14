package Lab6_Queues.Q1;

import java.util.LinkedList;

public class MyQueue<E> {
    LinkedList<E> queue;

    public MyQueue(E[] e) {
        this.queue = new LinkedList<>();
        for (E element : e) {
            this.queue.add(element);
        }
    }

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(E e) {
        this.queue.addLast(e);
    }

    public E dequeue() {
        return this.queue.removeFirst();
    }

    public E getElement(int i) {
        return this.queue.get(i);
    }

    public E peek() {
        return this.queue.getFirst();
    }

    public int getSize() {
        return this.queue.size();
    }

    public boolean contains(E e) {
        return this.queue.contains(e);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public String toString() {
        return this.queue.toString();
    }

    public boolean remove(E e) {
        return queue.remove(e);
    }
}
