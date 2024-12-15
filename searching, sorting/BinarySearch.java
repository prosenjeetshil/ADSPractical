import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int start = 0, end = 9, mid, target;

        System.out.println("Enter 10 elements for the array in sorted order:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number you want to search:");
        target = sc.nextInt();

        mid = (start + end) / 2;
        while (start <= end) {
            if (arr[mid] == target) {
                System.out.println(target + " found at position " + mid);
                return;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        System.out.println("Number not found");
    }
}
