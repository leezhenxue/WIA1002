
import java.util.LinkedList;

public class MyQueue<E> {

    LinkedList<E> queue = new LinkedList<>();

    public MyQueue(E[] e) {
        for (E element : e) {
            this.queue.add(element);
        }
    }

    public MyQueue() {
        this.queue = null;
    }

    public void enqueue(E e) {
        this.queue.add(e);
    }

    public E dequeue() {
        return this.queue.removeLast();
    }

    public E getElement(int i) {
        return this.queue.get(i);
    }

    public E peek() {
        return this.queue.getLast();
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
}
