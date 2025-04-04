package Lab3.Q2;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T>{
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
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }
    

    public T[] toArray() {
        T[] arr = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            arr[i] = bag[i];
        }
        return arr;
    }

    public BagInterface<T> union(BagInterface<T> bag2) {
        ArrayBag<T> unionBag = new ArrayBag<>();
        for (int i = 0; i < this.numberOfEntries; i++) {
            unionBag.add(this.bag[i]);
        }
        for (int i = 0; i < bag2.getNumberOfEntries(); i++) {
            unionBag.add(bag2.getBag()[i]);
        }
        return unionBag;
    }    

    public BagInterface<T> intersection(BagInterface<T> bag2) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (bag2.getBag().contains(this.bag[i])) {
                
            }
        }
    }

}

