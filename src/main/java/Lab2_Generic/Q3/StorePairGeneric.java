package Lab2_Generic.Q3;

public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {

    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        StorePairGeneric<?> other = (StorePairGeneric<?>) obj;

        if (this.first == null || other.first == null) {
            return false;
        }

        char value1 = this.first.toString().charAt(0);
        char value2 = other.first.toString().charAt(0);

        return value1 == value2;
    }

    @Override
    public int compareTo(StorePairGeneric<T> other) {
        return this.first.compareTo(other.first);
    }

}
