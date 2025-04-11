package Lab2.Q6;

public class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list) {
        E minElem = list[0][0];

        for (E[] row : list) {
            for (E elem : row) {
                if (elem.compareTo(minElem) < 0) {
                    minElem = elem;
                }
            }
        }
        return minElem;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E maxElem = list[0][0];

        for (E[] row : list) {
            for (E elem : row) {
                if (elem.compareTo(maxElem) > 0) {
                    maxElem = elem;
                }
            }
        }
        return maxElem;
    }

    public static void main(String[] args) {
        Integer[][] intArr1 = {{4, 5, 6}, {1, 2, 3}};

        System.out.println("Minimum: " + min(intArr1));
        System.out.println("Maximum: " + max(intArr1));
    }
}
