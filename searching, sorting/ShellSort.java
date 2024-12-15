public class ShellSort {

    // Method for Shell Sort
    public static void shellSort(int[] arr, int n) {
        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 32, 2, 3};
        int n = arr.length;

        System.out.println("Array before sorting: ");
        printArray(arr, n);

        shellSort(arr, n);

        System.out.println("\nArray after sorting: ");
        printArray(arr, n);
    }
}
