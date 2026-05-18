import java.util.Arrays;

public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition using first element as pivot
    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];

        int i = start;
        int j = end;

        while (i < j) {

            // Move i right until element > pivot
            while (i <= end && arr[i] <= pivot) {
                i++;
            }

            // Move j left until element <= pivot
            while (arr[j] > pivot) {
                j--;
            }

            // Swap if i is still left of j
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Place pivot at correct position
        swap(arr, start, j);

        return j; // pivot index
    }

    // QuickSort recursion
    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int pivotIndex = partition(arr, start, end);

            quickSort(arr, start, pivotIndex - 1); // left part
            quickSort(arr, pivotIndex + 1, end);   // right part
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
//abcd
//bcda
//cdab
//dabc