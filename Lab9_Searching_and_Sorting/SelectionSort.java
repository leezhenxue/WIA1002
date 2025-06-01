
public class SelectionSort {
    int[] arr;

    public SelectionSort() {

    }

    public void selectionSortSmallest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    public void selectionSortLargest(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int largest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > largest) {
                    largest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }
    }
}
