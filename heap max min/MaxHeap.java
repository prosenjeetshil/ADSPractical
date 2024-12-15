import java.util.Scanner;

public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int maxSize) {
        heap = new int[maxSize + 1]; // Indexing starts at 1
        size = 0;
    }

    private void maxHeapify(int i) {
        int largest = i;
        int left = 2 * i;  // Left child
        int right = 2 * i + 1; // Right child

        // Compare with left child
        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }
        // Compare with right child
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }
        // Swap and recurse if the largest is not the current node
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    public void insert(int element) {
        heap[++size] = element;
    }

    public void printHeap() {
        System.out.println("Max Heap:");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        MaxHeap maxHeap = new MaxHeap(n);

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            maxHeap.insert(scanner.nextInt());
        }

        maxHeap.buildMaxHeap();
        maxHeap.printHeap();

        scanner.close();
    }
}
