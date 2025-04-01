package Lab2.Q2;

public class CompareMax {
    public static void main(String[] args) {
        System.out.println(maximum(3, 5, 1));
    }

    public static <T extends Comparable<T>> T maximum(T element1, T element2, T element3) {
        if(element1.compareTo(element2) > 0 && element1.compareTo(element3) > 0) {
            return element1;
        }
        else if (element2.compareTo(element3) > 0) {
            return element2;
        }
        return element3;
    }
}
