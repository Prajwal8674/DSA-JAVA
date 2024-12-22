public class MergeSort {
    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        int len1 = mid - start + 1;
        int len2 = end - mid;


        int[] left = new int[len1];
        int[] right = new int[len2];


        for (int i = 0; i < len1; i++) {
            left[i] = arr[start + i];
        }


        for (int i = 0; i < len2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int index1 = 0;
        int index2 = 0;
        int mainArrayIndex = start;

        while (index1 < len1 && index2 < len2) {
            if (left[index1] <= right[index2]) {
                arr[mainArrayIndex++] = left[index1++];
            } else {
                arr[mainArrayIndex++] = right[index2++];
            }
        }

        while (index1 < len1) {
            arr[mainArrayIndex++] = left[index1++];
        }

        while (index2 < len2) {
            arr[mainArrayIndex++] = right[index2++];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
        int size = arr.length;

        mergeSort(arr, 0, size - 1);

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
