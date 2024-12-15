import java.util.Arrays;
import java.util.Scanner;

public class SearchProgram {
    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return the index if key is found
            }
        }
        return -1; // Return -1 if key is not found
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid; // Return the index if key is found
            } else if (arr[mid] < key) {
                low = mid + 1; // Move to the right sub-array
            } else {
                high = mid - 1; // Move to the left sub-array
            }
        }
        return -1; // Return -1 if key is not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Linear Search
                    System.out.print("Enter the size of the array: ");
                    int size = scanner.nextInt();
                    int[] linearArray = new int[size];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < size; i++) {
                        linearArray[i] = scanner.nextInt();
                    }
                    System.out.print("Enter the key to search: ");
                    int linearKey = scanner.nextInt();
                    int linearResult = linearSearch(linearArray, linearKey);
                    if (linearResult != -1) {
                        System.out.println("Key found at index: " + linearResult);
                    } else {
                        System.out.println("Key not found in the array.");
                    }
                    break;

                case 2:
                    // Binary Search
                    System.out.print("Enter the size of the array: ");
                    int binarySize = scanner.nextInt();
                    int[] binaryArray = new int[binarySize];
                    System.out.println("Enter the elements of the array (unsorted):");
                    for (int i = 0; i < binarySize; i++) {
                        binaryArray[i] = scanner.nextInt();
                    }
                    // Sorting the array before performing binary search
                    Arrays.sort(binaryArray);
                    System.out.println("Sorted Array: " + Arrays.toString(binaryArray));
                    System.out.print("Enter the key to search: ");
                    int binaryKey = scanner.nextInt();
                    int binaryResult = binarySearch(binaryArray, binaryKey);
                    if (binaryResult != -1) {
                        System.out.println("Key found at index: " + binaryResult);
                    } else {
                        System.out.println("Key not found in the array.");
                    }
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
