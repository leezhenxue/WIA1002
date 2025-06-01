package Lab5_Stacks.Q1_and_Q2;

import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E popElem = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return popElem;
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }

    public boolean search(E o) {
        return list.contains(o);
    }

}
