package Lab2.Q4;

public class Q4 {
    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }

    // Generic method to find the min and max values in an array
    public static <T extends Comparable<T>> String minmax(T[] array) {
        T min = array[0];
        T max = array[0];

        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return "Min = " + min + "  Max = " + max;
    }
}

