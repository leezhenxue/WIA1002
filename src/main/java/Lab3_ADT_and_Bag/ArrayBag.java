package Lab3_ADT_and_Bag;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        this.bag = (T[]) new Object[DEFAULT_CAPACITY];
        this.numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return this.numberOfEntries == DEFAULT_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return this.numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (!this.isFull()) {
            bag[this.numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        if (!isEmpty()) {
            T removedEntry = bag[this.numberOfEntries - 1];
            bag[this.numberOfEntries - 1] = null;
            this.numberOfEntries--;
            return removedEntry;
        }
        return null;

    }

    @Override
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

    @Override
    public void clear() {
        while (!isEmpty()) {
            this.remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int freq = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                freq++;
            }
        }
        return freq;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                found = true;
            }
        }
        return found;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] newArr = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            newArr[i] = bag[i];
        }
        return newArr;
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

    @Override
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

    @Override
    public BagInterface<T> difference(BagInterface<T> bag2) {
        BagInterface<T> newBag = new ArrayBag<>();
        T[] bag2Array = bag2.toArray();
        for (int i = 0; i < numberOfEntries; i++) {
            boolean duplicate = false;
            for (int j = 0; j < bag2Array.length; j++) {
                if (bag[i].equals(bag2Array[j])) {
                    duplicate = true;
                    bag2Array[j] = null; // Mark as processed to avoid duplicates
                    break;
                }
            }
            if (duplicate == false) {
                newBag.add(bag[i]);
            }
        }
        return newBag;
    }

}
