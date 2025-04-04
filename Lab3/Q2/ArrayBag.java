package Lab3.Q2;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        this.bag = (T[]) new Object[DEFAULT_CAPACITY];
        this.numberOfEntries = 0;
    }

    public T[] getBag() {
        return this.bag;
    }

    public int getNumberOfEntries() {
        return this.numberOfEntries;
    }

    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    public boolean isFull() {
        return this.numberOfEntries == DEFAULT_CAPACITY;
    }

    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        if (!this.isFull()) {
            bag[this.numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    public T remove() {
        if (!isEmpty()) {
            T removedEntry = bag[this.numberOfEntries - 1];
            bag[this.numberOfEntries - 1] = null;
            this.numberOfEntries--;
            return removedEntry;
        }
        return null;

    }

    public boolean remove(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(bag, 0, numberOfEntries, null);
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                freq++;
            }
        }
        return freq;
    }

    public boolean contains(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.print(bag[i] + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(bag, numberOfEntries, bag.getClass());
    }

    @Override
    public BagInterface<T> union(BagInterface<T> otherBag) {
        ArrayBag<T> resultBag = new ArrayBag<>();

        // Add all items from this bag
        for (int i = 0; i < this.numberOfEntries; i++) {
            resultBag.add(this.bag[i]);
        }

        // Add all items from the other bag
        for (T item : otherBag.toArray()) {
            resultBag.add(item);
        }

        return resultBag;
    }

    public BagInterface<T> intersection(BagInterface<T> bag2) {
        ArrayBag<T> intersectionBag = new ArrayBag<>();
        T[] bag2Array = bag2.toArray();
        for (int i = 0; i < this.numberOfEntries; i++) {
            for (int j = 0; j < bag2Array.length; j++) {
                if (this.bag[i].equals(bag2Array[j])) {
                    intersectionBag.add(this.bag[i]);
                    bag2Array[j] = null; // Avoid duplicate matches
                    break;
                }
            }
        }
        return intersectionBag;
    }

}
