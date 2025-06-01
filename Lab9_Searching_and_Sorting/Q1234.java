package Lab9_Searching_and_Sorting;
import java.util.Arrays;




public class Q1234 {

    public static void main(String[] args) {
        int[] arr = {10, 34, 2, 56, 7, 67, 88, 42};
        System.out.println("Q3: ");
        selectionSortSmallest(arr);
        System.out.println(Arrays.toString(arr));
        selectionSortLargest(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Q4: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    public static void selectionSortLargest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int largest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }
    }
}
