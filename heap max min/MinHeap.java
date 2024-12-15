import java.util.Scanner;

public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int maxSize) {
        heap = new int[maxSize + 1]; // Indexing starts at 1
        size = 0;
    }

    private void minHeapify(int i) {
        int smallest = i;
        int left = 2 * i;  // Left child
        int right = 2 * i + 1; // Right child

        // Compare with left child
        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        // Compare with right child
        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        // Swap and recurse if the smallest is not the current node
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public void buildMinHeap() {
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void insert(int element) {
        heap[++size] = element;
    }

    public void printHeap() {
        System.out.println("Min Heap:");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        MinHeap minHeap = new MinHeap(n);

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            minHeap.insert(scanner.nextInt());
        }

        minHeap.buildMinHeap();
        minHeap.printHeap();

        scanner.close();
    }
}
