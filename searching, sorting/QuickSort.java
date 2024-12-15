public class QuickSort {

    // Partition method to divide the array
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int count = 0;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                count++;
            }
        }

        int pivotIndex = start + count;
        swap(arr, pivotIndex, start);

        int i = start, j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < pivotIndex && j > pivotIndex) {
                swap(arr, i++, j--);
            }
        }

        return pivotIndex;
    }

    // Swap method to swap elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // QuickSort method to recursively sort the array
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = partition(arr, start, end);
        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 4, 2, 1, 8};
        int n = arr.length;

        // Display array before sorting
        System.out.print("Array before sorting: ");
        printArray(arr);

        // Perform QuickSort
        quickSort(arr, 0, n - 1);

        // Display array after sorting
        System.out.print("Array after sorting: ");
        printArray(arr);
    }
}
