package Lab6_Queues.Priority_Q3;

public class ComparableBook implements Comparable<ComparableBook> {
    private int code;
    private String name;

    public ComparableBook(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableBook other) {
        return this.code - other.code;
    }

    @Override
    public String toString() {
        return "Code: " + this.code + " Name: " + this.name;
    }

}
