import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int key;

        System.out.println("Enter 10 elements:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number you want to find:");
        key = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            if (arr[i] == key) {
                System.out.println("Your number is at position " + i + ".");
                return;
            }
        }

        System.out.println("The input number is not present in this array.");
    }
}
