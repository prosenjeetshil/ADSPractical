import java.util.Scanner;

public class Queue {
    private int[] queue;
    private int front, rear, size;
    private int maxSize;

    // Constructor to initialize the queue
    public Queue(int size) {
        maxSize = size;
        queue = new int[size];
        front = -1;
        rear = -1;
        this.size = 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to enqueue an element
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue.");
        } else {
            if (front == -1) front = 0;
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            size++;
            System.out.println("Enqueued " + value + " into the queue.");
        }
    }

    // Method to dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        } else {
            int value = queue[front];
            front = (front + 1) % maxSize;
            size--;
            return value;
        }
    }

    // Method to peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            return queue[front];
        }
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(queue[rear]); // Display the last element
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking queue size as input
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        Queue queue = new Queue(size);

        // Taking input for operations
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Enqueue
                    System.out.print("Enter the value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;

                case 2: // Dequeue
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued value: " + dequeued);
                    }
                    break;

                case 3: // Peek
                    int frontValue = queue.peek();
                    if (frontValue != -1) {
                        System.out.println("Front value: " + frontValue);
                    }
                    break;

                case 4: // Display
                    queue.display();
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
