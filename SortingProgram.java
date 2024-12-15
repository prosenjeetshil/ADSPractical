import java.util.Scanner;

public class SortingProgram {

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                // Perform gapped insertion sort
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    // Function to display the array
    public static void displayArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Shell Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Insertion Sort
                    System.out.print("Enter the size of the array: ");
                    int insertionSize = scanner.nextInt();
                    int[] insertionArray = new int[insertionSize];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < insertionSize; i++) {
                        insertionArray[i] = scanner.nextInt();
                    }
                    insertionSort(insertionArray);
                    System.out.println("Sorted array using Insertion Sort:");
                    displayArray(insertionArray);
                    break;

                case 2:
                    // Shell Sort
                    System.out.print("Enter the size of the array: ");
                    int shellSize = scanner.nextInt();
                    int[] shellArray = new int[shellSize];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < shellSize; i++) {
                        shellArray[i] = scanner.nextInt();
                    }
                    shellSort(shellArray);
                    System.out.println("Sorted array using Shell Sort:");
                    displayArray(shellArray);
                    break;

                case 3:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 3);

        scanner.close();
    }
}
